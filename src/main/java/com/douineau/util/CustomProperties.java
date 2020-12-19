package com.douineau.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@ConfigurationProperties("jozinho")
public class CustomProperties {

    private String name = "NAME-TEST";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
