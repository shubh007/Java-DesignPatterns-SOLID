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

# Run bridge pattern demo
./gradlew run --args="bridge"

# Run composite pattern demo
./gradlew run --args="composite"

# Run decorator pattern demo
./gradlew run --args="decorator"

# Run facade pattern demo
./gradlew run --args="facade"

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

#### Bridge Pattern
The Bridge pattern decouples an abstraction from its implementation so that both can vary independently. It allows you to separate the interface from the implementation and lets you change the implementation without affecting the client code.

Current implementations:

1. [Drawing System Bridge](app/src/main/java/org/codeposito/structural/bridge/)
   - Demonstrates decoupling shapes from rendering engines
   - Shows how the same shapes can be rendered using different APIs
   - Implementation includes:
     - **DrawingAPI** ([DrawingAPI.java](app/src/main/java/org/codeposito/structural/bridge/DrawingAPI.java)) - The "Implementation" interface
       - Defines drawing operations (drawCircle, drawRectangle, drawLine)
       - Provides API identification method
       - Represents the implementation side of the bridge
     - **OpenGLDrawingAPI** ([OpenGLDrawingAPI.java](app/src/main/java/org/codeposito/structural/bridge/OpenGLDrawingAPI.java)) - Concrete implementation
       - Hardware-accelerated rendering using OpenGL
       - High-performance graphics processing
       - Real-time rendering capabilities
     - **SVGDrawingAPI** ([SVGDrawingAPI.java](app/src/main/java/org/codeposito/structural/bridge/SVGDrawingAPI.java)) - Concrete implementation
       - Vector-based graphics using SVG
       - Scalable without quality loss
       - XML output generation
     - **Shape** ([Shape.java](app/src/main/java/org/codeposito/structural/bridge/Shape.java)) - The "Abstraction" class
       - Abstract base class for all shapes
       - Holds reference to DrawingAPI implementation
       - Provides common shape functionality
     - **Circle** ([Circle.java](app/src/main/java/org/codeposito/structural/bridge/Circle.java)) - Concrete abstraction
       - Represents a circle shape with center coordinates and radius
       - Delegates drawing to the DrawingAPI implementation
     - **Rectangle** ([Rectangle.java](app/src/main/java/org/codeposito/structural/bridge/Rectangle.java)) - Concrete abstraction
       - Represents a rectangle shape with position and dimensions
       - Delegates drawing to the DrawingAPI implementation
     - **Line** ([Line.java](app/src/main/java/org/codeposito/structural/bridge/Line.java)) - Concrete abstraction
       - Represents a line shape with start and end points
       - Delegates drawing to the DrawingAPI implementation
     - **BridgeClient** ([BridgeClient.java](app/src/main/java/org/codeposito/structural/bridge/BridgeClient.java)) - Demo client
       - Comprehensive demonstration of the bridge pattern
       - Shows same shapes rendered with different APIs
       - Demonstrates decoupling benefits
     - **Comprehensive test coverage** ([BridgeTest.java](app/src/test/java/org/codeposito/structural/bridge/BridgeTest.java))
       - Tests all bridge components and their interactions
       - Validates decoupling and polymorphism
       - Ensures proper delegation to implementations

Key Features:
- **Decoupling**: Abstraction and implementation are completely separated
- **Extensibility**: New shapes and rendering APIs can be added independently
- **Polymorphism**: Same shapes work with different rendering engines
- **Flexibility**: Runtime selection of implementation
- **Maintainability**: Changes to implementation don't affect abstraction
- **Comprehensive Testing**: Full test coverage for all bridge components
- **Real-world Example**: Practical drawing system with multiple rendering backends

Usage Examples:
```java
// Create different rendering APIs
DrawingAPI openGLAPI = new OpenGLDrawingAPI();
DrawingAPI svgAPI = new SVGDrawingAPI();

// Create same shape with different APIs
Circle circleOpenGL = new Circle(10, 10, 20, openGLAPI);
Circle circleSVG = new Circle(10, 10, 20, svgAPI);

// Draw shapes - same shape, different rendering
circleOpenGL.draw(); // Uses OpenGL rendering
circleSVG.draw();    // Uses SVG rendering

// Create different shapes with same API
Shape[] shapes = {
    new Circle(10, 20, 30, openGLAPI),
    new Rectangle(10, 20, 30, 40, openGLAPI),
    new Line(10, 20, 30, 40, openGLAPI)
};

// All shapes use the same rendering API
for (Shape shape : shapes) {
    shape.draw(); // All use OpenGL
}
```

Benefits:
- **Decoupling**: Abstraction and implementation can vary independently
- **Extensibility**: Easy to add new shapes or rendering engines
- **Runtime Flexibility**: Can switch implementations at runtime
- **Reduced Complexity**: Avoids inheritance explosion
- **Better Design**: Follows composition over inheritance principle
- **Maintainability**: Changes are isolated to specific components

#### Composite Pattern
The Composite pattern composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly.

Current implementations:

1. [File System Composite](app/src/main/java/org/codeposito/structural/composite/)
   - Demonstrates a hierarchical file system structure
   - Shows how to treat files and directories uniformly
   - Implementation includes:
     - **FileSystemComponent** ([FileSystemComponent.java](app/src/main/java/org/codeposito/structural/composite/FileSystemComponent.java)) - The "Component" abstract class
       - Defines common interface for both leaf and composite objects
       - Provides abstract methods for display, size calculation, and search
       - Includes default implementations that throw exceptions for leaf operations
     - **File** ([File.java](app/src/main/java/org/codeposito/structural/composite/File.java)) - The "Leaf" class
       - Represents individual files in the file system
       - Cannot contain other components
       - Implements file-specific operations (extension, content)
       - Provides size formatting and content management
     - **Directory** ([Directory.java](app/src/main/java/org/codeposito/structural/composite/Directory.java)) - The "Composite" class
       - Represents directories that can contain other components
       - Manages a collection of child components
       - Implements recursive operations (size calculation, search)
       - Provides statistics (file count, directory count)
     - **FileSystemManager** ([FileSystemManager.java](app/src/main/java/org/codeposito/structural/composite/FileSystemManager.java)) - Utility class
       - Creates sample file system structures for demonstration
       - Provides high-level operations (search, statistics, largest file)
       - Includes size formatting utilities
     - **CompositeClient** ([CompositeClient.java](app/src/main/java/org/codeposito/structural/composite/CompositeClient.java)) - Demo client
       - Comprehensive demonstration of the composite pattern
       - Shows uniform treatment of files and directories
       - Demonstrates dynamic structure modification
     - **Comprehensive test coverage** ([CompositeTest.java](app/src/test/java/org/codeposito/structural/composite/CompositeTest.java))
       - Tests all composite components and their interactions
       - Validates leaf vs composite behavior
       - Ensures proper recursive operations

Key Features:
- **Uniform Interface**: Files and directories share the same interface
- **Recursive Structure**: Directories can contain other directories
- **Transparent Composition**: Clients don't need to know if they're working with files or directories
- **Dynamic Structure**: Components can be added/removed at runtime
- **Recursive Operations**: Size calculation, search, and display work recursively
- **Statistics**: Built-in counting and analysis capabilities
- **Error Handling**: Proper exception handling for invalid operations
- **Comprehensive Testing**: Full test coverage for all composite scenarios

Usage Examples:
```java
// Create file system structure
Directory root = new Directory("root", "rwxr-xr-x");
Directory documents = new Directory("documents", "rwxr-xr-x");
File readme = new File("README.md", 1024, "rw-r--r--", "md", "# Documentation");

// Build hierarchy
root.add(documents);
documents.add(readme);

// Treat files and directories uniformly
FileSystemComponent[] components = {root, documents, readme};
for (FileSystemComponent component : components) {
    component.display(""); // Same interface for all
    System.out.println("Size: " + component.getTotalSize()); // Recursive for directories
}

// Search across entire structure
List<FileSystemComponent> results = root.search("README");
results.forEach(result -> System.out.println("Found: " + result.getName()));

// Dynamic modification
File newFile = new File("new.txt", 512, "rw-r--r--", "txt", "New content");
documents.add(newFile);
documents.remove(readme);
```

Benefits:
- **Simplified Client Code**: Clients treat individual and composite objects uniformly
- **Easy Extension**: New component types can be added easily
- **Flexible Structure**: Tree structures can be built dynamically
- **Recursive Operations**: Natural support for tree traversal operations
- **Type Safety**: Compile-time type checking for component operations
- **Maintainability**: Changes to structure don't affect client code
- **Real-world Applicability**: Perfect for file systems, UI components, and organizational structures

#### Decorator Pattern
The Decorator pattern allows behavior to be added to individual objects dynamically without affecting the behavior of other objects of the same class. It provides a flexible alternative to subclassing for extending functionality.

Current implementations:

1. [Coffee Shop Decorator](app/src/main/java/org/codeposito/structural/decorator/)
   - Demonstrates a coffee shop where different add-ons can be combined with base coffee types
   - Shows how decorators can be stacked to create complex combinations
   - Implementation includes:
     - **Coffee** ([Coffee.java](app/src/main/java/org/codeposito/structural/decorator/Coffee.java)) - The "Component" interface
       - Defines the common contract for all coffee types and decorators
       - Provides methods for cost, description, and preparation time
       - Represents the base abstraction that can be decorated
     - **SimpleCoffee** ([SimpleCoffee.java](app/src/main/java/org/codeposito/structural/decorator/SimpleCoffee.java)) - The "ConcreteComponent" class
       - Represents basic coffee types without any add-ons
       - Implements the Coffee interface with base functionality
       - Serves as the foundation for all decorated coffees
     - **CoffeeDecorator** ([CoffeeDecorator.java](app/src/main/java/org/codeposito/structural/decorator/CoffeeDecorator.java)) - The "Decorator" abstract class
       - Implements the Coffee interface and holds a reference to a Coffee object
       - Provides base functionality that delegates to the wrapped coffee
       - Serves as the foundation for all concrete decorators
     - **MilkDecorator** ([MilkDecorator.java](app/src/main/java/org/codeposito/structural/decorator/MilkDecorator.java)) - Concrete decorator
       - Adds milk functionality to any coffee
       - Increases cost by $0.50 and preparation time by 1 minute
       - Appends " + Milk" to the description
     - **SugarDecorator** ([SugarDecorator.java](app/src/main/java/org/codeposito/structural/decorator/SugarDecorator.java)) - Concrete decorator
       - Adds sugar functionality to any coffee
       - Increases cost by $0.25 and preparation time by 1 minute
       - Appends " + Sugar" to the description
     - **WhippedCreamDecorator** ([WhippedCreamDecorator.java](app/src/main/java/org/codeposito/structural/decorator/WhippedCreamDecorator.java)) - Concrete decorator
       - Adds whipped cream functionality to any coffee
       - Increases cost by $0.75 and preparation time by 2 minutes
       - Appends " + Whipped Cream" to the description
     - **CaramelDecorator** ([CaramelDecorator.java](app/src/main/java/org/codeposito/structural/decorator/CaramelDecorator.java)) - Concrete decorator
       - Adds caramel functionality to any coffee
       - Increases cost by $1.00 and preparation time by 2 minutes
       - Appends " + Caramel" to the description
     - **CoffeeShop** ([CoffeeShop.java](app/src/main/java/org/codeposito/structural/decorator/CoffeeShop.java)) - Utility class
       - Provides predefined coffee types (Espresso, Americano, Cappuccino, Latte, Mocha)
       - Offers convenience methods for adding decorators
       - Includes a customize method for complex combinations
       - Provides formatted output for coffee details
     - **DecoratorClient** ([DecoratorClient.java](app/src/main/java/org/codeposito/structural/decorator/DecoratorClient.java)) - Demo client
       - Comprehensive demonstration of the decorator pattern
       - Shows single and multiple decorator combinations
       - Demonstrates dynamic decorator chaining
       - Analyzes cost and preparation time calculations
     - **Comprehensive test coverage** ([DecoratorTest.java](app/src/test/java/org/codeposito/structural/decorator/DecoratorTest.java))
       - Tests all decorators and their combinations
       - Validates cost and preparation time calculations
       - Ensures decorator transparency and flexibility
       - Tests the customize method and decorator chaining

Key Features:
- **Dynamic Composition**: Decorators can be added/removed at runtime
- **Transparent Interface**: Decorated objects implement the same interface as base objects
- **Flexible Combinations**: Decorators can be combined in any order
- **Single Responsibility**: Each decorator has one specific responsibility
- **Open/Closed Principle**: New decorators can be added without modifying existing code
- **Cost Calculation**: Automatic cost aggregation through decorator chain
- **Preparation Time**: Automatic time calculation through decorator chain
- **Comprehensive Testing**: Full test coverage for all decorator scenarios

Usage Examples:
```java
// Create basic coffee
Coffee espresso = CoffeeShop.ESPRESSO;

// Add single decorator
Coffee withMilk = CoffeeShop.withMilk(espresso);
Coffee withSugar = CoffeeShop.withSugar(espresso);

// Add multiple decorators
Coffee complexCoffee = CoffeeShop.withMilk(
    CoffeeShop.withSugar(
        CoffeeShop.withWhippedCream(
            CoffeeShop.withCaramel(CoffeeShop.MOCHA)
        )
    )
);

// Use the customize method
Coffee customized = CoffeeShop.customize(
    CoffeeShop.LATTE, 
    true,   // add milk
    true,   // add sugar
    false,  // no whipped cream
    true    // add caramel
);

// Dynamic decorator chaining
Coffee coffee = CoffeeShop.AMERICANO;
coffee = CoffeeShop.withMilk(coffee);      // Americano + Milk
coffee = CoffeeShop.withSugar(coffee);     // Americano + Milk + Sugar
coffee = CoffeeShop.withCaramel(coffee);   // Americano + Milk + Sugar + Caramel

// All decorated objects work the same way
System.out.println(coffee.getDescription()); // "Americano + Milk + Sugar + Caramel"
System.out.println(coffee.getCost());        // 4.75 (3.00 + 0.50 + 0.25 + 1.00)
System.out.println(coffee.getPreparationTime()); // 8 (4 + 1 + 1 + 2)
```

Benefits:
- **Open/Closed Principle**: New functionality can be added without modifying existing code
- **Single Responsibility**: Each decorator has one specific responsibility
- **Flexibility**: Decorators can be combined in any order and quantity
- **Transparency**: Clients treat decorated objects the same as base objects
- **Dynamic Composition**: Decorators can be added/removed at runtime
- **Avoids Inheritance Explosion**: No need for multiple subclasses for different combinations
- **Maintainability**: Changes to decorators don't affect other components
- **Real-world Applicability**: Perfect for UI components, I/O streams, and service layers

#### Facade Pattern
The Facade pattern provides a simplified interface to a complex subsystem of classes, making it easier to use and understand. It encapsulates the complexity of multiple subsystems and provides a unified interface for common operations.

Current implementations:

1. [Home Theater Facade](app/src/main/java/org/codeposito/structural/facade/)
   - Demonstrates a home theater system with multiple complex components
   - Shows how a facade can simplify the interaction with multiple subsystems
   - Implementation includes:
     - **HomeTheaterFacade** ([HomeTheaterFacade.java](app/src/main/java/org/codeposito/structural/facade/HomeTheaterFacade.java)) - The "Facade" class
       - Provides simplified interface to the entire home theater system
       - Encapsulates complexity of multiple subsystem components
       - Orchestrates operations across all components
       - Offers high-level operations: watchMovie(), listenToRadio(), listenToCd()
     - **Amplifier** ([Amplifier.java](app/src/main/java/org/codeposito/structural/facade/Amplifier.java)) - Subsystem component
       - Handles audio amplification and routing
       - Manages volume, sound modes, and input sources
       - Supports DVD, CD, and Tuner inputs
       - Provides surround and stereo sound modes
     - **Tuner** ([Tuner.java](app/src/main/java/org/codeposito/structural/facade/Tuner.java)) - Subsystem component
       - Handles radio tuning functionality
       - Manages frequency selection and on/off state
       - Provides radio listening capabilities
     - **DvdPlayer** ([DvdPlayer.java](app/src/main/java/org/codeposito/structural/facade/DvdPlayer.java)) - Subsystem component
       - Handles DVD playback functionality
       - Manages movie playback, stop, and eject operations
       - Tracks current playing movie
     - **CdPlayer** ([CdPlayer.java](app/src/main/java/org/codeposito/structural/facade/CdPlayer.java)) - Subsystem component
       - Handles CD playback functionality
       - Manages CD playback and eject operations
       - Tracks current playing CD
     - **Projector** ([Projector.java](app/src/main/java/org/codeposito/structural/facade/Projector.java)) - Subsystem component
       - Handles video projection functionality
       - Supports widescreen and TV modes
       - Manages on/off state and display modes
     - **TheaterLights** ([TheaterLights.java](app/src/main/java/org/codeposito/structural/facade/TheaterLights.java)) - Subsystem component
       - Handles theater lighting functionality
       - Provides dimming capabilities for ambiance
       - Manages on/off state and brightness levels
     - **Screen** ([Screen.java](app/src/main/java/org/codeposito/structural/facade/Screen.java)) - Subsystem component
       - Handles projection screen functionality
       - Manages screen up/down positions
       - Tracks current screen state
     - **PopcornPopper** ([PopcornPopper.java](app/src/main/java/org/codeposito/structural/facade/PopcornPopper.java)) - Subsystem component
       - Handles popcorn popping functionality
       - Provides movie theater ambiance
       - Manages on/off state and popping operations
     - **FacadeClient** ([FacadeClient.java](app/src/main/java/org/codeposito/structural/facade/FacadeClient.java)) - Demo client
       - Comprehensive demonstration of the facade pattern
       - Shows simplified interface usage for complex operations
       - Demonstrates movie watching, radio listening, and CD listening
       - Includes system status monitoring
     - **Comprehensive test coverage** ([FacadeTest.java](app/src/test/java/org/codeposito/structural/facade/FacadeTest.java))
       - Tests all subsystem components individually
       - Validates facade orchestration and integration
       - Ensures proper component state management
       - Tests complete workflows and error scenarios

Key Features:
- **Simplified Interface**: Complex subsystem operations reduced to simple method calls
- **Encapsulation**: Subsystem complexity hidden from clients
- **Orchestration**: Facade coordinates multiple components for common operations
- **High-Level Operations**: watchMovie(), listenToRadio(), listenToCd() methods
- **State Management**: Automatic component state tracking and management
- **Error Handling**: Robust error handling across all subsystems
- **Comprehensive Testing**: Full test coverage for all components and workflows
- **Real-world Example**: Practical home theater system with multiple components

Usage Examples:
```java
// Create the facade
HomeTheaterFacade homeTheater = new HomeTheaterFacade();

// Watch a movie (orchestrates 8 different components)
homeTheater.watchMovie("Raiders of the Lost Ark");
// This single call handles:
// - Popcorn popper on and pop
// - Lights dim to 10%
// - Screen down
// - Projector on with widescreen mode
// - Amplifier on with DVD input and surround sound
// - DVD player on and play movie

// Listen to radio (orchestrates 3 components)
homeTheater.listenToRadio(95.5);
// This single call handles:
// - Lights on
// - Amplifier on with tuner input
// - Tuner on and set frequency

// Listen to CD (orchestrates 3 components)
homeTheater.listenToCd("Greatest Hits Album");
// This single call handles:
// - Lights on
// - Amplifier on with CD input and stereo sound
// - CD player on and play album

// End operations (clean shutdown)
homeTheater.endMovie();    // Shuts down all movie-related components
homeTheater.endRadio();    // Shuts down radio-related components
homeTheater.endCd();       // Shuts down CD-related components

// Get system status
homeTheater.getSystemStatus(); // Shows status of all components
```

Benefits:
- **Simplified Client Code**: Clients interact with one simple interface instead of multiple complex subsystems
- **Reduced Coupling**: Clients don't need to know about subsystem internals
- **Easier Maintenance**: Changes to subsystems don't affect client code
- **Better Encapsulation**: Subsystem complexity is hidden from clients
- **Improved Usability**: High-level operations are intuitive and easy to use
- **Centralized Control**: All subsystem coordination happens in one place
- **Error Isolation**: Errors in subsystems are contained and handled gracefully
- **Real-world Applicability**: Perfect for complex systems like home automation, banking systems, and enterprise applications

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
│   │               │   ├── adapter/
│   │               │   ├── bridge/
│   │               │   ├── composite/
│   │               │   ├── decorator/
│   │               │   └── facade/
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
│                   │   ├── adapter/
│                   │   ├── bridge/
│                   │   ├── composite/
│                   │   ├── decorator/
│                   │   └── facade/
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