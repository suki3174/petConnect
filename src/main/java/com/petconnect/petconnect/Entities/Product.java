package com.petconnect.petconnect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends Post {
    @Enumerated(EnumType.STRING)
    Status_Product status;
    public Product (String description, Date date, String title, String location, byte[] image, Status_Product status){
        super(description,date,title,location,image);
        this.status=status;
    }
    //No Image Constructor
    public Product (String description, Date date, String title, String location, Status_Product status){
        super(description,date,title,location);
        this.status=status;
    }
}
