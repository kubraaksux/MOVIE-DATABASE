package com.example.cmpe321_hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeHttpRequests()
                .requestMatchers("/dbm/*").hasAuthority("dbm")
                .requestMatchers("/audience/*").hasAuthority("audience")
                .requestMatchers("/director/*").hasAuthority("director")
                .anyRequest().permitAll()
                .and()
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Autowired
    public void initialize(AuthenticationManagerBuilder builder, SqlService sqlService) throws Exception {
        System.out.println("Did things");
        builder.userDetailsService(sqlService);
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return new NoOpPasswordEncoder();
    }

    private static class NoOpPasswordEncoder implements PasswordEncoder {
        @Override
        public String encode(CharSequence rawPassword) {
            System.out.println("Encoded " + rawPassword);
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return rawPassword.equals(encodedPassword);
        }
    }
}