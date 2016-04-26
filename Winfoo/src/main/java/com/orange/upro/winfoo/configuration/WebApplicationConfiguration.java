package com.orange.upro.winfoo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.orange")
@Import({ WebMvcConfiguration.class })
public class WebApplicationConfiguration {
}