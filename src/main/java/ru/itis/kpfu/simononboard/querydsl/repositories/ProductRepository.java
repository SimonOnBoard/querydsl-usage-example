package ru.itis.kpfu.simononboard.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import ru.itis.kpfu.simononboard.querydsl.models.Product;
import ru.itis.kpfu.simononboard.querydsl.models.QProduct;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, ObjectId>, QuerydslPredicateExecutor<Product>, QuerydslBinderCustomizer<QProduct> {
    @Query("{ tags: { $size: ?0 , $in: ?1}, status: 'AVAILABLE' }")
    List<Product> findAllByTagsSizeAndTagsContains(int count, List<String> tags);


    default void customize(QuerydslBindings querydslBindings, QProduct qProduct) {

    }
}
