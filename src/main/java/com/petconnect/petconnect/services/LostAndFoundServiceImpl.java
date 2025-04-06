package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Lost_And_Found;
import com.petconnect.petconnect.Entities.Status_LostAndFound;
import com.petconnect.petconnect.repositories.Lost_And_FoundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LostAndFoundServiceImpl implements ILostAndFoundService{
    @Autowired
    private Lost_And_FoundRepo lostAndFoundRepository;
    @Override
    public Lost_And_Found createLostAndFoundPost(Lost_And_Found post) {
        return lostAndFoundRepository.save(post);
    }
    @Override
    public List<Lost_And_Found> getAllLostAndFoundPosts() {
        return lostAndFoundRepository.findAll();
    }

    @Override
    public Optional<Lost_And_Found> getPostById(Long id) {
        return lostAndFoundRepository.findById(id);
    }

    @Override
    public void deleteLostAndFoundPost(Long id) {
        lostAndFoundRepository.deleteById(id);
    }

    @Override
    public List<Lost_And_Found> findByStatus(Status_LostAndFound status) {
        return lostAndFoundRepository.findByStatus(status);
    }

    @Override
    public List<Lost_And_Found> findByLocation(String location) {
        return lostAndFoundRepository.findByLocation(location);
    }

    @Override
    public List<Lost_And_Found> findByPet_Name(String name) {
        return lostAndFoundRepository.findByPet_Name(name);
    }

    @Override
    public Optional<Lost_And_Found> findByPet_NameAndDate(String name, Date date) {
        return lostAndFoundRepository.findByPet_NameAndDate(name, date);
    }

    @Override
    public void markAsFound(Long id) {
        Optional<Lost_And_Found> optionalPost = lostAndFoundRepository.findById(id);
        if (optionalPost.isPresent()) {
            Lost_And_Found post = optionalPost.get();
            post.setStatus(Status_LostAndFound.found);
            lostAndFoundRepository.save(post);
        } else {
            throw new IllegalArgumentException("Post with ID " + id + " not found.");
        }
    }
    }
