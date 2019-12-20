package com.wellbrew.wellbrewapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    @Size(min=3, max=12)
    private String username;

    @NotBlank
    @Size(min=6,max=15, message = "password must be between 6 and 15 characters")
    private String password;

    @NotBlank
    private String verifyPassword;


    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer() { }

    public Long getId() {
        return Id;
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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}

