package com.example.software_partner.cars_api.cars.dto;

public record CarResponseDTO(
        String model,
        int year,
        String manufacturer
) {
}
