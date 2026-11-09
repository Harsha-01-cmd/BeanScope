# BeanScopeDemo

A Spring Framework demonstration project that teaches **Bean Scopes** — singleton vs prototype.

## 📚 What You'll Learn

- **Singleton Scope** (default): ONE instance per container, shared everywhere
- **Prototype Scope**: NEW instance every time `getBean()` is called
- How Spring wires the same singleton instance into multiple components

## 🏗️ Project Structure

```
BeanScopeDemo/
├── pom.xml                 # Maven config with Spring Framework 7.0.7
└── src/main/java/in/strikes/
    ├── Main.java           # Singleton scope demo
    ├── PrototypeDemo.java  # Prototype scope demo
    ├── AppConfig.java      # @Configuration with @Bean methods
    ├── OrderService.java   # Singleton-scoped service (stateless)
    ├── User.java           # Stateful model (prototype candidate)
    ├── A.java              # Component depending on OrderService
    └── B.java              # Another component depending on OrderService
```

## 🚀 How to Run

1. **Build:**
   ```bash
   mvn clean compile
   ```

2. **Singleton Demo:**
   ```bash
   mvn exec:java -Dexec.mainClass="in.strikes.Main"
   ```
   Output: `OrderService created` (once) + `true` (same instance)

3. **Prototype Demo:**
   ```bash
   mvn exec:java -Dexec.mainClass="in.strikes.PrototypeDemo"
   ```
   Output: `false` for all comparisons (different instances)

## 🔑 Key Concepts

| Scope | Instances | Use For |
|-------|-----------|---------|
| **singleton** (default) | One per container | Stateless services, repos, controllers |
| **prototype** | New per getBean() call | Stateful objects, form data, domain models |

## 📋 Requirements

- **Java 23**
- **Maven 3.6+**
- **Spring Framework 7.0.7**
