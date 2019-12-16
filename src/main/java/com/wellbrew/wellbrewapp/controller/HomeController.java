package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Customer;
import com.wellbrew.wellbrewapp.model.CustomerData;
import com.wellbrew.wellbrewapp.model.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    //Request path: /
    @RequestMapping(value = "")
    public String index(Model model) {

        /*model.addAttribute("products", ProductData.getAll());*/
        model.addAttribute("title", "Products");

        return "home/index";
    }

    // Request path: /register
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayUserRegisterForm(Model model) {

        model.addAttribute("title", "Register");
        model.addAttribute(new Customer());
        return "home/register";
    }

    // Request path: /register
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processUserRegisterForm(@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model) {

        // validating errors for user registration
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "home/register";

        }

        CustomerData.add(newCustomer);
        return "product/index";
    }

    // Request path: /login
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayUserSignInForm (Model model){

        model.addAttribute("title", "Log In");
        model.addAttribute(new Customer());
        return "home/login";
    }

    // Request path: /login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processUserSignInForm (@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model){

        // validating errors for user login
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "home/login";

        }

        return "product/index";
    }
}
