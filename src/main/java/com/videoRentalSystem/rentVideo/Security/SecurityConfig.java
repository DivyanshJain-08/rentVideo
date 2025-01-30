package com.videoRentalSystem.rentVideo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean
    public BCryptPasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/register").permitAll() // Public Endpoint
                .requestMatchers("/api/videos").authenticated()  // Any authenticated user
                .requestMatchers("/api/videos/**").hasRole("ADMIN") // Only Admin
                .anyRequest().authenticated()
            )
            .httpBasic(); // Enables Basic Authentication

        return http.build();
    }
}
