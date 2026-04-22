
package com.example.demo.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.primary.repo",
        entityManagerFactoryRef = "primaryEmf",
        transactionManagerRef = "primaryTx")
public class PrimaryConfig {

    public static final String TRANSACTION_MANAGER_NAME = "primaryTransactionManager";

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource ds() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEmf(EntityManagerFactoryBuilder b) {
        return b.dataSource(ds()).packages("com.example.demo.primary.entity").build();
    }

    @Bean
    @Primary
    public JpaTransactionManager primaryTx(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
