CREATE TABLE IF NOT EXISTS article (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200),
    price NUMERIC(10,2) NOT NULL,
    model VARCHAR(10)
    );