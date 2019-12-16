package com.wellbrew.wellbrewapp.model;

import com.wellbrew.wellbrewapp.model.Customer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
public class Order {

    @Id
    @GeneratedValue
    private int orderId;


    private Calendar date;


    private String username;

    @OneToMany
    private ArrayList<Product> products = new ArrayList<>();
    /*private Set<Product> products = new LinkedHashSet<Product>();*/

    public Order() {}

    public Order(Calendar date, String username, ArrayList products) {
        this.date = date;
        this.username = username;
        this.products = products;
        /*this.orderLines = orderLines;*/
    }


    public int getOrderId() {
        return orderId;
    }

    /*public void setOrderId(int orderId) {
        this.orderId = orderId;
    }*/

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /* public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }*/
}
