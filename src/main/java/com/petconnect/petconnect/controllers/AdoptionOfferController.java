package com.petconnect.petconnect.controllers;

import com.petconnect.petconnect.Entities.AdoptionOffer;
import com.petconnect.petconnect.Entities.Status_Adoption;
import com.petconnect.petconnect.services.IAdoptionOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoption-offers")
public class AdoptionOfferController {

    @Autowired
    private IAdoptionOfferService adoptionOfferService;

    @PostMapping
    public AdoptionOffer createOffer(@RequestBody AdoptionOffer offer) {
        return adoptionOfferService.createAdoptionOffer(offer);
    }

    @GetMapping
    public List<AdoptionOffer> getAllOffers() {
        return adoptionOfferService.getAllAdoptionOffers();
    }

    @GetMapping("/{id}")
    public Optional<AdoptionOffer> getOfferById(@PathVariable Long id) {
        return adoptionOfferService.getOfferById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        adoptionOfferService.deleteAdoptionOffer(id);
    }

    @GetMapping("/status/{status}")
    public List<AdoptionOffer> getOffersByStatus(@PathVariable Status_Adoption status) {
        return adoptionOfferService.findByStatus(status);
    }

    @GetMapping("/breed/{breed}")
    public List<AdoptionOffer> getOffersByBreed(@PathVariable String breed) {
        return adoptionOfferService.findByBreed(breed);
    }

    @PutMapping("/{id}/adopt")
    public void markAsAdopted(@PathVariable Long id) {
        adoptionOfferService.markAsAdopted(id);
    }

    @GetMapping("/available")
    public List<AdoptionOffer> getAllAvailableOffers() {
        return adoptionOfferService.findAllAvailable();
    }
}
