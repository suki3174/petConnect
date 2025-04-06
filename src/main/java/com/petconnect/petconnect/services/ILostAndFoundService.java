package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Lost_And_Found;
import com.petconnect.petconnect.Entities.Status_LostAndFound;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ILostAndFoundService {
    public Lost_And_Found createLostAndFoundPost(Lost_And_Found post);
    public List<Lost_And_Found> getAllLostAndFoundPosts();
    public Optional<Lost_And_Found> getPostById(Long id);
    public void deleteLostAndFoundPost(Long id);
    List<Lost_And_Found> findByStatus(Status_LostAndFound status);
    List<Lost_And_Found> findByLocation(String location);
    List<Lost_And_Found> findByPet_Name(String name);
    Optional<Lost_And_Found> findByPet_NameAndDate(String name, Date date);
    public void markAsFound(Long id);
}
