USE recursos_humanos;

-- Poblar tabla tipo_documento
INSERT INTO tipo_documento (tipo) VALUES
('Cédula de Ciudadanía'),
('Tarjeta de Identidad'),
('Cédula de Extranjería'),
('Pasaporte');

-- Poblar tabla estado_civil
INSERT INTO estado_civil (nombre) VALUES
('Soltero'),
('Casado'),
('Divorciado'),
('Viudo');

-- Poblar tabla funcionario
INSERT INTO funcionario (
    tipo_identificacion, numero_identificacion, nombres, apellidos,
    estado_civil, sexo, direccion, telefono, fecha_nacimiento
) VALUES
(1, '123456789', 'Ana María', 'Pérez Gómez', 2, 'F', 'Calle 123 #45-67', '3001234567', '1985-04-23'),
(2, '987654321', 'Carlos Andrés', 'López Ruiz', 1, 'M', 'Carrera 89 #12-34', '3109876543', '1990-09-15');

-- Poblar tabla grupo_familiar
INSERT INTO grupo_familiar (id_funcionario, nombre, parentesco, fecha_nacimiento) VALUES
(1, 'Juan Pablo Pérez', 'Hijo', '2010-05-10'),
(1, 'Luis Fernando Gómez', 'Esposo', '1983-01-20'),
(2, 'María Fernanda López', 'Hija', '2015-07-21');

-- Poblar tabla formacion_academica
INSERT INTO formacion_academica (id_funcionario, universidad, nivel_estudio, titulo, fecha_graduacion) VALUES
(1, 'Universidad de Antioquia', 'Pregrado', 'Ingeniería de Sistemas', '2008-12-10'),
(1, 'Universidad Nacional', 'Maestría', 'Maestría en Informática', '2012-06-15'),
(2, 'Politécnico Jaime Isaza Cadavid', 'Tecnología', 'Tecnología en Gestión Empresarial', '2011-11-30');
