package com.example.servicecar.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced // La magie opère ici : permet d'utiliser http://SERVICE-CLIENT
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}