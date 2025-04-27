package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.AdoptionOffer;
import com.petconnect.petconnect.Entities.Status_Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Adoption_offerRepo extends JpaRepository<AdoptionOffer,Long> {
    List<AdoptionOffer> findByStatus(Status_Adoption status);

    List<AdoptionOffer> findByPet_Breed(String breed);

    List<AdoptionOffer> findAllByStatus(Status_Adoption status);
}
