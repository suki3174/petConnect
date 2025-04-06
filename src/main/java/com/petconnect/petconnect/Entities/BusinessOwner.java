package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class BusinessOwner extends User{

    private String firstname;
    private String lastname;
    private int phoneNumber;
    private String address;

    @ManyToMany
    @JoinTable(
            name = "business_owner_service",
            joinColumns = @JoinColumn(name = "business_owner_id"),
            inverseJoinColumns = @JoinColumn(name = "professional_service_id")
    )
    private List<ProfessionalService> services=new ArrayList<>();

    //with pfp
    public BusinessOwner(String username, String email, String password, String profilePicture, String firstname, String lastname, int phoneNumber, String address){
        super(username, email, password, profilePicture);
        this.firstname=firstname;
        this.lastname=lastname;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    //without pfp
    public BusinessOwner(String username, String email, String password, String firstname, String lastname, int phoneNumber, String address){
        super(username, email, password);
        this.firstname=firstname;
        this.lastname=lastname;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
}
