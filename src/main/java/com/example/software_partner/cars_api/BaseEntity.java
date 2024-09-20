package com.example.software_partner.cars_api;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
