package com.dashboard.project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperCongif {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
