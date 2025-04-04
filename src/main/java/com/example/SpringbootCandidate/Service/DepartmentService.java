package com.example.SpringbootCandidate.Service;

import com.example.SpringbootCandidate.Entity.Department;
import com.example.SpringbootCandidate.Error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentByID(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name);
}
