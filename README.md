# JavaFX E-Commerce Desktop Application 🛒

A comprehensive desktop food ordering system built with JavaFX, demonstrating advanced Java programming concepts including design patterns, database integration, and modern GUI development.

![JavaFX](https://img.shields.io/badge/JavaFX-22-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue)
![Java](https://img.shields.io/badge/Java-22-red)
![NetBeans](https://img.shields.io/badge/NetBeans-IDE-green)

## 📋 Table of Contents
- [Project Overview](#-project-overview)
- [Advanced Java Concepts Demonstrated](#-advanced-java-concepts-demonstrated)
- [Features](#-features)
- [Prerequisites](#-prerequisites)
- [Installation Guide](#-installation-guide)
- [How to Run](#-how-to-run)
- [Project Structure](#-project-structure)
- [Usage Guide](#-usage-guide)
- [Database Setup](#-database-setup)
- [Technologies Used](#-technologies-used)
- [Learning Outcomes](#-learning-outcomes)

## 🚀 Project Overview

This is an educational JavaFX desktop application that simulates an e-commerce food ordering system. The project serves as a practical implementation of advanced Java programming concepts, demonstrating real-world application development techniques including GUI programming, database integration, design patterns, and modern Java features.

The application allows users to:
- Register and login with credential validation
- Browse and order food items (Pizza, Seafood, Burger, Pasta)
- Manage shopping cart with real-time price calculations
- Process checkout with total price calculation
- Navigate through multiple application screens

## 🧠 Advanced Java Concepts Demonstrated

### 1. **Design Patterns**
- **Singleton Pattern**: Implemented in `ShoppingCart.java` to ensure only one cart instance exists throughout the application lifecycle
- **MVC (Model-View-Controller)**: Clean separation between UI (FXML), business logic (Controllers), and data models

### 2. **Object-Oriented Programming**
- **Encapsulation**: Private fields with public getter/setter methods
- **Abstraction**: Interface implementation (`ShoppingCartInterface.java`)
- **Inheritance**: Controller classes extending JavaFX base classes
- **Polymorphism**: Interface-based programming

### 3. **Collections Framework**
- **ArrayList**: Dynamic list management for cart items
- **HashMap**: Key-value storage for item pricing
- **Stream API**: Functional programming for price calculations with lambda expressions

### 4. **Database Integration**
- **JDBC**: Direct database connectivity without ORM frameworks
- **Prepared Statements**: SQL injection prevention
- **Connection Management**: Resource management with try-with-resources
- **Transaction Handling**: Database operations with proper exception handling

### 5. **JavaFX Advanced Features**
- **FXML**: Declarative UI design separation from business logic
- **Event Handling**: Action events and user interaction management
- **Scene Management**: Dynamic scene switching and navigation
- **Controller Injection**: @FXML annotations for component binding

### 6. **Concurrency (Advanced)**
- **Platform.runLater()**: Thread-safe GUI updates
- **CountDownLatch**: Synchronization mechanisms for background tasks

### 7. **Exception Handling**
- **Checked Exceptions**: SQLException handling for database operations
- **Try-with-resources**: Automatic resource management
- **Error Propagation**: Proper exception handling throughout the application stack

## ✨ Features

- **User Authentication System**
  - User registration with validation
  - Login with credential verification
  - Database-backed user management

- **Interactive Shopping Experience**
  - Browse food items with categories
  - Add items to cart with real-time feedback
  - View cart contents and pricing
  - Calculate total prices automatically

- **Modern GUI Interface**
  - Clean, intuitive JavaFX interface
  - Multiple screen navigation
  - Responsive button interactions
  - Alert dialogs for user feedback

- **Data Persistence**
  - MySQL database integration
  - User data storage and retrieval
  - Secure password handling

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

### Software Requirements
1. **Java Development Kit (JDK) 22 or higher**
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)

2. **JavaFX SDK 22**
   - Download from [JavaFX Official Site](https://openjfx.io/)
   - Extract to a known location (e.g., `C:\Program Files\Java\openjfx-22.0.1_windows-x64_bin-sdk`)

3. **NetBeans IDE** (Recommended)
   - Download from [NetBeans Official Site](https://netbeans.apache.org/)

4. **MySQL Server 8.0+**
   - Download from [MySQL Official Site](https://dev.mysql.com/downloads/mysql/)

5. **MySQL Connector/J**
   - Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

## 🔧 Installation Guide

### Step 1: Clone or Download the Project
```bash
# If using Git
git clone [your-repository-url]

# Or download and extract the ZIP file to your desired location
```

### Step 2: Set Up JavaFX SDK
1. Download JavaFX SDK 22 from the official website
2. Extract it to a directory like:
   ```
   C:\Program Files\Java\openjfx-22.0.1_windows-x64_bin-sdk
   ```
3. Note the path to the `lib` folder - you'll need this

### Step 3: Set Up MySQL Database
1. Install and start MySQL Server
2. Create a database named `test`:
   ```sql
   CREATE DATABASE test;
   ```
3. Create the users table:
   ```sql
   USE test;
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) UNIQUE NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       password VARCHAR(100) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

### Step 4: Configure Database Connection
1. Open `src/javaapplication1/DatabaseConnection.java`
2. Update the database credentials:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/test";
   private static final String USER = "your_mysql_username";
   private static final String PASSWORD = "your_mysql_password";
   ```

### Step 5: Set Up MySQL Connector
1. Download the MySQL Connector/J JAR file
2. Place it in your project's `lib` folder or note its location
3. The project is already configured to use it in the classpath

## ▶️ How to Run

### Option 1: Using NetBeans IDE (Recommended)

1. **Open the Project**
   - Launch NetBeans IDE
   - File → Open Project
   - Navigate to your project folder and select it

2. **Configure Libraries** (if needed)
   - Right-click project → Properties
   - Go to Libraries → Classpath
   - Ensure JavaFX and MySQL Connector are listed
   - If not, add them using "Add JAR/Folder"

3. **Clean and Build**
   - Right-click project → Clean and Build
   - This compiles the project and resolves dependencies

4. **Run the Application**
   - Right-click project → Run
   - Or press F6
   - The application should launch with the login screen

### Option 2: Using Command Line

1. **Navigate to Project Directory**
   ```cmd
   cd path\to\JavaApplication1
   ```

2. **Compile the Project**
   ```cmd
   javac --module-path "C:\Program Files\Java\openjfx-22.0.1_windows-x64_bin-sdk\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp "path\to\mysql-connector-j-8.4.0.jar" -d build\classes src\javaapplication1\*.java
   ```

3. **Run the Application**
   ```cmd
   java --module-path "C:\Program Files\Java\openjfx-22.0.1_windows-x64_bin-sdk\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp "build\classes;path\to\mysql-connector-j-8.4.0.jar" javaapplication1.SignLogScreen
   ```

## 📁 Project Structure

```
JavaApplication1/
├── src/
│   └── javaapplication1/
│       ├── SignLogScreen.java          # Main application entry point
│       ├── SignLogController.java      # Login screen controller
│       ├── RegesterController.java     # Registration controller  
│       ├── HomePageController.java     # Main menu controller
│       ├── CartController.java         # Shopping cart controller
│       ├── ShoppingCart.java          # Singleton cart model
│       ├── ShoppingCartInterface.java  # Cart abstraction interface
│       ├── DatabaseConnection.java     # Database utility class
│       ├── SignLogScreen.fxml         # Login screen UI
│       ├── regester.fxml              # Registration UI
│       ├── homePage.fxml              # Main menu UI
│       ├── cart.fxml                  # Shopping cart UI
│       └── checkout.fxml              # Checkout screen UI
├── nbproject/                         # NetBeans project configuration
├── build/                            # Compiled classes and build artifacts
├── manifest.mf                       # JAR manifest file
├── build.xml                         # Ant build configuration
└── README.md                         # This file
```

## 📖 Usage Guide

### 1. Registration Process
1. Launch the application
2. Click "Register" or navigate to registration screen
3. Fill in:
   - Username (must be unique)
   - Email address
   - Password
   - Confirm password
4. Click "Register" to create account
5. System validates and stores user in database

### 2. Login Process
1. Enter your registered username and password
2. Click "Login"
3. System validates credentials against database
4. Successful login redirects to main menu

### 3. Shopping Experience
1. **Browse Items**: View available food items on the home page
2. **Add to Cart**: Click "Add" buttons next to items you want
3. **View Cart**: Click "Cart" to see selected items and total price
4. **Checkout**: Review your order and complete purchase

### 4. Navigation
- Use navigation buttons to move between screens
- "Home" button returns to main menu
- "Cart" button opens shopping cart view
- Application maintains state across screen transitions

## 🗃️ Database Setup

### Required Tables

**Users Table Structure:**
```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Sample Data (Optional)
```sql
INSERT INTO users (username, email, password) VALUES 
('demo_user', 'demo@example.com', 'demo123'),
('test_user', 'test@example.com', 'test123');
```

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 22 | Core programming language |
| **JavaFX** | 22 | Desktop GUI framework |
| **FXML** | - | Declarative UI design |
| **MySQL** | 8.0+ | Database management system |
| **JDBC** | - | Database connectivity |
| **NetBeans** | Latest | Integrated Development Environment |
| **Ant** | - | Build automation tool |

## 🎓 Learning Outcomes

By studying and running this project, you will learn:

### Programming Concepts
- **Design Patterns**: Practical implementation of Singleton pattern
- **MVC Architecture**: Separation of concerns in application design
- **Interface Programming**: Abstraction and contract-based development
- **Exception Handling**: Robust error management strategies

### JavaFX Development
- **FXML Integration**: Declarative UI development
- **Scene Graph Management**: Navigation between application screens
- **Event-Driven Programming**: User interaction handling
- **Controller Pattern**: MVC implementation in JavaFX

### Database Programming
- **JDBC Operations**: Direct database connectivity without frameworks
- **Prepared Statements**: SQL injection prevention techniques
- **Transaction Management**: Data integrity and consistency
- **Connection Pooling Concepts**: Resource management best practices

### Modern Java Features
- **Stream API**: Functional programming paradigms
- **Lambda Expressions**: Concise and readable code
- **Try-with-resources**: Automatic resource management
- **Collections Framework**: Efficient data structure usage

### Software Engineering
- **Project Structure**: Professional Java project organization
- **Build Management**: Understanding build tools and processes
- **Version Control**: Project management and collaboration
- **Documentation**: Code documentation and README writing

---

## 🤝 Contributing

This is an educational project. Feel free to:
- Fork the repository
- Add new features
- Improve the user interface
- Enhance error handling
- Add unit tests
- Optimize database operations

## 📝 Notes

- This project is designed for educational purposes to demonstrate advanced Java concepts
- Database credentials should be secured in production environments
- Consider implementing password hashing for production use
- The project can be extended with additional features like order history, inventory management, and reporting

## 🎯 Next Steps for Enhancement

- Implement password hashing (BCrypt)
- Add input validation and sanitization
- Create unit tests with JUnit
- Implement logging with Log4j
- Add configuration file management
- Create deployment packages
- Implement order persistence
- Add inventory management features

---

*Happy Learning! 🚀*