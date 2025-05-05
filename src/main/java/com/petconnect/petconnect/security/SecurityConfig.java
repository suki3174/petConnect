package com.petconnect.petconnect.security;

import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.petconnect.petconnect.services.UserService;

import org.springframework.security.config.Customizer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;


@Configuration
@EnableWebSecurity
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SecurityConfig {

    @Value("${security.jwt.secret-key}")
    private String jwtSecretKey;
    
    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ) throws Exception{
        return httpSecurity
               
                .csrf(csrf -> csrf.disable())
                .cors((cors) -> cors
                .configurationSource(corsConfigurationSource())
                )

                .authorizeHttpRequests(auth -> auth

                                .requestMatchers("/api/**").permitAll() // Allow public access to login/register
                                .anyRequest().authenticated() // Restrict other endpoints
                )
                .oauth2ResourceServer(oath2 -> oath2.jwt(Customizer.withDefaults()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Use JWT for authentication
                
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder(){
     var secretKey = new SecretKeySpec(jwtSecretKey.getBytes(),"");
     return NimbusJwtDecoder.withSecretKey(secretKey)
     .macAlgorithm(MacAlgorithm.HS256).build();
    }

     @Bean 
     public AuthenticationManager authenticationManager(UserService userService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return new ProviderManager(provider);
     }

      @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE","PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
