package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Lost_And_Found;
import com.petconnect.petconnect.Entities.Status_LostAndFound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Lost_And_FoundRepo extends JpaRepository<Lost_And_Found,Long> {
    List<Lost_And_Found> findByStatus(Status_LostAndFound status);
    List<Lost_And_Found> findByLocation(String location);
    List<Lost_And_Found> findByPet_Name(String name);
    Optional<Lost_And_Found> findByPet_NameAndDate(String name, Date date);
}
