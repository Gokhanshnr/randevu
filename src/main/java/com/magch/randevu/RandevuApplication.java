package com.magch.randevu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RandevuApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandevuApplication.class, args);
    }

}
