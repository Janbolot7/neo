CREATE TABLE product (
                       product_id INTEGER PRIMARY KEY,
                       product_name VARCHAR(50),
                       product_price INTEGER
);

CREATE TABLE orders (
                       order_id INTEGER PRIMARY KEY,
                       order_product VARCHAR(100),
                       customer_id INTEGER, FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE TABLE customer (
                       customer_id INTEGER PRIMARY KEY,
                       customer_name VARCHAR(50)
);
