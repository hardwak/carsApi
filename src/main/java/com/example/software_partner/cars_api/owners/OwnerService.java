package com.example.software_partner.cars_api.owners;

import com.example.software_partner.cars_api.owners.dto.OwnerCreationDTO;
import com.example.software_partner.cars_api.owners.dto.OwnerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public OwnerCreationDTO createOwner(OwnerCreationDTO ownerCreationDTO) {
        ownerRepository.save(ownerMapper.toOwner(ownerCreationDTO));
        return ownerCreationDTO;
    }

    public OwnerResponseDTO getOwnerById(int id) {
        return ownerMapper.toOwnerResponseDTO(ownerRepository.findById(id).orElse(null));
    }

    public List<OwnerResponseDTO> getOwnersByLastname(String name) {
        return ownerRepository.findAllByLastNameContaining(name)
                .stream()
                .map(ownerMapper::toOwnerResponseDTO)
                .toList();
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }

    public List<OwnerResponseDTO> getAllOwners() {
        return ownerRepository
                .findAll()
                .stream()
                .map(ownerMapper::toOwnerResponseDTO)
                .toList();
    }
}
