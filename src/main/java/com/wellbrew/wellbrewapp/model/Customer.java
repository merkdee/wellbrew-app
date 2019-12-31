package com.wellbrew.wellbrewapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=3, max=12)
    private String username;

    @NotNull
    @Size(min=6,max=15, message = "password must be between 6 and 15 characters")
    private String password;

    @Transient
    @NotNull(message = "Passwords don't match.")
    private String verifyPassword;

    @OneToMany(mappedBy = "customer")
    private List<Orders> invoice = new ArrayList<>();

    public Customer(String username, String password, List<Orders> invoice) {
        this.username = username;
        this.password = password;
        this.invoice = invoice;
    }

    public Customer() { }

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
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public List<Orders> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Orders> invoice) {
        this.invoice = invoice;
    }

    private void checkPassword() {
        if(password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    /*@OneToMany(mappedBy = "customer")
    private Collection<Orders> orders;

    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }*/
}

