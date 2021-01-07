package ru.itis.kpfu.simononboard.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "units")
public class ProductUnit {
    @Id
    private ObjectId objectId;
    @DBRef
    private Product product;
    private Integer count;
    private Double cost;
    private Double discount;
}
