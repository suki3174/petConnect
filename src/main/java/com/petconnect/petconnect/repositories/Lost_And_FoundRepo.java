package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.LostAndFound;
import com.petconnect.petconnect.Entities.Status_LostAndFound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Lost_And_FoundRepo extends JpaRepository<LostAndFound,Long> {
    List<LostAndFound> findByStatus(Status_LostAndFound status);
    List<LostAndFound> findByLocation(String location);
    List<LostAndFound> findByPet_Name(String name);
    Optional<LostAndFound> findByPet_NameAndDate(String name, Date date);
}
