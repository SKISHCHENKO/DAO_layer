package com.example.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Конструктор для внедрения NamedParameterJdbcTemplate
    public ProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // Метод для выполнения SQL-запроса с именованным параметром :name
    public String findProductNameByCustomerName(String name, String script) {
        // Создаем MapSqlParameterSource и передаем параметр
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        // Выполняем запрос с использованием именованных параметров
         return namedParameterJdbcTemplate.queryForObject(script, params, String.class);
    }
}