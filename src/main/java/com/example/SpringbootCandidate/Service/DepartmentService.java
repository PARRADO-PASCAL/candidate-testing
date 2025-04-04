package com.example.SpringbootCandidate.Service;

import com.example.SpringbootCandidate.Entity.Department;
import com.example.SpringbootCandidate.Error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public List<Department> saveDepartment(Department department);

    List<Department> getDepartment();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    List<Department> deleteDepartmentByID(Long id);

    List<Department> updateDepartment(Long id, String departmentName);

    List<Department> updateDepartment(Long id, Department department);

    Department getDepartmentByName(String departmentName);
}
