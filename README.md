# Volley Reservation System – Spring Boot Application

Ce projet est une application **backend de réservation de terrains de volley**, développée avec **Spring Boot**, **Spring Data JPA (Hibernate)** et **MySQL**.

L’objectif est de gérer les **utilisateurs**, les **terrains** et les **réservations**, en respectant une architecture propre basée sur l’ORM (**JPA**) et **sans requêtes SQL natives**.

---

## Fonctionnalités principales

### Gestion des utilisateurs
- Création et gestion des utilisateurs
- Un utilisateur peut être associé à **plusieurs réservations**

### Gestion des terrains
- Création et gestion des terrains de volley
- Chaque terrain possède un **nom** et un **type**
- Un terrain peut être réservé plusieurs fois à des horaires différents

### Gestion des réservations
- Création de réservations avec :
  - une date
  - une heure de début et de fin
  - un motif
- Une réservation est liée à :
  - un utilisateur
  - un terrain
- Vérification de la cohérence des données via **JPA**

---

## Persistance des données

- Utilisation de **Spring Data JPA / Hibernate**
- Mapping objet–relationnel entre les entités Java et les tables **MySQL**
- **Aucune requête SQL native** (respect des consignes ORM / JPA)

---

## Structure du projet

- `model` : entités JPA (**Utilisateur**, **Terrain**, **Reservation**)
- `repository` : interfaces `JpaRepository`
- `controller` : endpoints REST
- `application.properties` : configuration de la base de données et de JPA

---

## Technologies utilisées

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**
- **MySQL Workbench**

---

## Base de données

La base de données MySQL contient les tables suivantes :
- **UTILISATEUR**
- **TERRAIN**
- **RESERVATION**

Relations gérées via JPA :
- Un utilisateur peut avoir plusieurs réservations
- Un terrain peut avoir plusieurs réservations
- Chaque réservation est liée à un utilisateur et à un terrain

---

## Configuration de la base de données

Exemple de configuration dans `application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/volley_reservation
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## Objectif pédagogique du projet

Ce projet permet de :

- **Comprendre le fonctionnement de JPA / Hibernate**
- **Maîtriser les relations entre entités** (`@OneToMany`, `@ManyToOne`)
- **Connecter une application Spring Boot à une base de données MySQL**
- **Appliquer une architecture backend propre et maintenable**
