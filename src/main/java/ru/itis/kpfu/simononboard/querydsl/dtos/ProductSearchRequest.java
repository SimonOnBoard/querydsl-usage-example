package ru.itis.kpfu.simononboard.querydsl.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {
    private String naming;
    private String producer;
    private Double minPrice;
    private List<String> tags;
}
