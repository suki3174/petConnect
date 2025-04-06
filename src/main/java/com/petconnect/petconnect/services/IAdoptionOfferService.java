package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Adoption_offer;
import com.petconnect.petconnect.Entities.Status_Adoption;

import java.util.List;
import java.util.Optional;

public interface IAdoptionOfferService {
    public Adoption_offer createAdoptionOffer(Adoption_offer offer);
    public List<Adoption_offer> getAllAdoptionOffers();
    public Optional<Adoption_offer> getOfferById(Long id);
    public void deleteAdoptionOffer(Long id);
    public List<Adoption_offer> findByStatus(Status_Adoption status);
    public List<Adoption_offer> findByBreed(String breed);
    public void markAsAdopted(Long id);
    public List<Adoption_offer> findAllAvailable();
}
