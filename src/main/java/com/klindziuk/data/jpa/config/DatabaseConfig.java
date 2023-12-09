/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

  @Value("${com.klindziuk.data.jpa.jdbc.url}")      private String jdbcUrl;
  @Value("${com.klindziuk.data.jpa.jdbc.user}")     private String user;
  @Value("${com.klindziuk.data.jpa.jdbc.password}") private String password;
  @Value("${com.klindziuk.data.jpa.packages}")      private String packages;

}
