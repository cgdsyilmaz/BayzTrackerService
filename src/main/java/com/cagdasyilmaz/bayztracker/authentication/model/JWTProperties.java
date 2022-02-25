package com.cagdasyilmaz.bayztracker.authentication.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("bayztracker.jwt")
@Getter
@Setter
public class JWTProperties {
    private String secret;
    private long expirationTime;
}
