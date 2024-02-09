package com.joel.spring.services.impl;

import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.user.application.usecases.JWTUtilityService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;

@Service
public class JWTUtilityServiceImpl implements JWTUtilityService {

    @Value("classpath:jwtKeys/private_key.pem") private Resource privateKeyResource;
    @Value("classpath:jwtKeys/public_key.pem") private Resource publicKeyResource;

    //throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException
    @Override
    public String generateJWT(String userId) {

        PrivateKey privateKey = this.loadPrivateKey(privateKeyResource);

        JWSSigner signer = new RSASSASigner(privateKey);

        Date now = new Date();
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(userId)
                .issueTime(now)
                .expirationTime(new Date(now.getTime() + 14400000))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
        signedJWT.sign(signer);
        return signedJWT.serialize();
    }

    @Override
    public JWTClaimsSet parseJWT(String jwt) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException, JOSEException {
        PublicKey publicKey = loadPublicKey(publicKeyResource);
        SignedJWT signedJWT = SignedJWT.parse(jwt);
        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);

        if (!signedJWT.verify(verifier)) {
            throw new JOSEException("Invalid signature");
        }

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

        if (claimsSet.getExpirationTime().before(new Date())) {
            throw new JOSEException("Expired token");
        }

        return claimsSet;
    }

    @Override
    public String getId(String token) throws NotFoundException {
        try {
            JWTClaimsSet claims = this.parseJWT(token);
            return claims.getSubject();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | ParseException | JOSEException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

// throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    private PrivateKey loadPrivateKey(Resource resource) {
        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get(resource.getURI()));
            String privateKeyPEM = this.formatPrivateKey(keyBytes);
            byte[] decodeKey = Base64.getDecoder().decode(privateKeyPEM);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodeKey));
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("TODO CUSTOM EXCEPTION");
        }

    }
    private PublicKey loadPublicKey(Resource resource) {

        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get(resource.getURI()));
            String publicKeyPEM = this.formatPublicKey(keyBytes);
            byte[] decodeKey = Base64.getDecoder().decode(publicKeyPEM);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodeKey));
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }


    private String formatPrivateKey(byte[] keyBytes) {
        return new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
    }

    private String formatPublicKey(byte[] keyBytes) {
        return new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
    }
}
