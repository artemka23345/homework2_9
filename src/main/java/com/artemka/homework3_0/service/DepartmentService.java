package com.artemka.homework3_0.service;
import com.artemka.homework3_0.model.Employee;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllByDepartment(int department);
    public Map<Integer, List <Employee>> getAll();

    Employee maxSalary(int department);

    Employee minSalary(int department);
}
