package ru.itis.kpfu.simononboard.querydsl.constrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kpfu.simononboard.querydsl.dtos.ProductDto;
import ru.itis.kpfu.simononboard.querydsl.dtos.ProductSearchRequest;
import ru.itis.kpfu.simononboard.querydsl.services.ProductSearchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductSearchController {
    private final ProductSearchService productSearchService;

    @GetMapping("/products/search")
    public ResponseEntity<List<ProductDto>> getProductsByProductRequest(ProductSearchRequest productSearchRequest) {
        return ResponseEntity.ok(productSearchService.findBySearchRequest(productSearchRequest));
    }
}
