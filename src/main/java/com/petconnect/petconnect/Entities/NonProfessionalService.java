package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class NonProfessionalService extends Service{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "nonProfessionalServices")
    private List<User> providers = new ArrayList<>();

    public NonProfessionalService(String name, String type, String location, String description){
        super(name, type, location, description);
    }
}
