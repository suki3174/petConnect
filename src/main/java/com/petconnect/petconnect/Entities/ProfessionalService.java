package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class ProfessionalService extends Service{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "services")
    private List<BusinessOwner> businessOwners = new ArrayList<>();

    public ProfessionalService(String name, String type, String location, String description){
        super(name, type, location, description);
    }
}
