package com.stage.biblioteca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("$datasource.name}")
    private String name;
    @Value("$datasource.url}")
    private String url;


}
