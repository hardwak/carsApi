package com.example.software_partner.cars_api.owners.dto;

public record OwnerFullDTO(
        int id,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
