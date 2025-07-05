# ShopApp

**ShopApp** is a Java-based web application for managing an online clothing shop. It allows administrators to manage products, customers, and sales efficiently through a simple user interface.

## 🛍️ Features

- Add and manage clothing products (e.g. shoes, jeans, skirts, etc.)
- Track customer information and sales history
- Filter products by size, color, material, and price
- Spring MVC-based form handling with data binding
- Dynamic JSP views connected to the backend
- Relational data management using MySQL

## 🧰 Technologies Used

- Java 17
- Spring Web MVC
- MySQL
- JDBC
- JSP (JavaServer Pages)
- HTML / CSS (basic styling)
- Maven

## 🏗️ Architecture

The application follows a **Spring MVC architecture**, using:

- `@Controller` annotated classes for routing
- Model classes: `Product`, `Customer`, `Sale`
- JSP views in `/WEB-INF/views/`
- Database interaction using DAO and Service layers

## 💾 Database

MySQL database with three main tables:

- `product` — stores product data
- `customer` — stores client information
- `sale` — stores sales records linked to products and customers

Make sure to configure your `application.properties` or connection settings accordingly.

## 🚀 Getting Started

1. Clone this repository:
2. Open the project in **IntelliJ IDEA** or any Maven-compatible IDE.

3. Set up your MySQL database with the provided schema (if available).

4. Run the application on a local Tomcat server (e.g. TomEE Plume).

## 📦 Requirements

- JDK 17
- Maven 3.x
- MySQL server (e.g. XAMPP or local instance)
- Tomcat 9+ or compatible Java EE server

## 📌 Notes

- This project was developed as part of a training program in Java Web Application - Spring Web MVC
- You can switch to a more modern frontend (e.g. Thymeleaf or React) in future iterations.
Add MIT License
![Screenshot _structura_proiect_ShopApp](https://github.com/user-attachments/assets/0768bb88-5b56-4dd6-9769-f8ef075fdd92)
![Screenshot _customers](https://github.com/user-attachments/assets/e766ec01-29fa-4a3c-bdd2-7b6c48325fe8)
![Screenshot _add_product](https://github.com/user-attachments/assets/078bdd0a-dcce-455b-8942-209ca8bc893b)
![Screenshot_ProductController](https://github.com/user-attachments/assets/346faf6f-f7f1-4894-b8e5-ce2def8940a1)
