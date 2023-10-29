CREATE TABLE Products (
    productId SERIAL PRIMARY KEY,
    productName VARCHAR(255),
    productPrice DOUBLE PRECISION
);

CREATE TABLE customer (
                       customer_id INTEGER PRIMARY KEY,
                       customer_name VARCHAR(50)
);
