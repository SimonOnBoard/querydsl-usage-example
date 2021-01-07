package ru.itis.kpfu.simononboard.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.kpfu.simononboard.querydsl.models.ResourceHolder;

public interface ResourceHolderRepository extends MongoRepository<ResourceHolder, ObjectId> {
}
