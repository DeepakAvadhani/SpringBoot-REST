package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Department cannot be empty")
    private String department;

    @NotBlank(message = "Salary cannot be empty")
    private Double salary;
}