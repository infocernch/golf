package com.pga.golf.common.config;

import com.pga.golf.golfer.repository.GolferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {

    private final CorsFilter corsFilter;
    private final GolferRepository golferRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //접근권한 (인가) 설정
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.csrf(CsrfConfigurer::disable);
        return http.build();


    }

}
