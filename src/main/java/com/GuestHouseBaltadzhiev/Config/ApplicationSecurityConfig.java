package com.GuestHouseBaltadzhiev.Config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf ().disable ()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/assets/**", "/forms/**").permitAll()
                .antMatchers("/assets/css/**").permitAll()
                .antMatchers("/assets/img/**").permitAll()
                .antMatchers("/assets/js/**").permitAll()
                .antMatchers("/assets/vendor/**").permitAll()
                .anyRequest().permitAll ();

    }
}
