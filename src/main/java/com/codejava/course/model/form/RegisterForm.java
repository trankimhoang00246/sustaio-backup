package com.codejava.course.model.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterForm {
    @NotEmpty(message = "Username is required")
    @Size(min = 5, message = "Username must be at least 5 characters long")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;
    @NotEmpty(message = "Name is required")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
}
