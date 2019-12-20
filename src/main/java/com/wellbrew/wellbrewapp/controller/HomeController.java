package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Customer;
import com.wellbrew.wellbrewapp.model.Product;
import com.wellbrew.wellbrewapp.model.Orders;
import com.wellbrew.wellbrewapp.model.data.CustomerDao;
import com.wellbrew.wellbrewapp.model.data.OrderDao;
import com.wellbrew.wellbrewapp.model.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired

    CustomerDao customerDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    OrderDao orderDao;

    //Request path: /
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("orders", orderDao.findAll());
        model.addAttribute("title", "Products");

        return "HomeMain/index";
    }

    // Request path: /register
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayUserRegisterForm(Model model) {

        model.addAttribute("title", "Register");
        model.addAttribute(new Customer());
        return "HomeMain/register";
    }

    // Request path: /register
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processUserRegisterForm(@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model) {

        // validating errors for user registration
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "HomeMain/register";

        }

        customerDao.save(new Customer());
        return "ProductMain/index";
    }

    // Request path: /login
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayUserSignInForm (Model model){

        model.addAttribute("title", "Log In");
        model.addAttribute(new Customer());
        return "HomeMain/login";
    }

    // Request path: /login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processUserSignInForm (@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model){

        // validating errors for user login
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "HomeMain/login";

        }

        return "ProductMain/index";
    }

    //Request path: /search
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processUserSearchForm(@ModelAttribute Product product, Orders orders, Errors errors, Model model) {

        //validating errors for search
        if (errors.hasErrors()) {
            model.addAttribute("title", "Search Results");
            return "HomeMain/index";

        }
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("orders", orderDao.findAll());
        return "HomeMain/search";
    }
}
