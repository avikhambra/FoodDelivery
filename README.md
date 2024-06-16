# FoodDelivery

## Database Design for a food delivery app like Zomato/Swiggy

![image](https://github.com/Nikhilks14/FoodDelivery/assets/66267528/35823e35-e13f-4278-9644-f8b0d156b7f1)
![image](https://github.com/Nikhilks14/FoodDelivery/assets/66267528/7329c2a8-311d-4205-8e5b-1fb3c8843cd9)
![image](https://github.com/Nikhilks14/FoodDelivery/assets/66267528/74060359-15d5-4275-ae6d-9072b6d7bd18)


# Food Delivery Application

## Overview

This project is a food delivery application backend, designed to manage users, restaurants, orders, payments, ratings, drivers, and delivery addresses. It uses a relational database to maintain data integrity and handle relationships between various entities.

## Technologies Used

- **Java**: Backend programming language.
- **Spring Boot**: Framework for building the backend API.
- **MySQL**: Relational database for storing application data.
- **Hibernate/JPA**: ORM framework for database interactions.
- **Docker**: For containerizing the application.

## Database Design

The database design includes the following main tables and their relationships:

- **Users**: Stores user information.
- **Restaurants**: Stores restaurant details.
- **Menu**: Stores menu items for each restaurant.
- **Orders**: Stores order details including the user, restaurant, and driver information.
- **Drivers**: Stores driver details.
- **Payment**: Stores payment details for orders.
- **Rating**: Stores user ratings for restaurants.
- **Address**: Stores multiple delivery addresses for users.

### Table Structures and Relationships

1. **Users**
   - One-to-many relationship with `Orders`
   - One-to-many relationship with `Rating`
   - One-to-many relationship with `Address`

2. **Restaurants**
   - One-to-many relationship with `Orders`
   - One-to-many relationship with `Rating`
   - One-to-many relationship with `Menu`

3. **Orders**
   - Many-to-one relationship with `Users`
   - Many-to-one relationship with `Restaurants`
   - Many-to-one relationship with `Drivers`
   - One-to-one relationship with `Payment`

4. **Drivers**
   - One-to-many relationship with `Orders`

5. **Payment**
   - One-to-one relationship with `Orders`

6. **Rating**
   - Many-to-one relationship with `Users`
   - Many-to-one relationship with `Restaurants`

7. **Address**
   - Many-to-one relationship with `Users`

## API Endpoints

### User Endpoints
- `POST /users`: Create a new user
- `GET /users/{id}`: Get user by ID
- `PUT /users/{id}`: Update user details
- `DELETE /users/{id}`: Delete user

### Restaurant Endpoints
- `POST /restaurants`: Create a new restaurant
- `GET /restaurants/{id}`: Get restaurant by ID
- `PUT /restaurants/{id}`: Update restaurant details
- `DELETE /restaurants/{id}`: Delete restaurant

### Menu Endpoints
- `POST /restaurants/{restaurantId}/menu`: Add menu item to restaurant
- `GET /restaurants/{restaurantId}/menu`: Get menu items for a restaurant

### Order Endpoints
- `POST /orders`: Create a new order
- `GET /orders/{id}`: Get order by ID
- `PUT /orders/{id}`: Update order status
- `DELETE /orders/{id}`: Cancel order

### Driver Endpoints
- `POST /drivers`: Create a new driver
- `GET /drivers/{id}`: Get driver by ID
- `PUT /drivers/{id}`: Update driver details
- `DELETE /drivers/{id}`: Delete driver

### Payment Endpoints
- `POST /payments`: Process a payment
- `GET /payments/{id}`: Get payment details by ID

### Rating Endpoints
- `POST /ratings`: Rate a restaurant
- `GET /ratings/{id}`: Get rating by ID

### Address Endpoints
- `POST /users/{userId}/address`: Add address for user
- `GET /users/{userId}/address`: Get addresses for user

## Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Nikhilks14/FoodDelivery.git
   cd food-delivery-app
