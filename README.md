# Online Bookstore Backend

This is the backend system of an online bookstore developed using the Spring Boot framework. The system integrates multiple databases and services to manage book orders, provide real-time notifications, and ensure high performance and scalability.

This is the course project for SE3353 and SE2321 at SJTU.

## Features

- **Spring Boot Framework**: The project is built using Spring Boot to provide a robust, scalable, and maintainable backend architecture.
- **Database Integration**:
    - **MySQL**: Used for storing transactional data, such as book orders and customer information.
    - **Neo4j**: Integrated for handling relationships between different labels for books.
    - **MongoDB**: Used for storing non-relational data such as book cover images.
- **Kafka**: Kafka is employed for handling order-related messages in real-time, ensuring that order processing is decoupled and scalable.
- **WebSocket**: Real-time notifications are sent to users via WebSocket about the status of their orders.
- **Redis**: Redis is integrated for caching frequently accessed data such as the book list, reducing database load and speeding up data retrieval times.
- **Transaction Management**: The `@Transaction` annotation is used for managing bookstore transactions, ensuring data consistency and integrity across various services.
- **Microservices Architecture**: The application follows a microservices architecture **(At 'micro' branch)**, allowing for independent scaling and management of different modules such as order processing, user management, and Author Query.

## Repository

The source code for this project can be found at:  
[https://github.com/lfwang-sjtu/bookstore_backend](https://github.com/lfwang-sjtu/bookstore_backend)

## Usage

Once the application is running, you can interact with it through REST APIs or WebSocket for real-time notifications.

- **REST APIs**: Used for managing book data, placing orders, and querying order status.
- **WebSocket**: Real-time order status updates can be received by clients via WebSocket.

---

Feel free to adjust any details based on your specific setup or requirements!


## some useful command

### start kafka
```
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

### Start and Stop redis server
```
$ redis-server
Ctrl-C
```

### database
```
mongo
brew services start mongodb-community
neo4j
bin/neo4j start 
```
