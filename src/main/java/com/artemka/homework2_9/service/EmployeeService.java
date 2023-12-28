package com.artemka.homework2_9.service;

import com.artemka.homework2_9.model.Employee;
import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);
    Employee remove(String firstName, String lastName, int department, int salary);
    Employee find(String firstName, String lastName, int department, int salary);
    Collection<Employee> getEmployees();

}