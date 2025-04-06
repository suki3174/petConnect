package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {
}
