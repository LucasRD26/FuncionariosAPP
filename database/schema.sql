-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS recursos_humanos 
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_spanish_ci;

USE recursos_humanos;

-- Tablas de catálogo (lookup tables)
CREATE TABLE IF NOT EXISTS estado_civil (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS tipo_documento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- Tabla principal de funcionarios
CREATE TABLE IF NOT EXISTS funcionario (
    id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    tipo_identificacion INT NOT NULL,
    numero_identificacion VARCHAR(20) UNIQUE NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    estado_civil INT NOT NULL,
    sexo ENUM('M', 'F', 'O') NOT NULL,
    direccion VARCHAR(100),
    telefono VARCHAR(15),
    fecha_nacimiento DATE NOT NULL,
    
    -- Restricciones de clave foránea
    FOREIGN KEY (tipo_identificacion) 
        REFERENCES tipo_documento(id)
        ON UPDATE CASCADE,
        
    FOREIGN KEY (estado_civil) 
        REFERENCES estado_civil(id)
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tablas relacionadas
CREATE TABLE IF NOT EXISTS grupo_familiar (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_funcionario INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    parentesco VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    
    FOREIGN KEY (id_funcionario) 
        REFERENCES funcionario(id_funcionario)
        ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS formacion_academica (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_funcionario INT NOT NULL,
    universidad VARCHAR(100) NOT NULL,
    nivel_estudio VARCHAR(50) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    fecha_graduacion DATE,
    
    FOREIGN KEY (id_funcionario) 
        REFERENCES funcionario(id_funcionario)
        ON DELETE CASCADE
) ENGINE=InnoDB;