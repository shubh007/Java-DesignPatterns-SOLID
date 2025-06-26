# Java Design Patterns - SOLID Principles

This project demonstrates various design patterns in Java, implementing them with practical examples and following SOLID principles. The project is built using Gradle and includes comprehensive test coverage.

## Prerequisites

- Java 17 or higher
- Gradle 8.0 or higher

## Getting Started

### Cloning the Repository

```bash
git clone https://github.com/shubh007/Java-DesignPatterns-SOLID.git
cd Java-DesignPatterns-SOLID
```

### Building the Project

```bash
./gradlew build
```

### Running Tests

```bash
# Run all tests
./gradlew test

# Run tests with detailed output
./gradlew test --info

# View test reports
open app/build/reports/tests/test/index.html
```

## Design Patterns Implementation

### Creational Patterns

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

#### Singleton Pattern
The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

Current implementations:

1. [Eager Singleton](app/src/main/java/org/codeposito/creational/singleton/EagerSingleton.java)
   - Thread-safe by default
   - Simple implementation
   - Instance created at class loading time

2. [Synchronized Method Singleton](app/src/main/java/org/codeposito/creational/singleton/SynchronizedMethodSingleton.java)
   - Thread-safe with method synchronization
   - Lazy initialization
   - Performance overhead due to synchronization

3. [Double-Checked Locking Singleton](app/src/main/java/org/codeposito/creational/singleton/DCLSingleton.java)
   - Thread-safe with optimized synchronization
   - Lazy initialization
   - Better performance than synchronized method

4. [Bill Pugh Singleton](app/src/main/java/org/codeposito/creational/singleton/BillPughSingleton.java)
   - Most efficient implementation
   - Thread-safe by design
   - Lazy initialization using static inner class

5. [Enum Singleton](app/src/main/java/org/codeposito/creational/singleton/EnumSingleton.java)
   - Simplest thread-safe implementation
   - Serialization handled automatically
   - Protection against reflection attacks

#### Factory Pattern
The Factory pattern provides an interface for creating objects but lets subclasses decide which class to instantiate.

Current implementations:

1. [Abstract Factory](app/src/main/java/org/codeposito/creational/factory/abstrct/)
   - Provides an interface for creating families of related objects
   - Encapsulates object creation
   - Ensures compatibility between created objects
   - Implementation includes:
     - Abstract Products (Button, Checkbox)
     - Concrete Products (LightButton, DarkButton, LightCheckbox, DarkCheckbox)
     - Abstract Factory (GUIFactory)
     - Concrete Factories (LightThemeFactory, DarkThemeFactory)
     - Client (Application)

2. [Simple Factory](app/src/main/java/org/codeposito/creational/factory/simple/)
   - Creates objects without exposing creation logic
   - Centralizes object creation
   - Simplifies client code
   - Implementation includes:
     - Product Interface
     - Concrete Products (ConcreteProductA, ConcreteProductB)
     - Simple Factory with type-safe enum
     - Client with error handling

3. [Regular Factory](app/src/main/java/org/codeposito/creational/factory/regular/)
   - Defines an interface for creating objects
   - Lets subclasses decide which class to instantiate
   - Promotes loose coupling
   - Implementation includes:
     - Abstract Product (Vehicle)
     - Concrete Products (Car, Bike)
     - Abstract Factory (VehicleFactory)
     - Concrete Factories (CarFactory, BikeFactory)
     - Client (FactoryMethodClient)

4. Factory Method (Coming Soon)
   - Defines an interface for creating objects
   - Lets subclasses decide which class to instantiate
   - Promotes loose coupling

#### Builder Pattern
The Builder pattern constructs complex objects step by step, allowing you to produce different types and representations of an object using the same construction code.

Current implementations:

1. [Computer Builder](app/src/main/java/org/codeposito/creational/builder/)
   - Classic Builder pattern with fluent interface
   - Complex object construction with many optional parameters
   - Validation logic for required fields
   - Default values for optional fields
   - Implementation includes:
     - Complex Object ([Computer.java](app/src/main/java/org/codeposito/creational/builder/Computer.java)) with package-private constructor
     - Separate Builder class ([ComputerBuilder.java](app/src/main/java/org/codeposito/creational/builder/ComputerBuilder.java)) with method chaining
     - Director class ([ComputerDirector.java](app/src/main/java/org/codeposito/creational/builder/ComputerDirector.java)) for predefined configurations
     - Client ([BuilderClient.java](app/src/main/java/org/codeposito/creational/builder/BuilderClient.java)) demonstrating various usage patterns
     - Comprehensive test coverage ([BuilderTest.java](app/src/test/java/org/codeposito/creational/builder/BuilderTest.java))

2. [Pizza Builder](app/src/main/java/org/codeposito/creational/builder/)
   - Alternative Builder implementation with collections
   - Demonstrates different approaches to the Builder pattern
   - Flexible topping management with varargs support
   - Implementation includes:
     - Pizza class ([Pizza.java](app/src/main/java/org/codeposito/creational/builder/Pizza.java)) with List-based toppings
     - Separate Builder class ([PizzaBuilder.java](app/src/main/java/org/codeposito/creational/builder/PizzaBuilder.java)) with addTopping() and addToppings() methods
     - Client ([PizzaClient.java](app/src/main/java/org/codeposito/creational/builder/PizzaClient.java)) demonstrating various pizza configurations
     - Validation for required fields (size, crust)

Key Features:
- **Fluent Interface**: Method chaining for readable code
- **Validation**: Built-in validation for required parameters
- **Default Values**: Automatic setting of sensible defaults
- **Director Pattern**: Predefined configurations for common use cases
- **Immutable Objects**: Objects are immutable after construction
- **Type Safety**: Compile-time type checking
- **Flexibility**: Support for optional parameters and collections
- **Separate Files**: Each class is in its own file for better organization

Usage Examples:
```java
// Direct Builder usage
Computer computer = new ComputerBuilder()
    .cpu("Intel Core i7")
    .ram("16GB DDR4")
    .storage("512GB SSD")
    .gpu("RTX 3060")
    .build();

// Director usage for predefined configurations
ComputerDirector director = new ComputerDirector();
Computer gamingPC = director.buildGamingComputer();
Computer officePC = director.buildOfficeComputer();

// Pizza Builder with collections
Pizza pizza = new PizzaBuilder()
    .size("Large")
    .crust("Thick")
    .addToppings("Pepperoni", "Mushrooms", "Bell Peppers")
    .extraCheese(true)
    .build();
```

#### Prototype Pattern (Coming Soon)
- Shallow Copy
- Deep Copy
- Cloneable Interface

### Structural Patterns (Coming Soon)
- Adapter Pattern
- Bridge Pattern
- Composite Pattern
- Decorator Pattern
- Facade Pattern
- Flyweight Pattern
- Proxy Pattern

### Behavioral Patterns (Coming Soon)
- Chain of Responsibility
- Command Pattern
- Iterator Pattern
- Mediator Pattern
- Memento Pattern
- Observer Pattern
- State Pattern
- Strategy Pattern
- Template Method
- Visitor Pattern

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── codeposito/
│   │               ├── creational/
│   │               │   ├── singleton/
│   │               │   ├── factory/
│   │               │   │   ├── abstrct/
│   │               │   │   ├── simple/
│   │               │   │   └── regular/
│   │               │   └── builder/
│   │               ├── structural/     (Coming Soon)
│   │               └── behavioral/     (Coming Soon)
│   └── test/
│       └── java/
│           └── org/
│               └── codeposito/
│                   ├── creational/
│                   │   ├── singleton/
│                   │   └── builder/
│                   ├── structural/     (Coming Soon)
│                   └── behavioral/     (Coming Soon)
└── build.gradle.kts
```

## Git Configuration

```bash
# Configure Git
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# Common Git commands
git status | cat
git add .
git commit -m "Your commit message"
git push
```

## Contributing

Feel free to contribute to this project by:
1. Forking the repository
2. Creating a new branch
3. Making your changes
4. Submitting a pull request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Building Your Own Gradle Project

If you want to create your own Java project using Gradle, follow these steps:

1. Create a new directory for your project
2. Initialize a new Gradle project:
   ```bash
   gradle init
   ```
3. Select the following options:
   - Type of project: application
   - Implementation language: Java
   - Build script DSL: Kotlin DSL
   - Test framework: JUnit Jupiter
   - Project name: your-project-name
   - Source package: your.package.name

4. The project structure will be created with:
   ```
   your-project/
   ├── app/
   │   ├── src/
   │   │   ├── main/
   │   │   │   └── java/
   │   │   └── test/
   │   │       └── java/
   │   └── build.gradle.kts
   ├── gradle/
   ├── gradlew
   ├── gradlew.bat
   └── settings.gradle.kts
   ```

5. Key Gradle commands for your project:
   ```bash
   # Build the project
   ./gradlew build

   # Run the application
   ./gradlew run

   # Run tests
   ./gradlew test

   # Clean build files
   ./gradlew clean
   ```