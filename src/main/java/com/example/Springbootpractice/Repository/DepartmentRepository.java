package com.example.Springbootpractice.Repository;

import com.example.Springbootpractice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
