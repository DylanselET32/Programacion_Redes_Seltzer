-- Dropear la base de datos si existe
DROP DATABASE IF EXISTS sistemaTienda;

-- Crear la base de datos sistemaTienda
CREATE DATABASE sistemaTienda;

-- Usar la base de datos sistemaTienda
USE sistemaTienda;

-- Crear la tabla stock
CREATE TABLE IF NOT EXISTS stock (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio_compra DECIMAL(10, 2) NOT NULL,
    precio_venta DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    discontinuo BOOLEAN NOT NULL
);

-- Insertar herramientas con precios más elevados
INSERT INTO stock (nombre, descripcion, precio_compra, precio_venta, cantidad, discontinuo)
VALUES 
    ('Taladro Percutor Industrial', 'Taladro percutor de alta potencia para uso industrial.', 6000.00, 12000.00, 100, 0),
    ('Juego de Llaves de Impacto', 'Juego completo de llaves de impacto de alta resistencia.', 8000.00, 16000.00, 80, 0),
    ('Sierra Circular de Precisión', 'Sierra circular con sistema de corte de alta precisión.', 7500.00, 15000.00, 120, 0),
    ('Compresor de Aire de 100 Litros', 'Compresor de aire de gran capacidad para herramientas neumáticas.', 12000.00, 24000.00, 50, 0),
    ('Soldadora de Arco Profesional', 'Soldadora de arco para trabajos de soldadura pesada.', 9000.00, 18000.00, 70, 0),
    ('Generador Eléctrico de 5000W', 'Generador eléctrico de gran potencia para uso industrial.', 15000.00, 30000.00, 30, 0),
    ('Caja de Herramientas Profesional', 'Caja con un completo juego de herramientas de alta calidad.', 10000.00, 20000.00, 150, 0),
    ('Martillo Demoledor de 20 Kg', 'Martillo demoledor de gran potencia para trabajos pesados.', 8000.00, 16000.00, 60, 0),
    ('Torno de Banco de Precisión', 'Torno de banco para trabajos de precisión en metalurgia.', 9500.00, 19000.00, 40, 0),
    ('Detector de Metales Profesional', 'Detector de metales de alta sensibilidad y precisión.', 6500.00, 13000.00, 90, 0);
