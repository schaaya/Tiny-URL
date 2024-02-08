# Tiny URL Shortener

This is a simple web application built with Spring Boot that allows users to generate short URLs from long URLs. It uses a hash function to generate unique keys for each long URL, which are then mapped to corresponding short URLs.

## Features
- Convert long URLs to short URLs
- Redirect users from short URLs to original long URLs
- Delete short URLs

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Thymeleaf

## Setup
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Build and run the project using Maven or your IDE's built-in tools.
4. Access the application at `http://localhost:8080`.

## Usage
1. Visit the homepage to enter a long URL and generate a short URL.
2. Use the generated short URL to redirect to the original long URL.
3. Optionally, delete short URLs if needed.

## Project Structure
- `src/main/java`: Contains Java source files.
- `src/main/resources`: Contains application properties and Thymeleaf templates.
- `pom.xml`: Maven project configuration file.

## Author
Sappa Chaaya


