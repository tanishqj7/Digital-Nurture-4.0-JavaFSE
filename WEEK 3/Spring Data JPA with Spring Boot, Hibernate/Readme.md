# Hands-on 4: JPA vs Hibernate vs Spring Data JPA

This document explains the **differences, use cases, and practical examples** for **JPA, Hibernate, and Spring Data JPA**, which are essential technologies for managing relational data in Java applications.

---

## 📌 What is JPA?

- **Java Persistence API (JPA)** is a **Java specification** for mapping Java objects to relational database tables.
- It defines **annotations and interfaces** to manage data persistence.
- **JPA is only a specification and does not provide an implementation**.
- It allows developers to write **database-independent ORM code** while using different JPA providers like Hibernate for actual implementation.

---

## 📌 What is Hibernate?

- **Hibernate** is a **powerful ORM framework** that **implements JPA** and extends it with advanced features.
- It supports **caching, lazy loading, HQL (Hibernate Query Language), and native SQL queries**.
- Hibernate can be used standalone (without JPA) or as a JPA implementation.
- Developers often **manage transactions and sessions explicitly** when using Hibernate directly.

---

## 📌 What is Spring Data JPA?

- **Spring Data JPA** is a **Spring module that simplifies JPA usage** in Spring-based applications.
- It **does not implement JPA**, but builds on top of JPA and relies on a JPA provider like Hibernate underneath.
- It **reduces boilerplate code** by providing:
  - Repository abstractions (`JpaRepository`, `CrudRepository`)
  - Automatic query generation from method names
  - Built-in transaction management
- It is ideal for **rapid application development using Spring Boot**.

---

## 🪐 Key Differences

| Feature         | JPA (Specification)  | Hibernate (Framework)      | Spring Data JPA (Spring Module) |
|-----------------|-----------------------|-----------------------------|----------------------------------|
| **Type**        | Specification         | ORM Framework & JPA Impl   | Abstraction over JPA            |
| **Scope**       | Standard ORM API      | Advanced ORM features      | Simplifies JPA in Spring        |
| **Dependency**  | Needs implementation  | Can work standalone        | Needs JPA + ORM provider        |
| **API**         | `EntityManager`, JPQL | HQL, Session API, JPA APIs | Repository interfaces, query methods |
| **Use Case**    | Portable ORM code     | Advanced ORM needs         | Simplified Spring data access   |
| **Learning Curve** | Moderate           | Steeper                    | Easiest (requires Spring knowledge) |
| **Flexibility** | Limited to spec       | Highly customizable        | Abstracts complexity, less flexible |

---

## ⚡ How They Work Together

1️⃣ **JPA** provides the standard annotations (`@Entity`, `@Id`, etc.) and contracts for ORM.  
2️⃣ **Hibernate** implements the JPA specification while adding its own advanced features.  
3️⃣ **Spring Data JPA** uses JPA (typically with Hibernate as the provider) to simplify CRUD operations in Spring applications.

---

### Typical Spring Boot Flow:
✅ You create **repository interfaces using Spring Data JPA**.  
✅ Spring Data JPA **delegates ORM operations to Hibernate**.  
✅ Hibernate uses JPA contracts to interact with the database.

---

## 🛠️ Code Comparison

### 1️⃣ Hibernate Example

```java
public Integer addEmployee(Employee employee) {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

    return employeeID;
}
