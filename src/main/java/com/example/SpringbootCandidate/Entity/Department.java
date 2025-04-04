package com.example.SpringbootCandidate.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", sequenceName = "department_sequence", allocationSize = 1)
    private Long id;
    @NotBlank(message = "Please provide the department name")
    private String name;
    private String code;
}
