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

#### Factory Pattern (Coming Soon)
- Abstract Factory
- Factory Method
- Simple Factory

#### Builder Pattern (Coming Soon)
- Classic Builder
- Fluent Builder
- Builder with Director

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
│   │               │   └── singleton/
│   │               ├── structural/     (Coming Soon)
│   │               └── behavioral/     (Coming Soon)
│   └── test/
│       └── java/
│           └── org/
│               └── codeposito/
│                   ├── creational/
│                   │   └── singleton/
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