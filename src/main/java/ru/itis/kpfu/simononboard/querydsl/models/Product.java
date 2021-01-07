package ru.itis.kpfu.simononboard.querydsl.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "products")
public class Product {
    @Id
    private ObjectId objectId;
    private String naming;
    private List<String> tags;
    @JsonSerialize(using = ToStringSerializer.class)
    private Type type;
    @JsonSerialize(using = ToStringSerializer.class)
    private Status status;

    private Double minPrice;
    private Byte minCount;
    private Double minWeight;
    //can be separate object
    private String producer;
    @DBRef
    private ResourceHolder resourceListHolder;
}
