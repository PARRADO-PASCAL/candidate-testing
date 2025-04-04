package com.example.SpringbootCandidate.Repository;

import com.example.SpringbootCandidate.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
