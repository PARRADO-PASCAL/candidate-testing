package com.example.SpringbootCandidate.Controller;

import com.example.SpringbootCandidate.Entity.Department;
import com.example.SpringbootCandidate.Error.DepartmentNotFoundException;
import com.example.SpringbootCandidate.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;

    @PostMapping()
    private List<Department> saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping()
    private List<Department> getDepartment() {
        LOGGER.info("Recieved the first request");
        return departmentService.getDepartment();
    }

    @GetMapping("/{id}")
    private Department getDepartmentById(@PathVariable(value = "id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    private List<Department> deleteDepartment(@PathVariable(value = "id") Long id) {
        return departmentService.deleteDepartmentByID(id);
    }

    @PutMapping("{id}")
    private List<Department> updateDepartment(@PathVariable(value = "id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/name")
    private Department getDepartmentByName(@RequestParam(name = "departmentName") String departmentName) {
        System.out.println("departmentName = " + departmentName);
        return departmentService.getDepartmentByName(departmentName);

    }
}
