package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Orders;
import com.wellbrew.wellbrewapp.model.data.OrderDao;
import com.wellbrew.wellbrewapp.model.data.ProductDao;
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

        return "OrderMain/index";
    }

    // Request path: /order/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("title","Add Order");
        model.addAttribute(new Orders());
        return"OrderMain/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Orders newOrders, Errors errors, Model model) {

        // validating errors
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Order");
            return"OrderMain/add";

        }

        orderDao.save(new Orders());
        return "redirect:";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", orderDao.findAll());
        model.addAttribute("title","Remove Product");
        return "OrderMain/remove";
    }

    //Request path: order/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam int[] orderIds) {

        for (int orderId : orderIds) {
            orderDao.deleteById(orderId);
            return "OrderMain/remove";
        }

        return "redirect:";
    }

}


