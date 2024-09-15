package com.example.software_partner.cars_api.owners;

import com.example.software_partner.cars_api.owners.dto.OwnerCreationDTO;
import com.example.software_partner.cars_api.owners.dto.OwnerFullDTO;
import com.example.software_partner.cars_api.owners.dto.OwnerResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapper {
    public Owner toOwner(OwnerCreationDTO dto){
        return new Owner(
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.phone()
        );
    }

    public OwnerResponseDTO toOwnerResponseDTO(Owner owner){
        if(owner == null)
            return null;

        return new OwnerResponseDTO(owner.getFirstName(), owner.getLastName(), owner.getEmail(), owner.getPhone());
    }

    public OwnerFullDTO toOwnerFullDTO(Owner owner){
        return new OwnerFullDTO(
                owner.getOwnerId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getEmail(),
                owner.getPhone()
        );
    }
}
