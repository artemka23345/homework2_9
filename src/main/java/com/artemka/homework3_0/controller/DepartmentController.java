package com.artemka.homework3_0.controller;

import com.artemka.homework3_0.model.Employee;
import com.artemka.homework3_0.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("{id}/employees")
    public ResponseEntity<?> getAllByDepartment(@PathVariable("id") Integer department) {
        return ResponseEntity.ok(service.getAllByDepartment(department));
    }

    @GetMapping("/{id}/salary/max")
    public Employee maxSalary(@PathVariable("id") Integer department) {
        return service.maxSalary(department);
    }

    @GetMapping("/{id}/salary/min")
    public Employee minSalary(@PathVariable("id") Integer department) {
        return service.minSalary(department);
    }

    @GetMapping("/{id}/salary/sum")
    public int sumSalaryDepartment(@PathVariable("id") Integer department) {
        return service.sumSalary(department);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAll() {
        return service.getAll();
    }

}
