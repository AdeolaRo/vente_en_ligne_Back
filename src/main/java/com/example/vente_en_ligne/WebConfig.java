package com.example.vente_en_ligne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Applique les règles à tous les endpoints qui commencent par /api
                        .allowedOrigins("http://localhost:8080", "http://localhost:4200") // Origine autorisée (Angular par exemple)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
                        .allowedHeaders("*")  // Autorise tous les en-têtes
                        .allowCredentials(true);  // Autorise l'envoi des cookies
            }
        };

    }

}
