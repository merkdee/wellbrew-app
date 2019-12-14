package com.wellbrew.wellbrewapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("product")
public class ProductController {

    // request path: /product
    @RequestMapping(value = "")
    public String index(Model model) {

        ArrayList<String> products = new ArrayList<>();
        products.add("tea");
        products.add("bear");
        products.add("soda");

        model.addAttribute("products", products);
        model.addAttribute("title", "Products");

        return "product/index";
    }

    @RequestMapping(value = "add")
    public String displayAddProductForm(Model model) {
        model.addAttribute("title","Add New Product");
        return"product/add";
    }
}
