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

### Running Pattern Demos

```bash
# Run adapter pattern demo
./gradlew run --args="adapter"

# Run other pattern demos (when implemented)
./gradlew run --args="singleton"
./gradlew run --args="factory"
./gradlew run --args="builder"
./gradlew run --args="prototype"
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

#### Prototype Pattern
The Prototype pattern creates new objects by cloning an existing object, known as the prototype, instead of creating new instances from scratch. This pattern is useful when object creation is expensive or when you want to avoid building a class hierarchy of factories.

Current implementations:

1. [Document Prototype](app/src/main/java/org/codeposito/creational/prototype/)
   - Demonstrates shallow copy vs deep copy cloning
   - Complex object with nested metadata
   - Implementation includes:
     - Document class ([Document.java](app/src/main/java/org/codeposito/creational/prototype/Document.java)) with Cloneable interface
     - DocumentMetadata class ([DocumentMetadata.java](app/src/main/java/org/codeposito/creational/prototype/DocumentMetadata.java)) for nested object cloning
     - Shallow copy using `clone()` method
     - Deep copy using `deepClone()` method
     - Comprehensive test coverage ([PrototypeTest.java](app/src/test/java/org/codeposito/creational/prototype/PrototypeTest.java))

2. [Shape Prototype Hierarchy](app/src/main/java/org/codeposito/creational/prototype/)
   - Demonstrates prototype pattern with inheritance
   - Polymorphic cloning with abstract base class
   - Implementation includes:
     - Abstract Shape class ([Shape.java](app/src/main/java/org/codeposito/creational/prototype/Shape.java)) with Cloneable interface
     - Concrete Circle class ([Circle.java](app/src/main/java/org/codeposito/creational/prototype/Circle.java)) with radius property
     - Concrete Rectangle class ([Rectangle.java](app/src/main/java/org/codeposito/creational/prototype/Rectangle.java)) with width and height properties
     - Polymorphic cloning support
     - Area calculation and drawing methods

3. [Shape Registry Pattern](app/src/main/java/org/codeposito/creational/prototype/)
   - Demonstrates prototype registry pattern
   - Centralized prototype management
   - Implementation includes:
     - ShapeRegistry class ([ShapeRegistry.java](app/src/main/java/org/codeposito/creational/prototype/ShapeRegistry.java)) for managing prototypes
     - Pre-registered default shapes
     - Dynamic shape registration and retrieval
     - Error handling for invalid keys
     - Registry size management

4. [Prototype Client](app/src/main/java/org/codeposito/creational/prototype/)
   - Comprehensive demonstration of all prototype features
   - Implementation includes:
     - PrototypeClient class ([PrototypeClient.java](app/src/main/java/org/codeposito/creational/prototype/PrototypeClient.java)) with main method
     - Document cloning demonstration (shallow vs deep copy)
     - Shape cloning demonstration with inheritance
     - Shape registry pattern demonstration
     - Detailed output showing cloning behavior

Key Features:
- **Cloneable Interface**: Proper implementation of Java's Cloneable interface
- **Shallow Copy**: Basic cloning with shared references to nested objects
- **Deep Copy**: Complete object independence with cloned nested objects
- **Inheritance Support**: Polymorphic cloning with abstract base classes
- **Registry Pattern**: Centralized prototype management with key-based access
- **Type Safety**: Proper type casting and error handling
- **Comprehensive Testing**: Full test coverage for all cloning scenarios
- **Real-world Examples**: Practical implementations with Document and Shape hierarchies

Usage Examples:
```java
// Document cloning (shallow copy)
Document original = new Document("Original", "Content");
Document shallowCopy = original.clone();

// Document cloning (deep copy)
Document deepCopy = original.deepClone();

// Shape cloning with inheritance
Circle originalCircle = new Circle("red", 10, 20, 15.0);
Circle clonedCircle = originalCircle.clone();

// Polymorphic cloning
Shape[] shapes = {originalCircle, new Rectangle("blue", 30, 40, 25.0, 15.0)};
for (Shape shape : shapes) {
    Shape cloned = shape.clone();
    cloned.setColor("purple");
}

// Registry pattern usage
Circle redCircle = (Circle) ShapeRegistry.getShape("red-circle");
ShapeRegistry.registerShape("custom-circle", new Circle("orange", 0, 0, 25.0));
```

Benefits:
- **Performance**: Avoids expensive object creation by cloning existing instances
- **Flexibility**: Allows runtime object creation without knowing concrete classes
- **Reduced Subclassing**: Eliminates the need for factory classes
- **Dynamic Configuration**: Registry pattern allows runtime prototype management
- **Memory Efficiency**: Reuses existing objects as templates

### Structural Patterns

Structural patterns deal with object composition and relationships between entities, making it easier to create relationships between objects.

#### Adapter Pattern
The Adapter pattern allows incompatible interfaces to work together by wrapping an existing class with a new interface. It acts as a bridge between two incompatible interfaces.

Current implementations:

1. [Payment System Adapter](app/src/main/java/org/codeposito/structural/adapter/)
   - Demonstrates adapting a legacy payment system to work with modern payment interfaces
   - Shows how to bridge incompatible payment processing systems
   - Implementation includes:
     - **LegacyPaymentSystem** ([LegacyPaymentSystem.java](app/src/main/java/org/codeposito/structural/adapter/LegacyPaymentSystem.java)) - The "Adaptee" class with old interface
       - Uses legacy format: account numbers with "ACC" prefix, amounts in cents, currency codes with "001" suffix
       - Returns legacy result objects with status codes and messages
       - Simulates processing delays and validation logic
     - **ModernPaymentProcessor** ([ModernPaymentProcessor.java](app/src/main/java/org/codeposito/structural/adapter/ModernPaymentProcessor.java)) - The "Target" interface
       - Modern interface using BigDecimal for amounts, simple account IDs, standard currency codes
       - Includes nested classes for PaymentRequest, PaymentResponse, and AccountBalance
       - Provides clean, modern API for payment processing
     - **LegacyPaymentAdapter** ([LegacyPaymentAdapter.java](app/src/main/java/org/codeposito/structural/adapter/LegacyPaymentAdapter.java)) - The "Adapter" class
       - Implements ModernPaymentProcessor interface
       - Wraps LegacyPaymentSystem and converts between formats
       - Handles data transformation (account numbers, amounts, currencies)
       - Generates modern transaction IDs and timestamps
     - **ModernPaymentService** ([ModernPaymentService.java](app/src/main/java/org/codeposito/structural/adapter/ModernPaymentService.java)) - The "Client" class
       - Uses the modern interface without knowing about legacy system
       - Demonstrates how clients can work with clean, modern APIs
       - Includes error handling and availability checks
     - **AdapterClient** ([AdapterClient.java](app/src/main/java/org/codeposito/structural/adapter/AdapterClient.java)) - Demo client
       - Comprehensive demonstration of the adapter pattern
       - Shows both legacy and modern interfaces working together
       - Tests various payment scenarios and error handling
     - **Comprehensive test coverage** ([AdapterTest.java](app/src/test/java/org/codeposito/structural/adapter/AdapterTest.java))
       - Tests all adapter functionality including format conversions
       - Validates error handling and edge cases
       - Ensures proper data transformation between interfaces

Key Features:
- **Format Conversion**: Automatic conversion between legacy and modern data formats
- **Interface Compatibility**: Seamless integration of incompatible systems
- **Data Transformation**: Account numbers, amounts, currencies, and response formats
- **Error Handling**: Proper error propagation between systems
- **Transaction Management**: Modern transaction IDs and timestamps
- **Comprehensive Testing**: Full test coverage for all conversion scenarios
- **Real-world Example**: Practical payment system integration scenario

Usage Examples:
```java
// Create the legacy system and adapter
LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
ModernPaymentProcessor adapter = new LegacyPaymentAdapter(legacySystem);

// Use the modern interface through the adapter
ModernPaymentService paymentService = new ModernPaymentService(adapter);

// Process payments using modern interface
PaymentResponse response = paymentService.makePayment("1234", new BigDecimal("15.00"), "USD", "Coffee");
AccountBalance balance = paymentService.getBalance("1234");

// The adapter handles all the conversion internally:
// - "1234" → "ACC000001234" (account number conversion)
// - 15.00 → 1500 (amount conversion from dollars to cents)
// - "USD" → "USD001" (currency code conversion)
```

Benefits:
- **Legacy Integration**: Allows modern systems to work with existing legacy code
- **Interface Standardization**: Provides consistent interfaces across different systems
- **Minimal Changes**: Requires no changes to existing legacy code
- **Gradual Migration**: Enables incremental system modernization
- **Code Reuse**: Leverages existing functionality without rewriting

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
│   │               │   ├── builder/
│   │               │   └── prototype/
│   │               ├── structural/
│   │               │   └── adapter/
│   │               └── behavioral/     (Coming Soon)
│   └── test/
│       └── java/
│           └── org/
│               └── codeposito/
│                   ├── creational/
│                   │   ├── singleton/
│                   │   ├── builder/
│                   │   └── prototype/
│                   ├── structural/
│                   │   └── adapter/
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