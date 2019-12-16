package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Order;
import com.wellbrew.wellbrewapp.model.data.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("order")
public class OrderController {

    /*static ArrayList<String> orders = new ArrayList<>();*/

    //use when the lists need to be pass to views - ProductController for more
    /*static HashMap<String, String> orders = new HashMap<>();*/

    @Autowired
    private OrderDao  orderDao;

    // request path: /order
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", orderDao.findAll());
        model.addAttribute("title", "Products");

        return "order/index";
    }

    // Request path: /product/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("title","Add Order");
        model.addAttribute(new Order());
        return"order/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Order newOrder, Errors errors, Model model) {

        // validating errors
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Order");
            return"order/add";

        }

        orderDao.save(new Order());
        return "redirect:";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", orderDao.findAll());
        model.addAttribute("title","Remove Product");
        return "order/remove";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam int[] orderIds) {

        for (int orderId : orderIds) {
            orderDao.deleteById(orderId);
        }

        return "redirect:";
    }

}


