package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.LostAndFound;
import com.petconnect.petconnect.Entities.Status_LostAndFound;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ILostAndFoundService {
    public LostAndFound createLostAndFoundPost(LostAndFound post);
    public List<LostAndFound> getAllLostAndFoundPosts();
    public Optional<LostAndFound> getPostById(Long id);
    public void deleteLostAndFoundPost(Long id);
    List<LostAndFound> findByStatus(Status_LostAndFound status);
    List<LostAndFound> findByLocation(String location);
    List<LostAndFound> findByPet_Name(String name);
    Optional<LostAndFound> findByPet_NameAndDate(String name, Date date);
    public void markAsFound(Long id);
}
