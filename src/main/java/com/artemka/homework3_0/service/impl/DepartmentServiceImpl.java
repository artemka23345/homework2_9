package com.artemka.homework3_0.service.impl;

import com.artemka.homework3_0.service.DepartmentService;
import com.artemka.homework3_0.exeptions.EmployeeNotFoundException;
import com.artemka.homework3_0.model.Employee;
import com.artemka.homework3_0.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService service;

    public DepartmentServiceImpl(EmployeeService service) {
        this.service = service;
    }

    @Override
    public List<Employee> getAllByDepartment(int department) {
        return service.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAll() {
        return service.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee maxSalary(int department) {
        return service.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);

    }

    @Override
    public Employee minSalary(int department) {
        return service.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary)).orElseThrow(EmployeeNotFoundException::new);

    }
    @Override
    public int sumSalary(int department) {
        return service.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
}
