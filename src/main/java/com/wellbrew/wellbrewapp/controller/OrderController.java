package com.wellbrew.wellbrewapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("order")
public class OrderController {

    static ArrayList<String> orders = new ArrayList<>();

    //use when the lists need to be pass to views - ProductController for more
    /*static HashMap<String, String> orders = new HashMap<>();*/

    // request path: /order
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("orders", orders);
        model.addAttribute("title", "Orders");

        return "order/index";
    }

    // Request path: order/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddOrderForm(Model model) {


        model.addAttribute("title","Create Order");
        return"order/add";
    }

    //Request path: order/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddOrderForm(@RequestParam String orderName) {

        orders.add(orderName);

        // redirect to order/
        return "redirect:";
    }
}


