package fr.studies.interactive_dashboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("/http:localhost:5173")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
