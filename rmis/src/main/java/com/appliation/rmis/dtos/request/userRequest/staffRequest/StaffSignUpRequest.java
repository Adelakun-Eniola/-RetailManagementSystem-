package com.appliation.rmis.dtos.request.userRequest.staffRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class StaffSignUpRequest {
    @NotBlank(message = "firstName is required")
    private String firstName;
    @NotBlank(message = "lastName is required")
    private String lastName;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email Address is required")
    private String emailAddress;
    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    @Pattern(regexp = "\\d{10,15}", message = "Phone number must contain only digits")
    private String phoneNumber;
    @Size(min=8, message = "Password must be at least 8 characters!!")
    private String password;


    public StaffSignUpRequest(String firstName, String lastName, String emailAddress, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
