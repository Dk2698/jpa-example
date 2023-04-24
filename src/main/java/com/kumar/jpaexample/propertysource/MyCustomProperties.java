package com.kumar.jpaexample.propertysource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.app")
public class MyCustomProperties {
    // if you need a default value, assign it here or the
   // constructor
    private String header;
    private String footer;
    // getters and setters
}