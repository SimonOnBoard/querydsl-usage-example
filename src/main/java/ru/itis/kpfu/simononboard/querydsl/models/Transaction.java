package ru.itis.kpfu.simononboard.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private ObjectId objectId;
    @DBRef
    private List<ProductUnit> productList;
    private String shopName;
    private LocalDateTime date;
}
