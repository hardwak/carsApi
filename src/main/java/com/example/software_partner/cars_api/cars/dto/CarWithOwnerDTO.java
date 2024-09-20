package com.example.software_partner.cars_api.cars.dto;

public record CarWithOwnerDTO(
        String model,
        Integer year,
        String manufacturer,
        String owner
) {
}
