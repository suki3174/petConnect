package com.petconnect.petconnect.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petconnect.petconnect.Entities.User;
import com.petconnect.petconnect.repositories.UserRepo;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private  UserRepo repository;

    
    private  PasswordEncoder passwordEncoder;

    
        
   

    public User saveUser(User user) {
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        return repository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(repository.findByUsername(username));
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPwd())
                // .email(user.getEmail())
                // .profilePicture(user.getProfilePicture())
                .build();
    }

    
    

   
     
  
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPwd(encodedPassword);
         
        repository.save(user);
    }
}
