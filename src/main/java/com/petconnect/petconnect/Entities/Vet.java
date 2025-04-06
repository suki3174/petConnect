package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Vet extends User{


    private String address;
    private int phoneNumber;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    //with pfp
    public Vet(String username, String email, String password, String profilePicture, String address, int phoneNumber){
        super(username, email, password, profilePicture);
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    //without pfp
    public Vet(String username, String email, String password, String address, int phoneNumber){
        super(username, email, password);
        this.address=address;
        this.phoneNumber=phoneNumber;
    }
}
