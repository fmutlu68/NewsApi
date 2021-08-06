package com.fm.newsProject.core.utilities.security.jwt;

import com.fm.newsProject.core.utilities.security.jwt.abstracts.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private TokenManager tokenManager;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public JwtTokenFilter(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.contains("Bearer")){
            token = authHeader.substring(7);
            try{
                username = tokenManager.getUserFromToken(token);
            }catch (Exception error){
                System.out.println(error.getMessage());
            }
        }
        if (token != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            if (tokenManager.tokenValidate(token)){
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
