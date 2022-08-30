package com.example.Springbootpractice.Controller;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;//why we are using the service instead of directly using the repository is because
    //when we are in a real application, there is a business logic processing in this stage and then only after this we
    // return the response

    @PostMapping("/departments")
    private List<Department> saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
//        departmentRepository.save(department);
//        System.out.println("the value recieved is "+department);
//        return departmentRepository.findAll();
    }
    @GetMapping("/departments")
    private List<Department> getDepartment()
    {
        return departmentService.getDepartment();
    }

    @GetMapping("/departments/{id}")
    private Department getDepartmentById(@PathVariable(value = "id") Long id)
    {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    private List<Department> deleteDepartment(@PathVariable(value = "id") Long id)
    {
        return departmentService.deleteDepartmentByID(id);
    }

    @PutMapping("/departments/{id}")
    private List<Department> updateDepartment(@PathVariable(value = "id") Long id,@RequestParam(name = "name") String departmentName)
    {
        return departmentService.updateDepartment(id,departmentName);
    }
}
