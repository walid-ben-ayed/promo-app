package com.promo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.promo")
@EnableJpaRepositories(basePackages = "com.promo.infrastructure.repository")
@EntityScan(basePackages = "com.promo.infrastructure.entity")
public class PromoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PromoApplication.class, args);
    }
}
