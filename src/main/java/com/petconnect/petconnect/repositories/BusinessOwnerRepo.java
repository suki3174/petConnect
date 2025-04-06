package com.petconnect.petconnect.repositories;


import com.petconnect.petconnect.Entities.BusinessOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessOwnerRepo extends JpaRepository<BusinessOwner,Long> {
}
