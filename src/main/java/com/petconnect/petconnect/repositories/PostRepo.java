package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByValidatedFalse();

}
