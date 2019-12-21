package com.wellbrew.wellbrewapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=1)
    private String name;

    private int amount;

    @NotNull
    @Size(min=1)
    private String note;

    private int price;

    /*private boolean inStock;*/
    private String vendor;

    /*@ManyToMany(mappedBy = "products")
    private List<Orders> orders;*/
    /*private Set<Comment> comments = new LinkedHashSet<Comment>();*/

    @ManyToOne
    private Orders orders;


    public Product(String name, int amount, String note, int price, String vendor) {
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.price = price;
        /*this.inStock = inStock;*/
        this.vendor = vendor;
    }

    public Product() { }

    public int getId() {
        return id;
    }

    /*   public void setProductId(int productId) {
        this.productId = productId;
    }*/

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   /* public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }*/

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /*    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }*/

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
