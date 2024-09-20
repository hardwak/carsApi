package com.example.software_partner.cars_api.cars.dto;

public record CarResponseDTO(
        String model,
        Integer year,
        String manufacturer
) {
}
