package com.example.software_partner.cars_api.owners.dto;

public record OwnerFullDTO(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
