package com.db.campus.property.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ConversionConfiguration {

    @Bean
    ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean serviceFactoryBean = new ConversionServiceFactoryBean();
        serviceFactoryBean.setConverters(
                Stream.of(
                        new RequestConverter()
                         )
                      .collect(Collectors.toSet()));
        return serviceFactoryBean;
    }

}
