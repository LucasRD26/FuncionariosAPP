# Gestión de Funcionarios – Recursos Humanos UdeA Digital

## Descripción

Aplicación de escritorio desarrollada en **Java Swing** para la gestión de funcionarios del área de Recursos Humanos de la Institución Universitaria Digital de Antioquia. Permite realizar operaciones CRUD (crear, listar, actualizar y eliminar) sobre los funcionarios, incluyendo la gestión de sus datos personales, grupo familiar y formación académica, cumpliendo con el patrón DAO y manejo seguro de excepciones.

> **Contexto:**  
> El área de recursos humanos de la Institución Universitaria Digital de Antioquia gestiona los datos personales de los funcionarios (tipo de identificación, número, nombres, apellidos, estado civil, sexo, dirección, teléfono, fecha de nacimiento), su grupo familiar (incluyendo el rol de cada miembro) y su información académica (universidad, nivel de estudio, título).

---

## :books: Contenido

- [Modelo Relacional](#modelo-relacional)
- [Requisitos](#requisitos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Uso de la Aplicación](#uso-de-la-aplicación)
- [Capturas de Pantalla](#capturas-de-pantalla)
- [Créditos](#créditos)

---

## :card_file_box: Modelo Relacional

El modelo relacional incluye las siguientes tablas:

- **funcionario:** Datos personales del funcionario.
- **tipo_documento:** Tipos de documento de identificación.
- **estado_civil:** Estados civiles posibles.
- **grupo_familiar:** Miembros del grupo familiar de cada funcionario.
- **formacion_academica:** Estudios académicos de cada funcionario.

Consulta el archivo [`database/schema.sql`](database/schema.sql) para ver la estructura detallada.

---

## :gear: Requisitos

- **Java 8** o superior
- **MySQL** o **MariaDB** 
- **IDE Java** (Eclipse, IntelliJ, NetBeans, etc.)
- **JDBC Driver** para tu motor de base de datos

---

## :file_folder: Estructura del Proyecto

/crud-funcionarios/
│
├── database/
│ ├── schema.sql
│ └── seed.sql
│
├── src/
│ ├── dao/
│ ├── dto/
│ ├── model/
│ ├── util/
│ ├── controller/
│ └── view/
│
├── resources/
│ └── config.properties
│
└── README.md


---

## :rocket: Instalación y Ejecución

1. **Clona o descarga este repositorio.**

2. **Crea la base de datos:**
   - Ejecuta `database/schema.sql` en tu motor de base de datos para crear las tablas.
   - Ejecuta `database/seed.sql` para poblar las tablas con datos iniciales.

3. **Configura la conexión:**
   - Edita `resources/config.properties` con los datos de tu base de datos (usuario, contraseña, URL).

4. **Compila y ejecuta la aplicación:**
   - Desde tu IDE, ejecuta la clase `FuncionarioView.java` (ubicada en `src/view/`).

---

## :computer: Uso de la Aplicación

- **Crear funcionario:** Ingresa los datos y haz clic en "Crear".
- **Listar funcionarios:** Los funcionarios existentes se muestran en la tabla.
- **Actualizar funcionario:** Selecciona un funcionario de la tabla, edita los campos y haz clic en "Actualizar".
- **Eliminar funcionario:** Selecciona un funcionario y haz clic en "Eliminar".
- **Limpiar campos:** Haz clic en "Limpiar" para vaciar el formulario.

> **Nota:** Los campos de tipo de documento y estado civil se ingresan por su ID

---

## :star: Créditos

Desarrollado por:  
**[Lucas Rodriguez]**  
Asignatura: Desarrollo de Software Seguro  
Institución Universitaria Digital de Antioquia


> Proyecto realizado como parte de la actividad de la asignatura **Desarrollo de Software Seguro**.
