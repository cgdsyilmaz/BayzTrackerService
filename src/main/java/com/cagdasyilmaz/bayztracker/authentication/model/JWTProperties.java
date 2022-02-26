package com.cagdasyilmaz.bayztracker.authentication.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class JWTProperties {
    @Value("${bayztracker.jwt.secret}")
    private String secret;
    @Value("${bayztracker.jwt.expirationTime}")
    private long expirationTime;
}
