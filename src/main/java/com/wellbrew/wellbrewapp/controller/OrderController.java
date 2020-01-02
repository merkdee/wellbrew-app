package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Customer;
import com.wellbrew.wellbrewapp.model.Orders;
import com.wellbrew.wellbrewapp.model.Product;
import com.wellbrew.wellbrewapp.model.data.CustomerDao;
import com.wellbrew.wellbrewapp.model.data.OrderDao;
import com.wellbrew.wellbrewapp.model.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {

    /*static ArrayList<String> orders = new ArrayList<>();*/

    //use when the lists need to be pass to views - ProductController for more
    /*static HashMap<String, String> orders = new HashMap<>();*/

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerDao customerDao;


    // request path: /order
    @RequestMapping(value = "index")
    public String index(Model model) {

        model.addAttribute("orders", orderDao.findAll());
        model.addAttribute("title", "Order Lists");

        return "OrderMain/index";
    }

    // Request path: /order/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title","Create Order");
        model.addAttribute(new Orders());

        return"OrderMain/add";
    }

    // Request path: /order/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Orders orders, Product product, Errors errors, Model model) {

        /*model.addAttribute("products", productDao.findAll());*/
        model.addAttribute(product);
        productDao.findAll();

        model.addAttribute(orders);

        // validating errors
        if (errors.hasErrors()) {
            return"OrderMain/add";

        }
        productDao.findAll();
        orderDao.save(orders);
        model.addAttribute(new Orders());

        return "OrderMain/add";
    }

    //Request path: /order/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {

        model.addAttribute("products", orderDao.findAll());
        model.addAttribute("title","Remove Order");

        return "OrderMain/remove";
    }

    //Request path: order/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@ModelAttribute @RequestParam int id, Model model) {

        orderDao.findAll();
        orderDao.deleteById(id);
        model.addAttribute("orders", orderDao.findAll());

        return "OrderMain/remove";
    }

}


