CREATE DATABASE DailyBudget;

\c DailyBudget;

CREATE TABLE Users (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    saving_rule VARCHAR(50),
    user_type VARCHAR(30)
);

CREATE TABLE UserLogin (
    user_id UUID PRIMARY KEY REFERENCES Users(id),
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Category (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id UUID REFERENCES Users(id)
);

CREATE TABLE FixedPayment (
    id UUID PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    pay_date DATE NOT NULL,
    category_id UUID REFERENCES Category(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES Users(id)
);

CREATE TABLE Movements (
    id UUID PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    category_id UUID REFERENCES Category(id),
    date DATE NOT NULL,
    fixe_payment_id UUID REFERENCES FixedPayment(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES Users(id)
);