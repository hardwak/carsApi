package com.example.software_partner.cars_api.cars.dto;

public record CarFullDTO(
        int id,
        String model,
        int year,
        int manufacturerId,
        String manufacturer
) {}
