package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.LostAndFound;
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
    public LostAndFound createLostAndFoundPost(LostAndFound post) {
        return lostAndFoundRepository.save(post);
    }
    @Override
    public List<LostAndFound> getAllLostAndFoundPosts() {
        return lostAndFoundRepository.findAll();
    }

    @Override
    public Optional<LostAndFound> getPostById(Long id) {
        return lostAndFoundRepository.findById(id);
    }

    @Override
    public void deleteLostAndFoundPost(Long id) {
        lostAndFoundRepository.deleteById(id);
    }

    @Override
    public List<LostAndFound> findByStatus(Status_LostAndFound status) {
        return lostAndFoundRepository.findByStatus(status);
    }

    @Override
    public List<LostAndFound> findByLocation(String location) {
        return lostAndFoundRepository.findByLocation(location);
    }

    @Override
    public List<LostAndFound> findByPet_Name(String name) {
        return lostAndFoundRepository.findByPet_Name(name);
    }

    @Override
    public Optional<LostAndFound> findByPet_NameAndDate(String name, Date date) {
        return lostAndFoundRepository.findByPet_NameAndDate(name, date);
    }

    @Override
    public void markAsFound(Long id) {
        Optional<LostAndFound> optionalPost = lostAndFoundRepository.findById(id);
        if (optionalPost.isPresent()) {
            LostAndFound post = optionalPost.get();
            post.setStatus(Status_LostAndFound.found);
            lostAndFoundRepository.save(post);
        } else {
            throw new IllegalArgumentException("Post with ID " + id + " not found.");
        }
    }
    }
