package ru.itis.kpfu.simononboard.querydsl.services;

import ru.itis.kpfu.simononboard.querydsl.dtos.ProductDto;
import ru.itis.kpfu.simononboard.querydsl.dtos.ProductSearchRequest;

import java.util.List;

public interface ProductSearchService {
    List<ProductDto> findBySearchRequest(ProductSearchRequest productSearchRequest);

}
