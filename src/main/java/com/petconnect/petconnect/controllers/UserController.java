package com.petconnect.petconnect.controllers;

import java.time.Instant;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.petconnect.petconnect.Entities.User;
import com.petconnect.petconnect.repositories.UserRepo;

@RestController
@RequestMapping("")
public class UserController {
@Value("${security.jwt.secret-key}")
    private String jwtSecretKey;

    @Value("${security.jwt.issuer}")
    private String jwtissuer;

    @Autowired
    private UserRepo userRepo;

   

    @Autowired
    private AuthenticationManager authenticationManager;

    record newPwdrequest(
            String currentPwd,
            String newPwd) {
    }

    @PostMapping("profile/password")
    public ResponseEntity<Object> changePwd(@RequestBody newPwdrequest request, Authentication auth) {
        var user = userRepo.findByEmail(auth.getName());
        var bCryptencoder = new BCryptPasswordEncoder();
        if (bCryptencoder.matches(request.currentPwd(), user.getPwd())) {
            String newPWd = bCryptencoder.encode(request.newPwd());
            user.setPwd(newPWd);
            userRepo.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body("mot de passe incorrect");
        }

    }

    record newUsernameRequest(
            String currentPwd,
            String newUsername) {
    }

    @PostMapping("profile/username")
    public ResponseEntity<Object> changeUsername(@RequestBody newUsernameRequest request, Authentication auth) {
        var user = userRepo.findByEmail(auth.getName());
        var bCryptencoder = new BCryptPasswordEncoder();
        if (bCryptencoder.matches(request.currentPwd(), user.getPwd())) {
            user.setUsername(request.newUsername());
            userRepo.save(user);

            return ResponseEntity.ok(user);

        } else {
            return ResponseEntity.badRequest().body("mot de passe incorrect");

        }

    }

    @GetMapping("profile/user")
    public User getUser(Authentication auth) {
        return userRepo.findByEmail(auth.getName());
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<Object> register(@RequestBody User newUser) {
        var bCryptencoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPwd(bCryptencoder.encode(newUser.getPwd()));

        try {
            var otherUser = userRepo.findByUsername(newUser.getUsername());
            if (otherUser != null) {
                return ResponseEntity.badRequest().body("nom d'utilisateur déjà utilisé ");
            }
            otherUser = userRepo.findByEmail(newUser.getEmail());
            if (otherUser != null) {
                return ResponseEntity.badRequest().body("Adresse email déjà utilisée");
            }
            userRepo.save(user);

            String jwtToken = createJwtToken(user);

            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("user", user);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println("exeption");
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().body("error");
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<Object> login(@RequestBody User userLogin) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLogin.getUsername(),
                            userLogin.getPwd()));

            User user = userRepo.findByUsername(userLogin.getUsername());
            String jwtToken = createJwtToken(user);
            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("user", user);

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println("exeption: ");
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().body("wrong username or password");
    }

    private String createJwtToken(User user) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtissuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(24 * 3600))
                .subject(user.getEmail())
                .build();
        var encoder = new NimbusJwtEncoder(
                new ImmutableSecret<>(jwtSecretKey.getBytes()));
        var params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return encoder.encode(params).getTokenValue();
    }

   


}
