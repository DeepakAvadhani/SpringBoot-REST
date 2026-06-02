package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message="Email cannot be left empty")
    @Email(message="Invalid Email")
    private String email;

    @Positive(message = "Salary must be positive")
    private Double salary;
}
