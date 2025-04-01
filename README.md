# Selenium Automation Framework

## Overview
This is a **robust Selenium Automation Framework** designed for **Web UI ** . It follows industry best practices, ensuring reusability, maintainability, and scalability.

## Features
- **Supports multiple browsers** (Chrome, Firefox, Edge) using WebDriverManager.
- **Page Object Model (POM)** with enhanced element interaction methods.
- **Custom WebDriver Event Listener** for logging interactions and errors.
- **Global Configuration Management** via `config.properties`.
- **Pre-commit Hook** for formatting & best practices validation.

---

## Setup & Installation
### Prerequisites
- Install **Java 11+**
- Install **Maven** (`mvn -version` to verify)
- Install **Git**

### Installation Steps
1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-repo-name.git
   cd selenium-framework
   ```
2. **Install dependencies**:
   ```sh
   mvn clean install
   ```
3. **Configure `config.properties`** (Browser, URL, Timeouts)

---

## Running Tests
### **1. Run Tests Locally**
#### Web UI Tests
```sh
mvn test -Dtest=LogInTests
```
#### Run All Tests
```sh
mvn clean test
```

---

## Configuration (config.properties)
```
# Browser settings
browser=chrome
headless=true

# URL Settings
base.url=https://www.demoblaze.com/index.html

# Timeouts
default.wait.time=10
page.load.timeout=15

```

---


---

## Enhancements & Future Scope
- Implement **Cucumber BDD** for better test readability.
- Integrate **Jenkins/GitHub Actions** for CI/CD.
- Enhance **Database testing capabilities**.
- Implement **AI-driven test optimizations**.

---

## Contributing
- Follow **Java Coding Standards**.
- Use **pull requests** for changes.
- Ensure **all test cases pass before commit**.
- Run `mvn spotless:apply` to format code before committing.

---
**📧 Contact:**
For queries, reach out to `htrivedi114@gmail.com`

