package ru.itis.kpfu.simononboard.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.kpfu.simononboard.querydsl.models.ProductUnit;

import java.util.Optional;

public interface ProductUnitRepository extends MongoRepository<ProductUnit, ObjectId> {
    Optional<ProductUnit> findByCountLessThanAndCostGreaterThanAndDiscount(Integer count, Double cost, Double discount);
}
