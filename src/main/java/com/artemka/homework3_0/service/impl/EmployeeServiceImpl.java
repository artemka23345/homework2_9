package com.artemka.homework3_0.service.impl;

import com.artemka.homework3_0.exeptions.InvalidInputException;
import com.artemka.homework3_0.service.EmployeeService;
import com.artemka.homework3_0.exeptions.EmployeeAlreadyAddedException;
import com.artemka.homework3_0.exeptions.EmployeeNotFoundException;
import com.artemka.homework3_0.model.Employee;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import java.util.*;
import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final Map<String, Employee> employeeBook;


    public EmployeeServiceImpl() {

this.employeeBook = Maps.newHashMap(Map.of());
    }



    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        employeeBook.put(employee.getFullName(), employee);
        return employee;
    }

    @Override

    public Employee remove(String firstName, String lastName, int department, int salary) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override

    public Employee find(String firstName, String lastName, int department, int salary) {
        validateInput(firstName,lastName);
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

    private void validateInput(String firstName, String lastName){
        if (!(isAlpha(firstName) && isAlpha(lastName))){
            throw new InvalidInputException();
        }
    }
}
