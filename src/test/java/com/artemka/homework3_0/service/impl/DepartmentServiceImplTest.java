package com.artemka.homework3_0.service.impl;

import com.artemka.homework3_0.exeptions.EmployeeNotFoundException;
import com.artemka.homework3_0.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static com.artemka.homework3_0.EmployeeTestConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;


    private List<Employee> employees = List.of(
            new Employee("Viktor", "Seleznev", 1, 50_000),
            new Employee("Ivan", "Ivanov", 1, 60_000),
            new Employee("Maksim", "Maksimov", 2, 100_000));


    @Test
    void maxSalaryTest() {
        when(employeeService.getEmployees()).thenReturn(employees);

        assertEquals(employees.get(1), out.maxSalary(DEPARTMENT));
    }

    @Test
    void minSalaryTest() {
        when(employeeService.getEmployees()).thenReturn(employees);

        assertEquals(employees.get(0), out.minSalary(DEPARTMENT));
    }

    @Test
    void findMinSalaryEmployeeNotFoundException() {
        when(employeeService.getEmployees()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(DEPARTMENT));
    }

    @Test
    void returnAllEmployeesInDepartment() {
        when(employeeService.getEmployees()).thenReturn(employees);

        assertEquals(List.of(employees.get(0), employees.get(1)), out.getAllByDepartment(DEPARTMENT));
    }

    @Test
    void getAllEmployeesInDepartmentEmpty() {
        when(employeeService.getEmployees()).thenReturn(Collections.emptyList());

        assertEquals(List.of(), out.getAllByDepartment(DEPARTMENT));
    }

    @Test
    void getAllEmployeeInDepartments() {
        when(employeeService.getEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> expectedMap = Map.of(
                1, List.of(employees.get(0), employees.get(1)),
                2, List.of(employees.get(2)));

        assertEquals(expectedMap, out.getAll());
    }

    @Test
    void getAllReturnEmptyListWhenEmployeeIsNotFoundInMap() {
        when(employeeService.getEmployees()).thenReturn(Collections.emptyList());

        assertEquals(Map.of(), out.getAll());

    }
}
