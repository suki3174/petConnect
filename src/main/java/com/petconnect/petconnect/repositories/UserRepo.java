package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);

}
