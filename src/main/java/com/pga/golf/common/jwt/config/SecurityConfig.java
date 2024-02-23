package com.pga.golf.common.jwt.config;

import com.pga.golf.common.jwt.config.jwt.JwtAuthenticationFilter;
import com.pga.golf.common.jwt.config.jwt.JwtAuthorizationFilter;
import com.pga.golf.golfer.repository.GolferRepository;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {

    private final CorsConfig corsConfig;
    private final GolferRepository golferRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

//        return http
//                .csrf(CsrfConfigurer::disable)
//                .sessionManagement((configurer ->
//                        configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                )
////                .apply(new MyCustomDsl())
//                .authorizeHttpRequests(authorize -> authorize.("/api/**")
//                        .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                        .anyRequest("/api/admin/**")
//                        .access("hasRole('ROLE_ADMIN')")1
//                        .anyRequest().permitAll())
//
//                .build();

        return null;
    }

    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(corsConfig.corsFilter())
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, golferRepository));
        }
    }


    
}
