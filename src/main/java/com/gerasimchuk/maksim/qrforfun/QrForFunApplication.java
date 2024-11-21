package com.gerasimchuk.maksim.qrforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QrForFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrForFunApplication.class, args);
    }

}
