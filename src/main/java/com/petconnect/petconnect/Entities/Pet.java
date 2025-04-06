package com.petconnect.petconnect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Pet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private int age;
    private String sex;
    private String name;
    private String breed;
    private String description;
    public Pet(int age,String sex, String name, String breed, String description){
        this.age=age;
        this.sex=sex;
        this.name=name;
        this.breed=breed;
        this.description=description;
    }
}
