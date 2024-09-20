package com.example.software_partner.cars_api.cars.dto;

public record CarFullDTO(
        Integer id,
        String model,
        Integer year,
        Integer manufacturerId,
        String manufacturer
) {}
