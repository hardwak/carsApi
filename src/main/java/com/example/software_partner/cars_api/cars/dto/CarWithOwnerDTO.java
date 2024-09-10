package com.example.software_partner.cars_api.cars.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CarWithOwnerDTO(
        @NotBlank
        String model,
        @Size(min = 4, max = 4)
        int year,
        String manufacturer,
        String owner
) {
}
