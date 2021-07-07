package com.theocho.youflix.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Profile {


    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String emailAddress;
    @Column
    private ArrayList<Video> videos;

    public Profile() {
    }

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
        this.videos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
