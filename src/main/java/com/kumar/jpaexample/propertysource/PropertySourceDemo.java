package com.kumar.jpaexample.propertysource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class PropertySourceDemo {
//    @Autowired
//    private Environment environment;

    @Value("${gmail.host}")
    private String host;
    @Value("${gmail.email}")
    private String email;

    @Value("${gmail.password}")
    private String password;

//    public  String getPassword(){
//        return environment.getProperty("gmail.password");
//    }
}
