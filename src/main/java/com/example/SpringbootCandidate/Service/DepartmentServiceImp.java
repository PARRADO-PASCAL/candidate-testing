package com.example.SpringbootCandidate.Service;

import com.example.SpringbootCandidate.Entity.Department;
import com.example.SpringbootCandidate.Error.DepartmentNotFoundException;
import com.example.SpringbootCandidate.Repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
         return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department does not exsist");
        } else {
            return department.get();
        }
    }

    @Override
    public void deleteDepartmentByID(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        if(departmentRepository.existsById(id))
        {
            Department department1 = departmentRepository.findById(id).get();
            if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName()))
            {
                department1.setName(department.getName());
            }
            if(Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode()))
            {
                department1.setCode(department.getCode());
            }
            return departmentRepository.save(department1);
        }
        throw new IllegalStateException("Department with id " + id + " does not exist");
    }

    @Override
    public Department getDepartmentByName(String name) {
        return null;
    }
}
