package com.artemka.homework3_0.model;

import java.util.Objects;

public class Employee {
    String fistName;
    String lastName;
    int department;
    int salary;

    public Employee(String fistName, String lastName, int department, int salary) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFestName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fistName, employee.fistName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
