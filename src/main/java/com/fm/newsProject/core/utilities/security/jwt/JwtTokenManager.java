package com.fm.newsProject.core.utilities.security.jwt;

import com.fm.newsProject.core.entities.concretes.User;

import java.security.Key;
import java.util.Date;

import com.fm.newsProject.core.utilities.security.jwt.abstracts.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenManager implements TokenManager {
    private final int expiration = 10 * 60 * 1000;
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    @Override
    public AccessToken createToken(User user) {
        AccessToken token = new AccessToken();
        token.setToken(Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer("www.furkanm.io")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact());
        token.setExpiration(getClaims(token.getToken()).getExpiration());
        return token;
    }

    @Override
    public boolean tokenValidate(String token) {
        if (getUserFromToken(token) != null && isExpired(token)){
            return true;
        }
        return false;
    }

    @Override
    public String getUserFromToken(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key )
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isExpired(String token){
        var now = new Date(System.currentTimeMillis());
        if (getClaims(token).getExpiration().after(now)){
            return true;
        }
        return false;
    }
}
