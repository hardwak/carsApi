package com.example.software_partner.cars_api.owners;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    public List<Owner> findAllByLastNameContaining(String lastName);
}
