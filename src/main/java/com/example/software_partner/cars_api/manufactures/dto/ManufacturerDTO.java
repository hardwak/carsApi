package com.example.software_partner.cars_api.manufactures.dto;

import jakarta.validation.constraints.NotEmpty;

public record ManufacturerDTO(
        @NotEmpty
        String manufacturerName
) {
}
