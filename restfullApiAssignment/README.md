# RESTful API Assignment - Product Management System

## Project Description
A Spring Boot RESTful API for managing products in an e-commerce system. The API provides CRUD operations and advanced search functionality for products by category, brand, or both.

## Technologies Used
- Java 21
- Spring Boot 3.2.0
- Spring Data JPA
- PostgreSQL
- Maven

## Features
- Add new products
- Get all products
- Get product by ID
- Update product
- Delete product
- Search products by category
- Search products by brand
- Search products by both category and brand

## API Endpoints

### Product CRUD Operations
- **POST** `/api/products/addProduct` - Add a new product
- **GET** `/api/products` - Get all products
- **GET** `/api/products/{id}` - Get product by ID
- **PUT** `/api/products/{id}` - Update product
- **DELETE** `/api/products/{id}` - Delete product

### Search Operations
- **GET** `/api/products/search?category={category}` - Search by category
- **GET** `/api/products/searchByBrand?brand={brand}` - Search by brand
- **GET** `/api/products/searchByCategoryAndBrand?category={category}&brand={brand}` - Search by both

## Setup Instructions
1. Clone the repository
2. Configure PostgreSQL database in `application.properties`
3. Run `mvn clean install`
4. Start the application: `mvn spring-boot:run`
5. Application runs on `http://localhost:8081`

## Screenshots

### Search by Category
![Search by Category](screenshots/search-by-category.png)

### Search by Brand
![Search by Brand](screenshots/search-by-brand.png)

### Search by Category and Brand
![Search by Category and Brand](screenshots/search-by-category-and-brand.png)
