CREATE DATABASE DailyBudget;

\c DailyBudget;

CREATE TABLE Users (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    saving_rule VARCHAR(100),
    user_type VARCHAR(50)
);

CREATE TABLE UserLogin (
    user_id UUID PRIMARY KEY REFERENCES Users(id),
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Category (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    user_id UUID REFERENCES Users(id)
);

CREATE TABLE FixedPayment (
    id UUID PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    pay_date DATE NOT NULL,
    category_id UUID REFERENCES Category(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES Users(id)
);

CREATE TABLE Movements (
    id UUID PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    category_id UUID REFERENCES Category(id),
    date DATE NOT NULL,
    fixed_payment_id UUID REFERENCES FixedPayment(id),
    value DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES Users(id)
);

INSERT INTO Users (id, name, salary, saving_rule, user_type)
VALUES
  ('550e8400-e29b-41d4-a716-446655440001', 'John Doe', 60000.00, 'Regla de ahorro estándar', 'Empleado'),
  ('550e8400-e29b-41d4-a716-446655440002', 'Alice Johnson', 75000.00, 'Plan de inversión a largo plazo', 'Empleado'),
  ('550e8400-e29b-41d4-a716-446655440003', 'Michael Smith', 80000.00, 'Ahorro para educación de los hijos', 'Empleado'),
  ('550e8400-e29b-41d4-a716-446655440004', 'Emily Brown', 55000.00, 'Fondo de emergencia', 'Empleado'),
  ('550e8400-e29b-41d4-a716-446655440005', 'David Lee', 70000.00, 'Ahorro para vacaciones', 'Empleado');

INSERT INTO UserLogin (user_id, username, password)
VALUES
  ('550e8400-e29b-41d4-a716-446655440001', 'johndoe', 'password123'),
  ('550e8400-e29b-41d4-a716-446655440002', 'alicejohnson', 'securepass'),
  ('550e8400-e29b-41d4-a716-446655440003', 'michaelsmith', 'myp@ssword'),
  ('550e8400-e29b-41d4-a716-446655440004', 'emilybrown', 'changeme'),
  ('550e8400-e29b-41d4-a716-446655440005', 'davidlee', 'ilovecoding');

INSERT INTO Category (id, name, user_id)
VALUES
  ('550e8400-e29b-41d4-a716-446655440006', 'Alimentación', '550e8400-e29b-41d4-a716-446655440001'),
  ('550e8400-e29b-41d4-a716-446655440007', 'Transporte', '550e8400-e29b-41d4-a716-446655440002'),
  ('550e8400-e29b-41d4-a716-446655440008', 'Vivienda', '550e8400-e29b-41d4-a716-446655440003'),
  ('550e8400-e29b-41d4-a716-446655440009', 'Entretenimiento', '550e8400-e29b-41d4-a716-446655440004'),
  ('550e8400-e29b-41d4-a716-446655440010', 'Salud', '550e8400-e29b-41d4-a716-446655440005');

INSERT INTO FixedPayment (id, description, pay_date, category_id, value, user_id)
VALUES
  ('550e8400-e29b-41d4-a716-446655440011', 'Pago Hipoteca', '2023-11-01', '550e8400-e29b-41d4-a716-446655440008', 1200.00, '550e8400-e29b-41d4-a716-446655440003'),
  ('550e8400-e29b-41d4-a716-446655440012', 'Pago de Auto', '2023-11-02', '550e8400-e29b-41d4-a716-446655440007', 300.00, '550e8400-e29b-41d4-a716-446655440002'),
  ('550e8400-e29b-41d4-a716-446655440013', 'Facturas de Energía', '2023-11-03', '550e8400-e29b-41d4-a716-446655440006', 150.00, '550e8400-e29b-41d4-a716-446655440001'),
  ('550e8400-e29b-41d4-a716-446655440014', 'Gastos Médicos', '2023-11-04', '550e8400-e29b-41d4-a716-446655440010', 200.00, '550e8400-e29b-41d4-a716-446655440005'),
  ('550e8400-e29b-41d4-a716-446655440015', 'Suscripción a Servicios de Streaming', '2023-11-05', '550e8400-e29b-41d4-a716-446655440009', 20.00, '550e8400-e29b-41d4-a716-446655440004');

INSERT INTO Movements (id, description, category_id, date, fixed_payment_id, value, user_id)
VALUES
  ('550e8400-e29b-41d4-a716-446655440016', 'Compras de comestibles', '550e8400-e29b-41d4-a716-446655440009', '2023-11-01', '550e8400-e29b-41d4-a716-446655440011', 50.00, '550e8400-e29b-41d4-a716-446655440001'),
  ('550e8400-e29b-41d4-a716-446655440017', 'Combustible', '550e8400-e29b-41d4-a716-446655440009', '2023-11-02', '550e8400-e29b-41d4-a716-446655440012', 70.00, '550e8400-e29b-41d4-a716-446655440002'),
  ('550e8400-e29b-41d4-a716-446655440018', 'Pago del médico', '550e8400-e29b-41d4-a716-446655440010', '2023-11-03', '550e8400-e29b-41d4-a716-446655440013', 90.00, '550e8400-e29b-41d4-a716-446655440005'),
  ('550e8400-e29b-41d4-a716-446655440019', 'Gastos del cine', '550e8400-e29b-41d4-a716-446655440006', '2023-11-04', '550e8400-e29b-41d4-a716-446655440014', 60.00, '550e8400-e29b-41d4-a716-446655440004'),
  ('550e8400-e29b-41d4-a716-446655440020', 'Cena en restaurante', '550e8400-e29b-41d4-a716-446655440006', '2023-11-05', '550e8400-e29b-41d4-a716-446655440015', 80.00, '550e8400-e29b-41d4-a716-446655440005');