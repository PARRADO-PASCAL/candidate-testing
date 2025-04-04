package com.example.SpringbootCandidate.Controller;

import com.example.SpringbootCandidate.Entity.Department;
import com.example.SpringbootCandidate.Error.DepartmentNotFoundException;
import com.example.SpringbootCandidate.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        return
                ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(departmentService.saveDepartment(department));
    }

    @GetMapping()
    private List<Department> getDepartments() {
        LOGGER.info("Recieved the first request");
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    private Department getDepartmentById(@PathVariable(value = "id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartmentByID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    private Department updateDepartment(@PathVariable(value = "id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/search")
    private Department getDepartmentByName(@RequestParam(name = "name") String name) {
        System.out.println("departmentName = " + name);
        return departmentService.getDepartmentByName(name);
    }
}
