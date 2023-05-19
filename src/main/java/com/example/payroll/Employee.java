package com.example.payroll;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

// @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
@Entity
class Employee {
    // id, name, and role are attributes of the Employee domain object. id is marked with more JPA annotations
    // to indicate it's the PK and automatically populated by the JPA provider.
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public Employee() {}

    // A custom constructor is created when a new instance is neeeded but there isn't an id yet.
    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
