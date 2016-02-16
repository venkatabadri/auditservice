package com.trinet.audit;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot Application for Audit Trail
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan("com.trinet.audit")
@EnableAutoConfiguration
public class TrinetAuditApplication {

    private static Logger LOGGER = Logger.getLogger(TrinetAuditApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrinetAuditApplication.class, args);

        LOGGER.info("Welcome to Spring boot for AuditService..");
    }

}
