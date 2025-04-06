package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepo extends JpaRepository<Vet, Long> {
}
