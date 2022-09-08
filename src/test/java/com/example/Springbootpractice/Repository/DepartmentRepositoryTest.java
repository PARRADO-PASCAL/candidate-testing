package com.example.Springbootpractice.Repository;

import com.example.Springbootpractice.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentId(1l).departmentName("Mechanical").departmentAddress("hi").departmentCode("IT").build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturn()
    {
        String name = "Mechanical";
        Department department = departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName(),name);

    }
}