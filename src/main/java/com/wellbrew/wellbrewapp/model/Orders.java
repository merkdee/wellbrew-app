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

    @NotNull
    @Size(min = 1)
    private String username;

    @NotNull
    @Size(min=3,max=15)
    private String orderName;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Product> products = new ArrayList<>();
    /*private Set<Product> products = new LinkedHashSet<Product>();*/

    @ManyToOne
    private Customer customer;



    public Orders(String orderName) {
        this.orderName = orderName;

    }

    public Orders() {}


    /*public void setOrderId(int orderId) {
        this.orderId = orderId;
    }*/

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

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

    /*public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }*/

    /* public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }*/
}
