# Mapping_SpringBoot

This project demonstrates the mapping between entities using JPA and Spring Data JPA. It provides examples of establishing relationships such as one-to-one, one-to-many, many-to-one, and many-to-many between different entities.

## Frameworks and Language Used

* Java

* Spring Boot

* Spring Data JPA

* Hibernate

* MySQL



## Data Flow

The data flow in this project follows the typical MVC (Model-View-Controller) pattern, with the following components:

* Controller: Handles incoming requests, performs data validation, and calls the appropriate service methods.

* Service: Contains the business logic, performs necessary transformations, and interacts with the repository for data persistence.

* Repository: Provides an interface for database operations and utilizes Spring Data JPA to perform CRUD operations on the entities.

* Database: Stores the data in a relational database.

## Entity Overview

The project includes the following entities:

1. Student: Represents a student with attributes like ID, name, age, phone number, branch, and department.

2. Address: Represents the address of a student with attributes like landmark, zip code, district, state, and country. The Address entity is embedded within the Student entity.

3. Book: Represents a book with attributes like ID, title, author, and publication date.

4. Course: Represents a course with attributes like ID, name, and description.

5. Laptop: Represents a laptop with attributes like ID, brand, model, and price.

## Entity Relationships

The entities in this project have the following relationships:

* Student-Address: One-to-One relationship. Each student has one address.

* Student-Book: Many-to-Many relationship. A student can have multiple books, and a book can be associated with multiple students.

* Student-Course: Many-to-Many relationship. A student can be enrolled in multiple courses, and a course can have multiple students.

* Student-Laptop: One-to-Many relationship. Each student can have multiple laptops, but a laptop can be associated with only one student.

## Project Summary

This project provides examples of mapping entities using JPA and Spring Data JPA, including various relationships such as one-to-one, one-to-many, many-to-one, and many-to-many.

By following the CRUD operation examples provided for each entity, you can perform operations such as creating new records, retrieving entity information, updating entity details, and deleting entities.
