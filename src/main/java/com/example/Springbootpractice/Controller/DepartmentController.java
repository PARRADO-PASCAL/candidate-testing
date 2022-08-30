package com.example.Springbootpractice.Controller;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Repository.DepartmentRepository;
import com.example.Springbootpractice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @PostMapping("/departments")
    private List<Department> saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
//        departmentRepository.save(department);
//        System.out.println("the value recieved is "+department);
//        return departmentRepository.findAll();
    }
}
