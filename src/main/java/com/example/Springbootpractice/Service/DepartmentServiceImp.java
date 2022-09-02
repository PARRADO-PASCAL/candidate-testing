package com.example.Springbootpractice.Service;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Error.DepartmentNotFound;
import com.example.Springbootpractice.Repository.DepartmentRepository;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> saveDepartment(Department department) {
         departmentRepository.save(department);
         return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFound {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFound("Department does not exsist");
        } else {
            return department.get();
        }
    }

    @Override
    public List<Department> deleteDepartmentByID(Long id) {
        departmentRepository.deleteById(id);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> updateDepartment(Long id, String departmentName) {
        if(departmentRepository.existsById(id))
        {
            Department department = departmentRepository.findById(id).get();
            department.setDepartmentName(departmentName);
            departmentRepository.save(department);
        }
        else {
            throw new IllegalStateException("the instance is not available");
        }
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> updateDepartment(Long id, Department department) {
        if(departmentRepository.existsById(id))
        {
            Department department1 = departmentRepository.findById(id).get();
            if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
            {
                department1.setDepartmentName(department.getDepartmentName());
            }
            if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
            {
                department1.setDepartmentAddress(department.getDepartmentAddress());
            }
            if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
            {
                department1.setDepartmentCode(department.getDepartmentCode());
            }
            departmentRepository.save(department1);


        }
return departmentRepository.findAll();
    }

    //this is for our custom data entity search yeah okay
    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

    }
}
