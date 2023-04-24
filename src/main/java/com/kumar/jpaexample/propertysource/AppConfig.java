package com.kumar.jpaexample.propertysource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@PropertySource("classpath:mail.properties")
//@PropertySource("classpath:message.properties")
@PropertySources(
        {
                @PropertySource("classpath:mail.properties"),
                @PropertySource("classpath:message.properties")
        }
)

public class AppConfig {
}
