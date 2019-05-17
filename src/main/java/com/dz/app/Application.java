package com.dz.app;

import com.dz.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@SpringBootApplication
@ComponentScan(basePackages = "com.dz")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
