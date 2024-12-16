# Java Selenium Cucumber Test Automation Project

This project serves as a foundational framework for Test Automation projects utilizing Java, Selenium, Cucumber, and TestNG. It supports advanced features such as parallel test execution, retrying failed test cases, and detailed reporting with Allure.

---

## **Tool Stack**
- **Java/Javascript**: Programming Language for development.
- **IntelliJ IDEA**: Integrated Development Environment.
- **Maven**: Dependency and Package Management tool.
- **Cucumber**: Framework for Behavior-Driven Development (BDD) with Gherkin syntax.
- **Selenium**: Web Application Test Automation tool.
- **TestNG**: Testing framework for executing and organizing test cases.

---


## **Installations**
To install the required dependencies, navigate to the project directory and execute the following Maven command:

```bash
mvn clean install
```

---

## **Running Tests**

### **Basic Test Execution**
To execute all tests in the project, use:

```bash
mvn clean test
```

### **Run Specific Test Runner with Parameters**
To execute a specific runner and provide custom parameters, use:

```bash
mvn clean test -Dtest=Runner -D"cucumber.filter.tags=@regression" -Dheadless=true -DthreadCount=5
```

### **Run with Specific Tag**
You can run tests associated with specific tags (e.g., `@register`) using the following command:

```bash
mvn clean test -D"cucumber.filter.tags=@product"
```

#### **Parallel Execution**
Customize thread counts and parameters for optimized parallel execution. Example:

```bash
mvn clean test -D"cucumber.filter.tags=@regression" -DthreadCount=5
```

#### **Headless Execution**
For environments where a graphical interface is unavailable, you can run tests in headless mode:

```bash
mvn clean test -Dheadless=true
```

---

## **Reporting**
Allure Reports are used for detailed test reporting. After test execution, generate the Allure report with:

```bash
allure serve target/allure-results
```

This will start a local server to display the report.

---