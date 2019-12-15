package com.wellbrew.wellbrewapp.model;

import java.util.ArrayList;

public class ProductData {

    static ArrayList<Product> products = new ArrayList<>();

    //getAll
    public static ArrayList<Product> getAll(){
        return products;
    }

    //add
    public static void add(Product newProduct) {
        products.add(newProduct);
    }


    //remove
    public static void remove(int id) {
        Product productToRemove = getById(id);
        products.remove(productToRemove);
    }

    //getById
    public static Product getById(int id){

        Product theProduct = null;

        for (Product selectedProduct : products) {
            if(selectedProduct.getProductId() == id) {
                theProduct = selectedProduct;
            }
        }

        return theProduct;
    }
}
