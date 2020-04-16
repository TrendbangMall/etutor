package com.etutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = "com.etutor")
public class EtutorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtutorServerApplication.class, args);
    }

}
