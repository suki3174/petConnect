package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet,Long> {
}
