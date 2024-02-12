package com.artemka.homework3_0;

import com.artemka.homework3_0.model.Employee;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;


    public class EmployeeTestConstant {
        public static final String FIRST_NAME = "Алексей";
        public static final String LAST_NAME = "Иванов";
        public static final int SALARY = 100000;
        public static final int MIN_SALARY = 50000;
        public static final int DEPARTMENT = 1;


        public static final String FIRST_NAME_2 = "Сергей";
        public static final String LAST_NAME_2 = "Петров";

        public static final String FIRST_NAME_3 = "Сергей*-";
        public static final String LAST_NAME_3 = "Петров*-";



        public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME,LAST_NAME,DEPARTMENT,SALARY);
        public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME,LAST_NAME,DEPARTMENT,MIN_SALARY);
        public static final List<Employee> EMPLOYEES = List.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);
        public static final Employee DIFFRENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME,LAST_NAME,DEPARTMENT,SALARY);
        public static final Set<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, DIFFRENT_DEPARTMENT_EMPLOYEE);
        public static final Map<Integer, List<Employee>> DEPARTMENT_MAP =
                DIFFERENT_DEPARTMENT_EMPLOYEES.stream().collect(groupingBy(Employee::getDepartment));
    }

