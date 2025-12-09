# Restaurant Management Application

A comprehensive Spring Boot application for managing restaurant operations including customer ordering, kitchen management, and administrative functions. 
Application is extremely easy to test as it uses H2 database which is downloaded and build by `pom.xml`. All the schemas are seeded with sample data by `/resources/data.sql`. Database can easily be queried using H2 console at `http://localhost:8080/h2-console`.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Security](#security)
- [Database](#database)
- [Project Structure](#project-structure)
- [Business Logic Highlights](#business-logic-highlights)
- [Contributing](#contributing)

## Overview

This application provides a complete restaurant management system with three main user roles:
- **Customer**: Browse menu, manage cart, place orders
- **Kitchen**: View and update order status
- **Admin**: Manage menu items, ingredients, users, and roles

## Features

### Customer Features
- Browse restaurant menu with ingredient details
- Add items to cart with quantity selection
- View and manage shopping cart
- Place orders with dining options (Eat-in/Take-away)
- Cancel orders (before preparation begins)
- Select payment method and table number

### Kitchen Features
- View all active orders
- Update order status (Received → Preparing → Ready)
- View order details with ingredients
- Real-time order management

### Admin Features
- Complete menu management (CRUD operations)
- Ingredient management with allergen tracking
- Menu item pricing and tax configuration
- User management and role assignment

## Technology Stack

- **Framework**: Spring Boot 3.4.0
- **Language**: Java 17
- **Database**: H2 (file-based)
- **Security**: Spring Security with session-based authentication
- **ORM**: Spring Data JPA / Hibernate
- **Validation**: Jakarta Validation
- **Build Tool**: Maven
- **API Documentation**: SpringDoc OpenAPI (Swagger)
- **Utilities**: Lombok

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.9+

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd my_restaurant_app
```

2. Build the project:
```bash
./mvnw clean install
```

3. Run the application:
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Default Credentials

The application comes with two pre-configured users:

**Admin User**
- Username: `farid`
- Password: `ahadli`
- Role: ADMIN

**Kitchen User**
- Username: `farid2`
- Password: `ahadli`
- Role: KITCHEN

### Accessing the Application

- **API Base URL**: `http://localhost:8080`
- **H2 Console**: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:file:./data/mydb`
  - Username: `user`
  - Password: `user`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

## API Documentation


## Security

The application uses Spring Security with the following configuration:

- **Session Management**: Session-based authentication (5-minute timeout)
- **CSRF**: Disabled for API usage
- **Password Encoding**: BCrypt with strength 12

### Role-Based Access Control

| Endpoint Pattern | Allowed Roles |
|-----------------|---------------|
| `/customer/**` | Public |
| `/login` | Public |
| `/kitchen/**` | KITCHEN, ADMIN |
| `/admin/**` | ADMIN |
| `/register` | ADMIN |
| `/role` | ADMIN |

## Database

### Schema Overview

The application uses the following main entities:

- **RestaurantMenuItem**: Menu items with pricing and tax information
- **RestaurantIngredients**: Ingredient definitions with allergen flags
- **RestaurantOrders**: Customer orders with status tracking
- **RestaurantOrderMenuItem**: Line items for each order
- **RestaurantUser**: Application users
- **RestaurantRoles**: User roles

### Sample Data

The application initializes with sample data including:
- 5 menu items (Plov, Dolma, Lula Kabab, Gutab, Dushbara)
- 12 ingredients with allergen information
- 2 default users (admin and kitchen)

## Project Structure

```
src/main/java/com/farid/ahadli/my_restaurant_app/
├── configuration/       # Security and app configuration
├── controller/         # REST API endpoints
├── exception/          # Custom exceptions and global handler
├── model/
│   ├── dto/           # Data Transfer Objects
│   │   ├── request/   # Request DTOs
│   │   └── response/  # Response DTOs
│   └── entity/        # JPA entities
├── repository/        # Spring Data repositories
├── service/           # Business logic layer
├── utility/           # Helper utilities
└── validation/        # Custom validators
```

## Business Logic Highlights

### Tax Calculation
- VAT: 18% tax rate
- TAX_FREE: 0% tax rate
- Tax amounts are pre-calculated and stored

### Order Status Workflow
1. **RECEIVED**: Order placed by customer
2. **PREPARING**: Kitchen starts preparation
3. **READY**: Order ready for pickup/serving

### Cart Management
- Session-scoped cart per user
- Automatic price and tax calculation
- Cart cleared after order placement

## Error Handling

The application uses a global exception handler that returns appropriate HTTP status codes.
All errors are logged with user context for debugging.

## Validation

Custom validators ensure data integrity:
- `@ProperDiningOption`: Validates dining options
- `@ProperPaymentMethod`: Validates payment methods
- `@ProperStatus`: Validates order status transitions
- `@ProperTable`: Validates table selections
- `@ProperTaxType`: Validates tax types

---
