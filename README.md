## Задача «Слой DAO (Data Access Object)»  ##
Описание  

Шаг 1. Создайте Spring Boot приложение с зависимостями на два стартера — spring-boot-starter-jdbc и spring-boot-starter-web.  
Шаг 2. Перенесите скрипт создания таблицы в файл schema.sql, чтобы Spring Boot автоматически создавал таблицу.  
Шаг 3. Перенесите скрипт запроса из второго задания в папку resources. Перепишите скрипт так, чтобы он возвращал product_name для именованного параметра name(а не только для alexey), который вы будете передавать в методы выполнения скрипта NamedParameterJdbcTemplate вместе со скриптом запроса.  
Шаг 4. Напишите репозиторий для работы с БД.  

Создайте класс и пометьте его аннотацией Repository, либо создайте бин репозитория в Java Config классе.  
Добавьте в поле класса String, которое содержит ваше содержание вашего скрипта. Само содержание вы можете считать с помощью кода ниже. Вам надо будет передать в метод read название вашего скрипта, который лежит в папке resources. Например так: read(myScript.sql).
Создайте метод getProductName(String name), который будет принимать имя и возвращать название продукта из базы данных.  
private static String read(String scriptFileName) {  
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();  
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {  
            return bufferedReader.lines().collect(Collectors.joining("\n"));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
    }  
Шаг 5. Напишите контроллер с методом-обработчиком GET-метода запроса с маппингом на endpoint /products/fetch-product. В query params запроса будет приходить строковый параметр name, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида localhost:8080/products/fetch-product?name=Ivan. Контроллер должен будет возвращать название продукта, которое он получит от репозитория.  
Шаг 6. Написанный код выложите в отдельный репозиторий на GitHub и прикрепите ссылку на него в комментарий к домашнему заданию.  

## Для работы необходимо: ##
-Postgres
CREATE DATABASE my_new_db;

INSERT INTO customers (name, surname, age, phone_number)  
VALUES ('Ivan', 'Ivanov', 30, '123-456-7890');  

INSERT INTO orders (date, customer_id, product_name, amount)  
VALUES (CURRENT_DATE, 1, 'orange', 1);  