package com.artemka.homework3_0.service.impl;


import com.artemka.homework3_0.exeptions.EmployeeAlreadyAddedException;
import com.artemka.homework3_0.exeptions.EmployeeNotFoundException;
import com.artemka.homework3_0.exeptions.InvalidInputException;
import com.artemka.homework3_0.model.Employee;
import com.artemka.homework3_0.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static com.artemka.homework3_0.EmployeeTestConstant.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmployeeServiceImplTest {
    private final EmployeeService out = new EmployeeServiceImpl();

    @Test
    void shouldAddEmployeeTest() {

        Employee expected = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertEquals(0, out.getEmployees().size());
        assertFalse(out.getEmployees().contains(expected));

        Employee actual = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertEquals(expected, actual);
        assertEquals(1, out.getEmployees().size());
        assertTrue(out.getEmployees().contains(expected));

    }

    @Test
    void shouldThrowEmployeeAlreadyAddedExceptionTest() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertTrue(out.getEmployees().contains(existed));
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldFindEmployeeTest() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertEquals(existed, out.find(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionTest() {
        assertEquals(0, out.getEmployees().size());

        assertThrows(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldRemoveEmployeeTest() {
        Employee expected = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertEquals(1, out.getEmployees().size());
        assertTrue(out.getEmployees().contains(expected));

        Employee actual = out.remove(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        assertEquals(expected, actual);
        assertTrue(out.getEmployees().isEmpty());
        assertFalse(out.getEmployees().contains(expected));
    }

    @Test
    void shouldThrowEmployeeRemoveNotFoundExceptionTest() {
        assertTrue(out.getEmployees().isEmpty());

        assertThrows(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldReturnEmptyCollectionTest() {
        assertIterableEquals(emptyList(), out.getEmployees());
    }

    @Test
    void shouldReturnListTest() {
        Employee employee = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY);

        Employee employee2 = out.add(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT, SALARY);

        Collection<Employee> existed = List.of(employee, employee2);

        Collection<Employee> actual = out.getEmployees();

        assertIterableEquals(existed, actual);
    }
    @Test
    void shouldThrowInvalidInputExceptionTest() {
        assertThrows(InvalidInputException.class, () -> out.validateInput(FIRST_NAME_3, LAST_NAME_3));
    }
}
