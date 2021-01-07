package ru.itis.kpfu.simononboard.querydsl.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "resources")
public class Resource {
    @Id
    private ObjectId objectId;
    private String link;
    private ResourceType resourceType;
}
