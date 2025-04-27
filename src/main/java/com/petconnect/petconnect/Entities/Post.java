package com.petconnect.petconnect.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String description;
    private Date date;
    private String title;
    private boolean validated;
    private String location;
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(String description, Date date, String title,String location, byte[] image){
        this.description=description;
        this.date=date;
        this.title=title;
        this.location=location;
        this.image=image;
        this.validated=false;
    }
    //No Image Constructor
    public Post(String description, Date date, String title,String location){
        this.description=description;
        this.date=date;
        this.title=title;
        this.location=location;
        this.validated=false;
    }
    //User Relation

}
