package com.example.WhatTheTekBlog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/post").permitAll()
                .antMatchers(HttpMethod.GET, "/post/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users/sign-up").hasAuthority("view:users")
                .antMatchers(HttpMethod.POST, "/users/createPost/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users/updatePost").hasAuthority("view:posts")
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/users/id/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users/posts/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users/comments/**").permitAll()
                .antMatchers(HttpMethod.GET, "/tags").permitAll()
                .antMatchers(HttpMethod.GET, "/tags/**").permitAll()
                .antMatchers(HttpMethod.GET, "/tags/posts/**").permitAll()
                .antMatchers(HttpMethod.POST, "/createTag/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/updateTag/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/deleteTags/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/comment/delete/**").permitAll()
                .antMatchers(HttpMethod.GET, "/comments/post/**").permitAll()
                .antMatchers(HttpMethod.GET, "/comments").permitAll()
                .antMatchers(HttpMethod.GET, "/comment/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/comment/update/**").permitAll()
                .antMatchers(HttpMethod.POST, "/comment/create/**").permitAll()
                .anyRequest().authenticated();
    }

}
