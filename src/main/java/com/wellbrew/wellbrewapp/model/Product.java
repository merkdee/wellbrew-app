package com.wellbrew.wellbrewapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Product {

    private int productId;
    private static int nextId = 1;

    @NotBlank
    private String name;

    private int amount;

    @NotBlank
    private String desc;

    private BigDecimal price;

    /*private boolean inStock;*/
    private String Vendor;
    /*private Set<Comment> comments = new LinkedHashSet<Comment>();*/


    public Product(String name, int amount, String desc, BigDecimal price, String vendor) {
        this();
        this.name = name;
        this.amount = amount;
        this.desc = desc;
        this.price = price;
        /*this.inStock = inStock;*/
        this.Vendor = vendor;
    }

    public Product() {
        productId = nextId;
        nextId++;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

   /* public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }*/

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

/*    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }*/
}
