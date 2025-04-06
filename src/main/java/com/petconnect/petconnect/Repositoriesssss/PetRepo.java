package com.petconnect.petconnect.Repositoriesssss;

import com.petconnect.petconnect.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet,Long> {
}
