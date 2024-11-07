package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 禁用CSRF保护，方便测试
                .authorizeRequests()
                .requestMatchers("/auth/login", "/auth/register", "/file/upload").permitAll() // 允许所有人访问 /api/login
                .anyRequest().authenticated(); // 其他请求需要认证

        return http.build();
    }
}
