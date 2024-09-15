package com.example.software_partner.cars_api.cars.dto;

public record CarWithOwnerDTO(
        String model,
        int year,
        String manufacturer,
        String owner
) {
}
