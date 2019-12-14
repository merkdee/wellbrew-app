package com.wellbrew.wellbrewapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("order")
public class OrderController {

    // request path: /order
    @RequestMapping(value = "")
    public String index(Model model) {

        ArrayList<String> orders = new ArrayList<>();
        orders.add("August 2019");
        orders.add("September 2019");
        orders.add("October 2019");

        model.addAttribute("orders", orders);
        model.addAttribute("title", "Orders");

        return "order/index";
    }

    @RequestMapping(value = "add")
    public String displayAddOrderForm(Model model) {
        model.addAttribute("title","Create Order");
        return"order/add";
    }
}


