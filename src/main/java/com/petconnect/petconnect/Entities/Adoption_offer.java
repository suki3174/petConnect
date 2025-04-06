package com.petconnect.petconnect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Adoption_offer extends Post{
    @Enumerated(EnumType.STRING)
    private Status_Adoption status;
    private Pet pet;
    public Adoption_offer(String description, Date date, String title, String location, byte[] image, Status_Adoption status,Pet pet){
        super(description,date,title,location,image);
        this.status=status;
        this.pet=pet;
    }
    //No Image Constructor
    public Adoption_offer(String description, Date date, String title, String location, Status_Adoption status, Pet pet){
        super(description,date,title,location);
        this.status=status;
        this.pet=pet;
    }

}
