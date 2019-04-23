package com.example.WhatTheTekBlog.config;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.auth0.net.AuthRequest;
import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                .antMatchers(HttpMethod.POST, "/users/createPost/**").hasAuthority("view:users")//.hasAuthority("view:users")
                .antMatchers(HttpMethod.POST, "/users/sign-up").hasAuthority("view:users")
                .antMatchers(HttpMethod.POST, "/users/updatePost/**").hasAuthority("view:users")
                .antMatchers(HttpMethod.GET, "/post/**").permitAll()
                .antMatchers(HttpMethod.GET, "/post/tags/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users/**").permitAll()
                .antMatchers(HttpMethod.GET, "/post").permitAll()
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
                .antMatchers(HttpMethod.POST, "/uploadFile").permitAll()
                .antMatchers(HttpMethod.POST, "/uploadMultipleFiles").permitAll()
                .antMatchers(HttpMethod.GET, "/downloadFile/**").permitAll()
                .anyRequest().authenticated();
    }

    public static String getAccessToken() {
        String token = "";
        AuthAPI auth = new AuthAPI("whatthetek.auth0.com", "v6OMhNmN0OO3aPQnC9VnEACBDX7COR0N", System.getenv("clientSecret"));
        AuthRequest request = auth.login("testinguser", "Whatthetek!", "Username-Password-Authentication")
                .setAudience("http://localhost:8080")
                .setScope("openid view:user view:users");
        try {
            System.out.println(request);
            TokenHolder holder = request.execute();
            token = holder.getAccessToken();
        } catch (Auth0Exception exception) {
            // api error
            exception.printStackTrace();
        }// request error
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlFUUXdNRFk1TXpFek5qazFOREUwTnpFNE5FSXpNREl6UlVZMU5UUTBOamRDTWpZNE5qQTBOdyJ9.eyJpc3MiOiJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVjYjhiNmYzZTkyN2RjMTAyZGQ5ODU1ZiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL3doYXR0aGV0ZWsuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTU1NjA0ODE4NSwiZXhwIjoxNTU2MTM0NTg1LCJhenAiOiJ2Nk9NaE5tTjBPTzNhUFFuQzlWbkVBQ0JEWDdDT1IwTiIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgYWRkcmVzcyBwaG9uZSB2aWV3OnVzZXJzIHZpZXc6dXNlciIsImd0eSI6InBhc3N3b3JkIn0.fnNtCZjiY3luuwVpd_4G1LY_FszOKDdF7tRjsbzRbsuvH9AOx_WFRGOKKkWsKREkvzfzUZ1EzgkZ3xr6JbrVyErc9BQg955BcjFW9W6DuZyF0Cbh1vScQRdiNMuZTw-rkb_uDYzP7aLpB0PZ7FUgVoII73FI4HhVYMtUi3NmKV4AuzMHSurXtdFmBf5s97PN6vIoqRg_Rd2EaAd8MZhCP9oIWq_B_RIbSVhS7UYXWO_DA2AQ8aXNuhd-C3GS9XHrmc4d-1apIMWNC_hUi3MkuVqaPfL_PnNGfoNL1DArJyw_Twsvf7OGuxYwxa4E-tymSRFRTSwC-KBKuZqsjNVoBA";
    }

}
