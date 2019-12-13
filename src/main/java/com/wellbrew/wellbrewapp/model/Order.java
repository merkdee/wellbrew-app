package com.wellbrew.wellbrewapp.model;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

public class Order {

    private int id;


    private Calendar date;


    private Customer username;


    private Set<OrderLine> orderLines = new LinkedHashSet<OrderLine>();

    public Order() {}

    public Order(Calendar date, Customer username, Set<OrderLine> orderLines) {
        this.date = date;
        this.username = username;
        this.orderLines = orderLines;
    }

    public int getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Customer getUsername() {
        return username;
    }

    public void setUsername(Customer username) {
        this.username = username;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
