package com.example.WhatTheTekBlog.config;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.RequestBodyEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

import java.text.MessageFormat;

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
                .antMatchers(HttpMethod.POST, "/users/sign-up").hasAuthority("view:users")
                .antMatchers(HttpMethod.POST, "/users/createPost/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users/updatePost/**").hasAuthority("view:users")
                .antMatchers(HttpMethod.GET, "/post/**").permitAll()
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
                .anyRequest().authenticated();
    }

    public static String getAccessToken() {
        String token = "";
        HttpResponse<String> response = null;
        try {
//            response =
//                    Unirest.post("https://whatthetek.auth0.com/usernamepassword/login")
//                            .header("accept", "application/json")
//                            .header("Content-Type", "application/json")
//                            .body(new JSONObject() //Using this because the field functions couldn't get translated to an acceptable json
//                                    .put("userId", "testinguser")
//                                    .put("password", "Whatthetek!")
//                                    .toString())
//                            .asJson()
//                            .getBody();
//            System.out.println(response);
            response = Unirest.post("https://whatthetek.auth0.com/oauth/token")
                    .header("content-type", "application/json")
                    .body("{\"client_id\":\"v6OMhNmN0OO3aPQnC9VnEACBDX7COR0N\",\"client_secret\":\"VuhJwgSBFvCnrejevtGQleKDcxFNTwjqgsypcqCJ4RNj5-kCWfB7yvQu2vXQ4wbV\",\"audience\":\"http://localhost:8080\",\"grant_type\":\"client_credentials\"}")
                    .asString();
            System.out.println(response.getBody());
            token = new JSONObject(response.getBody()).getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return token;
    }

}
