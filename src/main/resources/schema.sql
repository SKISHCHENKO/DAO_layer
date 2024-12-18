
-- Создание таблицы CUSTOMERS
CREATE TABLE CUSTOMERS (
    id SERIAL PRIMARY KEY,           -- Инкрементируемый первичный ключ
    name VARCHAR(100),               -- Имя пользователя
    surname VARCHAR(100),            -- Фамилия пользователя
    age INT,                         -- Возраст пользователя
    phone_number VARCHAR(15)         -- Номер телефона
);

-- Создание таблицы ORDERS
CREATE TABLE ORDERS (
    id SERIAL PRIMARY KEY,           -- Инкрементируемый первичный ключ
    date DATE,                       -- Дата заказа
    customer_id INT,                 -- Внешний ключ, ссылающийся на id из таблицы CUSTOMERS
    product_name VARCHAR(255),       -- Наименование товара
    amount INT,                      -- Количество товара
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)  -- Внешний ключ
);