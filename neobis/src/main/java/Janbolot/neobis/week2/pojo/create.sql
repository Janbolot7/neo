CREATE TABLE Products (
    productId BIGSERIAL PRIMARY KEY,
    productName VARCHAR(255),
    productPrice DOUBLE PRECISION
);

CREATE TABLE Users (
    userId BIGSERIAL PRIMARY KEY,
    role VARCHAR(255),
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(20),
    password VARCHAR(255)
);

