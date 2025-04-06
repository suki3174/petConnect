package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
}
