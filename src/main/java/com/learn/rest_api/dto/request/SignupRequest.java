package com.learn.rest_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 80, message = "Email must be less than 50 characters")
    private String email;

    @NotBlank (message = "Password is required")
    private String password;

    @NotBlank (message = "Phone is required")
    @Size(max = 15, message = "Phone must be less than 9 characters")
    private String phone;

    @NotBlank (message = "First name is required")
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;

    @NotBlank (message = "Last name is required")
    @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;
}
