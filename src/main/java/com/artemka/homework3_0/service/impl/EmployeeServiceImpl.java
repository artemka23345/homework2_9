package com.artemka.homework3_0.service.impl;

import com.artemka.homework3_0.service.EmployeeService;
import com.artemka.homework3_0.exeptions.EmployeeAlreadyAddedException;
import com.artemka.homework3_0.exeptions.EmployeeNotFoundException;
import com.artemka.homework3_0.model.Employee;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final Map<String, Employee> employeeBook;


    public EmployeeServiceImpl() {

this.employeeBook = Maps.newHashMap(Map.of(
                "Алексей Андреев", new Employee("Алексей", "Андреев", 1, 65000),
                "София Иванова", new Employee("София", "Артёмовна", 2, 64000),
                "Алиса Колесникова ", new Employee("Алиса", " Колесникова", 3, 63000),
                "Гордей Балашов", new Employee("Гордей", "Балашов", 5, 47000),
                "Артём Горбунов", new Employee("Артём", "Горбунов", 5, 28000),
                "Ксения Кириллова", new Employee("Ксения", "Кириллова", 3, 54000)));

    }



    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeBook.put(employee.getFullName(), employee);
        return employee;
    }

    @Override

    public Employee remove(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override

    public Employee find(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();

    }


    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }
}
