package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.AdoptionOffer;
import com.petconnect.petconnect.Entities.Status_Adoption;
import com.petconnect.petconnect.repositories.Adoption_offerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionOfferServiceImpl implements  IAdoptionOfferService{
    @Autowired
    private Adoption_offerRepo adoptionOfferRepo;

    @Override
    public AdoptionOffer createAdoptionOffer(AdoptionOffer offer) {
        return adoptionOfferRepo.save(offer);
    }

    @Override
    public List<AdoptionOffer> getAllAdoptionOffers() {
        return adoptionOfferRepo.findAll();
    }

    @Override
    public Optional<AdoptionOffer> getOfferById(Long id) {
        return adoptionOfferRepo.findById(id);
    }

    @Override
    public void deleteAdoptionOffer(Long id) {
        adoptionOfferRepo.deleteById(id);
    }

    @Override
    public List<AdoptionOffer> findByStatus(Status_Adoption status) {
        return adoptionOfferRepo.findByStatus(status);
    }

    @Override
    public List<AdoptionOffer> findByBreed(String breed) {
        return adoptionOfferRepo.findByPet_Breed(breed);
    }

    @Override
    public void markAsAdopted(Long id) {
        Optional<AdoptionOffer> optionalOffer = adoptionOfferRepo.findById(id);
        if (optionalOffer.isPresent()) {
            AdoptionOffer offer = optionalOffer.get();
            offer.setStatus(Status_Adoption.adopted);
            adoptionOfferRepo.save(offer);
        } else {
            throw new IllegalArgumentException("Adoption offer with ID " + id + " not found.");
        }
    }

    @Override
    public List<AdoptionOffer> findAllAvailable() {
        return adoptionOfferRepo.findAllByStatus(Status_Adoption.waiting);
    }
}
