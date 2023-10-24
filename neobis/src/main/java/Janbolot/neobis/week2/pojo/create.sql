CREATE TABLE product (
                       product_id serial,
                       product_name VARCHAR(50),
                       product_price INTEGER
);

CREATE TABLE orders (
                       order_id serial,
                       order_product VARCHAR(100)
);

CREATE TABLE customer (
                       customer_id serial,
                       customer_name VARCHAR(50)
);