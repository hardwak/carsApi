package com.example.software_partner.cars_api.owners.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record OwnerCreationDTO(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @Email
        String email,
        String phone
) {
        @AssertTrue
        public boolean firstNameOrLastNameAreValid() {
                return !firstName.isBlank() || !lastName.isBlank();
        }
}
