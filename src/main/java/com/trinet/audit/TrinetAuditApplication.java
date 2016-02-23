package com.trinet.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot Application for Audit Service
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan("com.trinet.audit")
@EnableAutoConfiguration
public class TrinetAuditApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TrinetAuditApplication.class);
    
    private TrinetAuditApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(TrinetAuditApplication.class, args);
        LOGGER.info("Welcome to Spring boot for AuditService..");
    }

}
