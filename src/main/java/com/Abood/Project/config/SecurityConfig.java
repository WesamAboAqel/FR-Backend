package com.Abood.Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and() // Enable CORS
            .csrf().disable() // Disable CSRF for APIs
            .authorizeHttpRequests(authorize -> 
                authorize
                    .requestMatchers("/api/**").permitAll() // Allow public access to /api/** endpoints
                    .anyRequest().authenticated() // Restrict all other endpoints
            );
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Allow cookies or authorization headers
        config.setAllowedOriginPatterns(List.of("http://localhost:4200")); // Use origin patterns
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allowed HTTP methods
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With")); // Allowed headers

        // Apply CORS configuration globally for all endpoints
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
