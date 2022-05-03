package com.anchtun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.anchtun.beans", "com.anchtun.service", "com.anchtun.implementation" })
public class ProjectConfig {

}
