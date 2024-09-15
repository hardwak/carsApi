package com.example.software_partner.cars_api.owners.dto;

import jakarta.validation.constraints.*;

public record OwnerCreationDTO(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @Email @NotNull String email,
        @Size(min = 6, max = 20)
        String phone
) {
        @AssertTrue
        public boolean firstNameOrLastNameAreValid() {
                return !firstName.isBlank() || !lastName.isBlank();
        }
}
