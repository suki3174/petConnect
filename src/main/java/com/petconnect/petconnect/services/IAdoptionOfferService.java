package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.AdoptionOffer;
import com.petconnect.petconnect.Entities.Status_Adoption;

import java.util.List;
import java.util.Optional;

public interface IAdoptionOfferService {
    public AdoptionOffer createAdoptionOffer(AdoptionOffer offer);
    public List<AdoptionOffer> getAllAdoptionOffers();
    public Optional<AdoptionOffer> getOfferById(Long id);
    public void deleteAdoptionOffer(Long id);
    public List<AdoptionOffer> findByStatus(Status_Adoption status);
    public List<AdoptionOffer> findByBreed(String breed);
    public void markAsAdopted(Long id);
    public List<AdoptionOffer> findAllAvailable();
}
