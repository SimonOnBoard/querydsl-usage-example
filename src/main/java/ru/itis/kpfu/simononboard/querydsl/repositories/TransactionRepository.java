package ru.itis.kpfu.simononboard.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.kpfu.simononboard.querydsl.models.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {
}
