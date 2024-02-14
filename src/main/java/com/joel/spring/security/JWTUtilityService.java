package com.joel.spring.security;

import com.joel.spring.exceptions.NotFoundException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

public interface JWTUtilityService {
    public String generateJWT(String userId);
    public JWTClaimsSet parseJWT(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException, JOSEException;
    public String getId(String token) throws NotFoundException;
}
