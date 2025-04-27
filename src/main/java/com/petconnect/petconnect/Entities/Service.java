package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private String location;
    private String description;
    private boolean validated;

    @JoinColumn(nullable = true)
    private Integer rating;

    public Service(String name, String type, String location, String description){
        this.name=name;
        this.type=type;
        this.location=location;
        this.description=description;
        this.rating=null;
        this.validated=false;//no initial rating when creating
    }
}
