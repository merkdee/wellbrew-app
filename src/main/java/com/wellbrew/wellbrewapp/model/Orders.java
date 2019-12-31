package com.wellbrew.wellbrewapp.model;

import com.wellbrew.wellbrewapp.model.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;


@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private Calendar date;

    @ManyToOne
    private Customer customer;

    @NotNull
    @Size(min=3,max=15)
    private String name;

    @OneToMany(mappedBy = "id")
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
