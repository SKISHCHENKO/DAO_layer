package com.example.controller;

import com.example.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    // Конструктор для внедрения ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Обработчик запроса GET /products/fetch-product
    @GetMapping("/products/fetch-product")
    public String fetchProduct(@RequestParam String name) {
        return productService.getProductName(name);
    }
}