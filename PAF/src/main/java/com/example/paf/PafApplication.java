package com.example.paf;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PafApplication {

    public static void main(String[] args) {
        SpringApplication.run(PafApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return  new ModelMapper();
    }


}
