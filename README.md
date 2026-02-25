# SauceDemo Playwright TDD – Component Based Hybrid Automation Framework

A senior-level test automation framework built with:

- Java 17
- Playwright (UI Automation)
- REST Assured (API Testing)
- JUnit 5
- Maven
- Component-Based Architecture
- TDD (Test Driven Development)

This project demonstrates a hybrid UI + API automation architecture following clean code and enterprise-level design principles.

---

# Architecture Overview
```
src/test/java/com/saucedemo
│
├── core
│   └── BaseTest
│
├── pages
│   ├── BasePage
│   ├── LoginPage
│   ├── ProductsPage
│   ├── CartPage
│   └── CheckoutPage
│
├── components
│   ├── BaseComponent
│   ├── LoginFormComponent
│   ├── ProductCardComponent
│   └── CheckoutFormComponent
│
└── api
    ├── client
    │   ├── BaseApiClient
    │   └── UserClient
    │
    ├── model
    │   ├── User
    │   └── UserResponse
    │
    ├── contract
    │   └── user-schema.json
    │
    └── tests
        ├── UserApiContractTest
        └── UserApiNegativeTest
```

# 🎯 Key Design Principles

### ✅ Component-Based UI Design
Each reusable UI block is encapsulated as a component.

Example:
- `LoginFormComponent`
- `ProductCardComponent`
- `CheckoutFormComponent`

This ensures:
- High maintainability
- Better scalability
- Clean separation of concerns

---

### Page Object Model (Refined)
Pages handle navigation and high-level business behavior.
Components handle UI details.

---

### TDD Workflow
Tests are written before implementation:
1. Write failing test
2. Implement minimal logic
3. Refactor

---

### API Architecture
- Base API client abstraction
- Centralized request specification
- POJO response mapping
- JSON Schema contract validation
- Positive & negative test scenarios

