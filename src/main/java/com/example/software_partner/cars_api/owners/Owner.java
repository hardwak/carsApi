package com.example.software_partner.cars_api.owners;

import com.example.software_partner.cars_api.cars.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Owner {
    @Id
    @GeneratedValue
    private int ownerId;
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    @Column(unique = true)
    private String phone;
    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

    public Owner(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
