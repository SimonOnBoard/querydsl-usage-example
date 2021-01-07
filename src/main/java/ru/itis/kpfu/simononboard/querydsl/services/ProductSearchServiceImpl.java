package ru.itis.kpfu.simononboard.querydsl.services;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.kpfu.simononboard.querydsl.dtos.ProductDto;
import ru.itis.kpfu.simononboard.querydsl.dtos.ProductSearchRequest;
import ru.itis.kpfu.simononboard.querydsl.models.QProduct;
import ru.itis.kpfu.simononboard.querydsl.repositories.ProductRepository;
import com.querydsl.core.types.Predicate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ru.itis.kpfu.simononboard.querydsl.models.QProduct.product;

@Service
@RequiredArgsConstructor
public class ProductSearchServiceImpl implements ProductSearchService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> findBySearchRequest(ProductSearchRequest productSearchRequest) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (productSearchRequest.getProducer() != null) {
            booleanBuilder.or(product.producer.isNotEmpty().and(product.producer.containsIgnoreCase(productSearchRequest.getProducer())));
        }
        if (productSearchRequest.getNaming() != null) {
            booleanBuilder.or(product.naming.isNotEmpty().and(product.naming.containsIgnoreCase(productSearchRequest.getNaming())));
        }
        if (productSearchRequest.getMinPrice() != null) {
            booleanBuilder.or(product.minPrice.isNotNull().and(product.minPrice.goe(productSearchRequest.getMinPrice())));
        }
        if (productSearchRequest.getTags() != null) {
            buildListPredicate(booleanBuilder, productSearchRequest.getTags());
        }

        Predicate predicate = booleanBuilder.getValue();
        if (predicate != null) {
            return StreamSupport.stream(productRepository.findAll(predicate).spliterator(), true)
                    .map(ProductDto::from)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    private void buildListPredicate(BooleanBuilder booleanBuilder, List<String> tags) {
        //только потому что это объект booleanExpression нельзя создать ни при помощи конструктора ни при побощи статического метода
        BooleanExpression booleanExpression = product.tags.contains(tags.get(0));
        if (tags.size() != 1) {
            for (int i = 1; i < tags.size(); i++) {
                booleanExpression = booleanExpression.and(product.tags.contains(tags.get(i)));
            }
        }
        booleanBuilder.or(booleanExpression);
    }
}
