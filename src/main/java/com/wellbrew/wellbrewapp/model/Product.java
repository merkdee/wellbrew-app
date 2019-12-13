package com.wellbrew.wellbrewapp.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private Set<Comment> comments = new LinkedHashSet<Comment>();

    public Product() {}

    public Product(String name, BigDecimal price, boolean inStock, Set<Comment> comments) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
