package com.wellbrew.wellbrewapp.model;

import java.math.BigDecimal;

public class OrderLine {

    private Product product;
    private int amount;
    private BigDecimal purchasePrice;

    public OrderLine() {}

    public OrderLine(Product product, int amount, BigDecimal purchasePrice) {
        this.product = product;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
