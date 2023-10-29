package com.example.springjdbctemplate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
    @Bean
    public JdbcTemplate JdbcTemplateConfiguration(@Qualifier("customDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
