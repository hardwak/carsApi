package com.example.software_partner.cars_api.cars.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record CarCreationDTO(
        @NotBlank
        String model,
        @DecimalMin("1850")
        @DecimalMax("2024")
        Integer year,
        Integer manufacturerId
) {
}
