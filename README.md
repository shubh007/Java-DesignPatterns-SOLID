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

#### Proxy Pattern
The Proxy pattern provides a surrogate or placeholder for another object to control access to it. It allows you to add a level of control over access to the real object, such as lazy loading, access control, or logging.

Current implementations:

1. [Image Loading Proxy](app/src/main/java/org/codeposito/structural/proxy/)
   - Demonstrates lazy loading of expensive image resources
   - Shows how to control access to large image files
   - Implementation includes:
     - **Image** ([Image.java](app/src/main/java/org/codeposito/structural/proxy/Image.java)) - The "Subject" interface
       - Defines the common interface for both RealImage and ImageProxy
       - Provides methods for display, filename, size, format, and loading status
       - Represents the abstraction that both proxy and real subject implement
     - **RealImage** ([RealImage.java](app/src/main/java/org/codeposito/structural/proxy/RealImage.java)) - The "RealSubject" class
       - Represents the actual image that is expensive to load and display
       - Simulates expensive disk loading operations with delays
       - Contains image metadata (filename, size, format) and loading state
       - Provides size formatting utilities for human-readable output
     - **ImageProxy** ([ImageProxy.java](app/src/main/java/org/codeposito/structural/proxy/ImageProxy.java)) - The "Proxy" class
       - Controls access to the RealImage and provides lazy loading
       - Implements the same interface as RealImage
       - Creates RealImage only when first accessed (lazy initialization)
       - Delegates all operations to the real image once created
     - **ImageGallery** ([ImageGallery.java](app/src/main/java/org/codeposito/structural/proxy/ImageGallery.java)) - The "Client" class
       - Demonstrates the proxy pattern in a real-world scenario
       - Manages a collection of images using proxies for efficient memory usage
       - Provides gallery information without loading images
       - Shows memory usage statistics and efficiency metrics
       - Includes methods for displaying specific images or all images
     - **ProxyClient** ([ProxyClient.java](app/src/main/java/org/codeposito/structural/proxy/ProxyClient.java)) - Demo client
       - Comprehensive demonstration of the proxy pattern
       - Shows basic proxy functionality with lazy loading
       - Demonstrates real-world scenario with image gallery
       - Compares memory efficiency with and without proxies
       - Analyzes the benefits of lazy loading and memory management
     - **Comprehensive test coverage** ([ProxyTest.java](app/src/test/java/org/codeposito/structural/proxy/ProxyTest.java))
       - Tests all proxy components and their interactions
       - Validates lazy loading behavior and delegation
       - Ensures proper interface compatibility
       - Tests gallery functionality and memory management
       - Verifies multiple proxies work independently

Key Features:
- **Lazy Loading**: Images are loaded only when first accessed
- **Memory Efficiency**: Unused images don't consume memory
- **Transparent Interface**: Proxy and RealImage implement the same interface
- **Access Control**: Proxy controls when and how the real object is accessed
- **Performance Optimization**: Reduces initial loading time and memory usage
- **Statistics Tracking**: Real-time monitoring of memory usage and efficiency
- **Comprehensive Testing**: Full test coverage for all proxy scenarios
- **Real-world Example**: Practical image gallery with efficient resource management

Usage Examples:
```java
// Create a proxy for a large image
Image imageProxy = new ImageProxy("vacation_photo.jpg", 2048576, "JPEG");

// Proxy is created instantly (no loading)
System.out.println("Proxy created for: " + imageProxy.getFilename());
System.out.println("Is loaded: " + imageProxy.isLoaded()); // false

// First display triggers loading
imageProxy.display(); // This will load the image from disk
System.out.println("Is loaded: " + imageProxy.isLoaded()); // true

// Subsequent displays are instant
imageProxy.display(); // No loading, instant display

// Use in a gallery for memory efficiency
ImageGallery gallery = new ImageGallery("Nature Photography");
gallery.addImage("mountain_landscape.jpg", 1536000, "JPEG");
gallery.addImage("forest_path.png", 2048000, "PNG");

// Show gallery info without loading images
gallery.showGalleryInfo();

// Load only specific images
gallery.displayImage("mountain_landscape.jpg"); // Only this image is loaded

// Check memory efficiency
gallery.showMemoryUsage();
// Output shows:
// - Total images: 2
// - Loaded images: 1
// - Memory saved: 1.5 MB
// - Memory efficiency: 42.9%
```

Benefits:
- **Memory Efficiency**: Reduces memory usage by loading resources only when needed
- **Performance Improvement**: Faster application startup and reduced initial load time
- **Resource Management**: Better control over expensive resource allocation
- **Access Control**: Can add security, logging, or caching without modifying real objects
- **Scalability**: Efficiently handles large numbers of potentially expensive objects
- **Transparency**: Clients work with the same interface regardless of proxy or real object
- **Real-world Applicability**: Perfect for image galleries, document viewers, database connections, and any application with expensive resources

#### Flyweight Pattern
The Flyweight pattern reduces memory usage by sharing common parts of state between multiple objects instead of keeping all of the data in each object. It's useful when you need to create a large number of similar objects that share common state.

Current implementations:

1. [Text Editor Flyweight](app/src/main/java/org/codeposito/structural/flyweight/)
   - Demonstrates memory-efficient character management in a text editor
   - Shows how to share character objects with identical properties
   - Implementation includes:
     - **Character** ([Character.java](app/src/main/java/org/codeposito/structural/flyweight/Character.java)) - The "Flyweight" class
       - Contains intrinsic state (shared state): character value, font, size, color
       - Immutable objects that can be safely shared
       - Proper equals() and hashCode() implementation for caching
     - **CharacterContext** ([CharacterContext.java](app/src/main/java/org/codeposito/structural/flyweight/CharacterContext.java)) - The "Context" class
       - Contains extrinsic state (unique state): row, column position
       - References a shared Character object
       - Provides display functionality for the character at its position
     - **CharacterFactory** ([CharacterFactory.java](app/src/main/java/org/codeposito/structural/flyweight/CharacterFactory.java)) - The "Flyweight Factory"
       - Manages and caches Character objects
       - Ensures identical characters are reused rather than created
       - Provides statistics on memory savings
       - Includes cache management and clearing functionality
     - **TextEditor** ([TextEditor.java](app/src/main/java/org/codeposito/structural/flyweight/TextEditor.java)) - The "Client" class
       - Manages a collection of CharacterContext objects
       - Uses the flyweight factory to create/reuse characters
       - Provides text display and management functionality
       - Demonstrates memory efficiency through character reuse
     - **FlyweightClient** ([FlyweightClient.java](app/src/main/java/org/codeposito/structural/flyweight/FlyweightClient.java)) - Demo client
       - Comprehensive demonstration of the flyweight pattern
       - Shows memory efficiency with repeated characters
       - Demonstrates different character styles and their reuse
       - Analyzes memory savings and cache statistics
     - **Comprehensive test coverage** ([FlyweightTest.java](app/src/test/java/org/codeposito/structural/flyweight/FlyweightTest.java))
       - Tests all flyweight components and their interactions
       - Validates character reuse and memory efficiency
       - Ensures proper caching and factory functionality
       - Tests bounds checking and error scenarios

Key Features:
- **Memory Efficiency**: Identical characters are shared rather than duplicated
- **Intrinsic State**: Character properties (value, font, size, color) are shared
- **Extrinsic State**: Position information (row, column) is unique per context
- **Factory Pattern**: Centralized character creation and caching
- **Statistics Tracking**: Real-time monitoring of memory savings
- **Cache Management**: Ability to clear cache and reset statistics
- **Comprehensive Testing**: Full test coverage for all flyweight scenarios
- **Real-world Example**: Practical text editor with efficient character management

Usage Examples:
```java
// Create a text editor
TextEditor editor = new TextEditor(10, 50);

// Add characters (identical ones will be reused)
editor.addCharacter(0, 0, 'H', "Arial", 16, "blue");
editor.addCharacter(0, 1, 'e', "Arial", 16, "blue");
editor.addCharacter(0, 2, 'l', "Arial", 16, "blue");
editor.addCharacter(0, 3, 'l', "Arial", 16, "blue"); // Reused from position (0,2)
editor.addCharacter(0, 4, 'o', "Arial", 16, "blue");

// Add the same character at different positions
editor.addCharacter(1, 0, 'H', "Arial", 16, "blue"); // Reused from position (0,0)
editor.addCharacter(1, 1, 'i', "Arial", 16, "blue");

// Display the text
editor.displayText();

// Check memory efficiency
CharacterFactory.printStatistics();
// Output shows:
// - Total characters created: 5 (unique characters)
// - Total characters reused: 2 (shared instances)
// - Memory saved: 28.6% (2 reused out of 7 total requests)
```

Benefits:
- **Memory Reduction**: Significantly reduces memory usage when many objects share common state
- **Performance Improvement**: Faster object creation through caching
- **Scalability**: Efficiently handles large numbers of similar objects
- **Resource Management**: Better utilization of system resources
- **Maintainability**: Centralized state management through factory
- **Flexibility**: Easy to add new shared states without affecting existing code
- **Real-world Applicability**: Perfect for text editors, game engines, graphics systems, and any application with many similar objects

### Behavioral Patterns

Behavioral patterns focus on communication between objects, how objects interact and distribute responsibility.

#### Chain of Responsibility Pattern
The Chain of Responsibility pattern creates a chain of receiver objects for a request. Each receiver either handles the request or passes it to the next receiver in the chain. This pattern decouples the sender from the receiver and allows multiple objects to handle the request.

Current implementations:

1. [Customer Service Chain](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/)
   - Demonstrates a customer service system where different types of requests are handled by specialized handlers
   - Shows how requests flow through a chain until they find the appropriate handler
   - Implementation includes:
     - **Handler** ([Handler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/Handler.java)) - Abstract base class
       - Defines the interface for all handlers in the chain
       - Implements the template method pattern for request handling
       - Manages the next handler in the chain
       - Provides default behavior for unhandled requests
     - **Request** ([Request.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/Request.java)) - Request object
       - Contains request type, description, and priority
       - Immutable object with getter methods
       - Supports toString() for debugging and logging
     - **RequestType** ([RequestType.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/RequestType.java)) - Enum
       - Defines different types of requests (LOGIN, PURCHASE, REFUND, COMPLAINT, TECHNICAL_SUPPORT, GENERAL_INQUIRY)
       - Provides type safety for request handling
     - **Concrete Handlers**:
       - **LoginHandler** ([LoginHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/LoginHandler.java)) - Handles authentication requests
       - **PurchaseHandler** ([PurchaseHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/PurchaseHandler.java)) - Handles purchase transactions
       - **RefundHandler** ([RefundHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/RefundHandler.java)) - Handles refund requests
       - **ComplaintHandler** ([ComplaintHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/ComplaintHandler.java)) - Handles customer complaints
       - **TechnicalSupportHandler** ([TechnicalSupportHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/TechnicalSupportHandler.java)) - Handles technical issues
       - **GeneralInquiryHandler** ([GeneralInquiryHandler.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/GeneralInquiryHandler.java)) - Handles general inquiries
     - **ChainOfResponsibilityClient** ([ChainOfResponsibilityClient.java](app/src/main/java/org/codeposito/behavioral/chainOfResponsibility/ChainOfResponsibilityClient.java)) - Demo client
       - Comprehensive demonstration of the chain of responsibility pattern
       - Shows chain setup and request processing
       - Demonstrates how requests flow through the chain
       - Tests various request types and error handling
     - **Comprehensive test coverage** ([ChainOfResponsibilityTest.java](app/src/test/java/org/codeposito/behavioral/chainOfResponsibility/ChainOfResponsibilityTest.java))
       - Tests all handler types and their capabilities
       - Validates chain setup and request flow
       - Ensures proper request type handling
       - Tests request properties and enum values

Key Features:
- **Chain Setup**: Flexible chain configuration with method chaining
- **Request Routing**: Automatic routing of requests to appropriate handlers
- **Fallback Handling**: Graceful handling of unhandled requests
- **Type Safety**: Enum-based request types prevent invalid requests
- **Extensibility**: Easy to add new handlers without modifying existing code
- **Decoupling**: Senders don't need to know about specific handlers
- **Comprehensive Testing**: Full test coverage for all chain scenarios
- **Real-world Example**: Practical customer service system implementation

Usage Examples:
```java
// Create handlers
Handler loginHandler = new LoginHandler();
Handler purchaseHandler = new PurchaseHandler();
Handler refundHandler = new RefundHandler();

// Set up the chain
loginHandler
    .setNext(purchaseHandler)
    .setNext(refundHandler);

// Create requests
Request loginRequest = new Request(RequestType.LOGIN, "User login", 1);
Request purchaseRequest = new Request(RequestType.PURCHASE, "Product purchase", 2);

// Process requests through the chain
loginHandler.handle(loginRequest);    // Handled by LoginHandler
loginHandler.handle(purchaseRequest); // Handled by PurchaseHandler
```

Benefits:
- **Loose Coupling**: Senders don't need to know which handler will process their request
- **Single Responsibility**: Each handler has a specific responsibility
- **Open/Closed Principle**: Easy to add new handlers without modifying existing code
- **Flexible Chain**: Chain can be dynamically configured at runtime
- **Error Handling**: Graceful handling of unhandled requests
- **Maintainability**: Clear separation of concerns makes code easier to maintain
- **Scalability**: Easy to add new request types and handlers

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
│   │               │   ├── facade/
│   │               │   ├── flyweight/
│   │               │   └── proxy/
│   │               └── behavioral/
│   │                   └── chainOfResponsibility/
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
│                   │   ├── facade/
│                   │   ├── flyweight/
│                   │   └── proxy/
│                   └── behavioral/
│                       └── chainOfResponsibility/
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