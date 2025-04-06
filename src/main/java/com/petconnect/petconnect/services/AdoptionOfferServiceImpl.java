package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Adoption_offer;
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
    public Adoption_offer createAdoptionOffer(Adoption_offer offer) {
        return adoptionOfferRepo.save(offer);
    }

    @Override
    public List<Adoption_offer> getAllAdoptionOffers() {
        return adoptionOfferRepo.findAll();
    }

    @Override
    public Optional<Adoption_offer> getOfferById(Long id) {
        return adoptionOfferRepo.findById(id);
    }

    @Override
    public void deleteAdoptionOffer(Long id) {
        adoptionOfferRepo.deleteById(id);
    }

    @Override
    public List<Adoption_offer> findByStatus(Status_Adoption status) {
        return adoptionOfferRepo.findByStatus(status);
    }

    @Override
    public List<Adoption_offer> findByBreed(String breed) {
        return adoptionOfferRepo.findByPet_Breed(breed);
    }

    @Override
    public void markAsAdopted(Long id) {
        Optional<Adoption_offer> optionalOffer = adoptionOfferRepo.findById(id);
        if (optionalOffer.isPresent()) {
            Adoption_offer offer = optionalOffer.get();
            offer.setStatus(Status_Adoption.adopted);
            adoptionOfferRepo.save(offer);
        } else {
            throw new IllegalArgumentException("Adoption offer with ID " + id + " not found.");
        }
    }

    @Override
    public List<Adoption_offer> findAllAvailable() {
        return adoptionOfferRepo.findAllByStatus(Status_Adoption.waiting);
    }
}
