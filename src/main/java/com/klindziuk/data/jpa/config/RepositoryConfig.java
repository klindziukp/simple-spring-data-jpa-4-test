/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.klindziuk.data.jpa")
@EnableJpaRepositories("com.klindziuk.data.jpa")
@Import(OrmConfig.class)
public class RepositoryConfig {

}