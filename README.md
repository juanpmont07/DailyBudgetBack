# DailyBudgetBack


CREATE DATABASE DailyBudget;

\c DailyBudget;

CREATE TABLE UserLogin (
  id UUID PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  user_id UUID REFERENCES User(id)
);

CREATE TABLE User (
  id UUID PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  salary DECIMAL(10,2) NOT NULL,
  saving_rule VARCHAR(50),
  user_id UUID REFERENCES UserLogin(id)
);

CREATE TABLE Category (
  id UUID PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  user_id UUID REFERENCES User(id)
);

CREATE TABLE FixedCost (
  id UUID PRIMARY KEY,
  description VARCHAR(100) NOT NULL,
  pay_date DATE NOT NULL,
  category_id UUID REFERENCES Category(id),
  value DECIMAL(10,2) NOT NULL,
  user_id UUID REFERENCES User(id)
);

CREATE TABLE Movements (
  id UUID PRIMARY KEY,
  description VARCHAR(100) NOT NULL,
  category_id UUID REFERENCES Category(id),
  date DATE NOT NULL,
  fixed_cost_id UUID REFERENCES FixedCost(id),
  value DECIMAL(10,2) NOT NULL,
  user_id UUID REFERENCES User(id)
);

#Crear imagen docker
docker build -t daily-budget-postgres-img .

#Ejecutar el contenedor
docker run --name daily-budget-postgres-cont -p 5432:5432 -d daily-budget-postgres-img

#Ejecutar el contenedor en el puerto 5432
docker run --name daily-budget-postgres-cont -p 5432:5432 -e POSTGRES_PASSWORD=admin_budget -d daily-budget-postgres-img

#Iniciar imagen
docker run daily-budget-postgres-img


ARQUITECTURA

Crear diagramas de secuencia en https://sequencediagram.org/

HEXAGONAL, 
CQS


MONO= 1
FLUX = **