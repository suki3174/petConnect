package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AdoptionOffer extends Post{
    @Enumerated(EnumType.STRING)
    private Status_Adoption status;
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    public AdoptionOffer(String description, Date date, String title, String location, byte[] image, Status_Adoption status, Pet pet){
        super(description,date,title,location,image);
        this.status=status;
        this.pet=pet;
    }
    //No Image Constructor
    public AdoptionOffer(String description, Date date, String title, String location, Status_Adoption status, Pet pet){
        super(description,date,title,location);
        this.status=status;
        this.pet=pet;
    }

}
