package com.example.service;

import com.example.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final String script;

    // Конструктор для внедрения зависимостей
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.script = read("myScript.sql"); // Загрузка скрипта при создании объекта
    }

    // Метод для чтения содержимого SQL-скрипта
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Error reading script file: " + scriptFileName, e);
        }
    }

    // Метод для получения названия продукта по имени клиента
    public String getProductName(String name) {
        return productRepository.findProductNameByCustomerName(name, this.script);
    }

}