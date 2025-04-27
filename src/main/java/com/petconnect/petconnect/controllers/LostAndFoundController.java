package com.petconnect.petconnect.controllers;

import com.petconnect.petconnect.Entities.LostAndFound;
import com.petconnect.petconnect.Entities.Status_LostAndFound;
import com.petconnect.petconnect.services.ILostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lost-and-found")
public class LostAndFoundController {

    @Autowired
    private ILostAndFoundService lostAndFoundService;

    @PostMapping
    public LostAndFound createPost(@RequestBody LostAndFound post) {
        return lostAndFoundService.createLostAndFoundPost(post);
    }

    @GetMapping
    public List<LostAndFound> getAllPosts() {
        return lostAndFoundService.getAllLostAndFoundPosts();
    }

    @GetMapping("/{id}")
    public Optional<LostAndFound> getPostById(@PathVariable Long id) {
        return lostAndFoundService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        lostAndFoundService.deleteLostAndFoundPost(id);
    }

    @GetMapping("/status/{status}")
    public List<LostAndFound> getPostsByStatus(@PathVariable Status_LostAndFound status) {
        return lostAndFoundService.findByStatus(status);
    }

    @GetMapping("/location/{location}")
    public List<LostAndFound> getPostsByLocation(@PathVariable String location) {
        return lostAndFoundService.findByLocation(location);
    }

    @GetMapping("/pet-name/{name}")
    public List<LostAndFound> getPostsByPetName(@PathVariable String name) {
        return lostAndFoundService.findByPet_Name(name);
    }

    @GetMapping("/pet-name/{name}/date")
    public Optional<LostAndFound> getPostByPetNameAndDate(@PathVariable String name, @RequestParam Date date) {
        return lostAndFoundService.findByPet_NameAndDate(name, date);
    }

    @PutMapping("/{id}/found")
    public void markAsFound(@PathVariable Long id) {
        lostAndFoundService.markAsFound(id);
    }
}
