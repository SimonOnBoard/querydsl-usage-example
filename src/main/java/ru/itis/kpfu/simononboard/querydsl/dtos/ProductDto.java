package ru.itis.kpfu.simononboard.querydsl.dtos;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.kpfu.simononboard.querydsl.models.Product;
import ru.itis.kpfu.simononboard.querydsl.models.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String naming;
    private List<String> tags;
    @JsonSerialize(using = ToStringSerializer.class)
    private Status status;
    private String producer;

    public static ProductDto from(Product product) {
        return  ProductDto.builder()
                .naming(product.getNaming())
                .tags(product.getTags())
                .producer(product.getProducer())
                .status(product.getStatus())
                .build();
    }
}
