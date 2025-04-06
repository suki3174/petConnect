package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Adoption_offer;
import com.petconnect.petconnect.Entities.Status_Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Adoption_offerRepo extends JpaRepository<Adoption_offer,Long> {
    List<Adoption_offer> findByStatus(Status_Adoption status);

    List<Adoption_offer> findByPet_Breed(String breed);

    List<Adoption_offer> findAllByStatus(Status_Adoption status);
}
