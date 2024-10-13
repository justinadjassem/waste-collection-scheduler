package com.wcs.waste_collection_scheduler.citizen;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CitizenDTO {
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    @Pattern(regexp = "^(\\+228)?[279][0-9]{7}$", message = "Invalid phone number")
    private String phone;
}
