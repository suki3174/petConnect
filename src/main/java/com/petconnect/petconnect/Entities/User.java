package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String username;
    private String email;
    private String password;
    private String profilePicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @ManyToMany
    @JoinTable(
            name = "user_non_professional_service",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "non_professional_service_id")
    )
    private List<NonProfessionalService> nonProfessionalServices = new ArrayList<>();

    //constructor with profilePicture
    public User(String username, String email, String password, String profilePicture){
        this.username=username;
        this.email=email;
        this.password=password;
        this.profilePicture=profilePicture;
    }

    //constructor without profile Picture (pfp set to a default picture)
    public User(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
        this.profilePicture="default_profile_picture_URL";//change later
    }
}
