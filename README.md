# Plataforma Educativa API

API REST para la gestión de una plataforma educativa, desarrollada con Java y Spring Boot.

## 🛠️ Tecnologías
* **Java 17**
* **Spring Boot 3.5.14**
* **Spring Data JPA**
* **MySQL**
* **Lombok**
* **Maven**
* **Spring Security**

##  Funcionalidades
Actualmente el proyecto se encuentra en desarrollo. Se implementará:

- [ ] CRUD de estudiantes
- [ ] CRUD de profesores
- [ ] CRUD de cursos
- [ ] Relación entre estudiantes, profesores y cursos
- [ ] Autenticación y autorización mediante roles y permisos

##  Arquitectura
El proyecto utiliza una estructura por capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Los DTOs se manejarán mediante **Java Records** para separar los datos de entrada/salida de las entidades JPA.

##  Objetivo
Construir una API REST aplicando buenas prácticas de desarrollo backend, manejo de relaciones entre entidades y seguridad basada en roles y permisos.
