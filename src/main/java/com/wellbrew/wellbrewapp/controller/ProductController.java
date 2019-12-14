package com.wellbrew.wellbrewapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("product")
public class ProductController {

    //arraylist used to pass information (ex. product.add)
    /*static ArrayList<String> products = new ArrayList<>();*/

    //hashmap used to store information (ex.product.put)
    static HashMap<String, String> products = new HashMap<>();

    // request path: product/
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", products);
        model.addAttribute("title", "Products");

        return "product/index";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("title","Add Product");
        return"product/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@RequestParam String productName, @RequestParam String productDesc){

        //previously added products listed within array WHEN INSIDE index function
        /*products.add(productName);*/

        //saving product
        products.put(productName, productDesc);

        //redirect to product/
        return "redirect:";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", products.keySet());
        model.addAttribute("title","Remove Product");
        return "product/remove";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam ArrayList<String> product) {

        for (String aProduct : product) {
            products.remove(aProduct);
        }

        return "redirect:";
    }

}
