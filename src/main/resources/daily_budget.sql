CREATE DATABASE DailyBudget;

\c DailyBudget;

CREATE TABLE UserInfo (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    saving_rule VARCHAR(50),
    user_type VARCHAR(30)
);

CREATE TABLE UserLogin (
    user_id UUID PRIMARY KEY REFERENCES UserInfo(id),
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Category (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id UUID REFERENCES UserInfo(id)
);

CREATE TABLE FixedCost (
    id UUID PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    pay_date DATE NOT NULL,
    category_id UUID REFERENCES Category(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES UserInfo(id)
);

CREATE TABLE Movements (
    id UUID PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    category_id UUID REFERENCES Category(id),
    date DATE NOT NULL,
    fixed_cost_id UUID REFERENCES FixedCost(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES UserInfo(id)
);