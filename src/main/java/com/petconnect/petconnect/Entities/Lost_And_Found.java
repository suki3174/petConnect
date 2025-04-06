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
public class Lost_And_Found extends Post {
    @Enumerated(EnumType.STRING)
    Status_LostAndFound status;
    Pet pet;
    public Lost_And_Found(String description, Date date, String title, String location, byte[] image,Status_LostAndFound status,Pet pet){
        super(description,date,title,location,image);
        this.status=status;
        this.pet=pet;
    }
    //No Image Constructor
    public Lost_And_Found(String description, Date date, String title, String location,Status_LostAndFound status,Pet pet){
        super(description,date,title,location);
        this.status=status;
        this.pet=pet;
    }

}
