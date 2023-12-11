/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import(DatabaseConfig.class)
public class OrmConfig {

  /**
   * Returns DataSource
   *
   * @return DataSource
   */
  @Bean("dataSource")
  DataSource dataSource(DatabaseConfig databaseConfig) {
    HikariConfig dataSourceProperties = new HikariConfig();
    dataSourceProperties.setJdbcUrl(databaseConfig.getJdbcUrl());
    dataSourceProperties.setUsername(databaseConfig.getUser());
    dataSourceProperties.setPassword(databaseConfig.getPassword());
    return new HikariDataSource(dataSourceProperties);
  }

  /**
   * Returns LocalContainerEntityManagerFactoryBean
   *
   * @param dataSource     java sql DataSource
   * @param databaseConfig database config
   * @return LocalContainerEntityManagerFactoryBean
   */
  @Bean("entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
      DatabaseConfig databaseConfig) {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setDatabase(Database.POSTGRESQL);
    vendorAdapter.setShowSql(true);
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan(databaseConfig.getPackages());
    factory.setDataSource(dataSource);

    return factory;
  }

  /**
   * Returns JpaTransactionManager
   *
   * @param entityManagerFactory hibernate EntityManagerFactory
   * @return JpaTransactionManager
   */
  @Bean("transactionManager")
  protected PlatformTransactionManager transactionManager(
      EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
