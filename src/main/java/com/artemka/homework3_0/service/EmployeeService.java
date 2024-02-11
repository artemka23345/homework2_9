package com.artemka.homework3_0.service;

import com.artemka.homework3_0.model.Employee;
import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);
    Employee remove(String firstName, String lastName, int department, int salary);
    Employee find(String firstName, String lastName, int department, int salary);
    void validateInput(String firstName, String lastName);
    Collection<Employee> getEmployees();

}