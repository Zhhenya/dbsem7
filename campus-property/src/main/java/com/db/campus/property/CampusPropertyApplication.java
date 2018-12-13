package com.db.campus.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.db.campus.property.dao")
@EnableTransactionManagement
public class CampusPropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusPropertyApplication.class, args);
    }
}
