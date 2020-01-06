package com.wellbrew.wellbrewapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar date;

    @ManyToOne
    private Customer customer;

    @Size(min=3,max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products = new ArrayList<>();


    public Orders(String name, Calendar date, List<Product> products) {
        this.name = name;
        this.date = date;
        this.products = products;

    }

    public Orders() {}

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
