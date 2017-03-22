package com.demo.trucks.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by andrei.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * An address service mask to which is possible to make cross
     * domain request {@link WebConfiguration#allowedOrigins}
     */
    @Value("${server.cors.pathLevel}")
    private String pathLevel;

    /**
     * A name of a client domain
     */
    @Value("${server.cors.allowedOrigins}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurerAdapter() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(pathLevel).allowedOrigins(allowedOrigins);
            }
        };
    }
}
