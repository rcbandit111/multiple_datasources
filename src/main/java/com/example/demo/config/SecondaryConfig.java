
package com.example.demo.config;

import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.secondary.repo",
        entityManagerFactoryRef = "secondaryEmf",
        transactionManagerRef = "secondaryTx")
public class SecondaryConfig {

    public static final String TRANSACTION_MANAGER_NAME = "secondTransactionManager";

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource ds2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEmf(EntityManagerFactoryBuilder b) {
        return b.dataSource(ds2()).packages("com.example.demo.secondary.entity").build();
    }

    @Bean
    public JpaTransactionManager secondaryTx(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
