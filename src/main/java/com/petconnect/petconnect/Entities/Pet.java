package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
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
    @OneToOne(mappedBy = "pet")
    private LostAndFound lostAndFoundPost;

    @OneToOne(mappedBy = "pet")
    private AdoptionOffer adoptionOffer;
    public Pet(int age,String sex, String name, String breed, String description){
        this.age=age;
        this.sex=sex;
        this.name=name;
        this.breed=breed;
        this.description=description;
    }
}
