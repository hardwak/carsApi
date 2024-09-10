package com.example.software_partner.cars_api.cars.dto;

import jakarta.validation.constraints.NotBlank;

public record CarDTO(
        @NotBlank
        String model,

        int year,
        int manufacturerId
) {
}
