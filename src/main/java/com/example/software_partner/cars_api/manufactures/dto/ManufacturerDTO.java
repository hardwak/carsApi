package com.example.software_partner.cars_api.manufactures.dto;

import jakarta.validation.constraints.NotBlank;

public record ManufacturerDTO(
        @NotBlank
        String manufacturerName
) {
}
