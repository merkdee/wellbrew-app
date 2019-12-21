package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Orders;
import com.wellbrew.wellbrewapp.model.Product;
import com.wellbrew.wellbrewapp.model.data.OrderDao;
import com.wellbrew.wellbrewapp.model.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {

    //arraylist used to pass information (ex. product.add)
    /*static ArrayList<String> products = new ArrayList<>();*/

    //hashmap used to store information (ex.product.put)
   /* static HashMap<String, String> products = new HashMap<>();*/

    /*static ArrayList<Product> products = new ArrayList<>();*/

    @Autowired
    ProductDao productDao;

    @Autowired
    OrderDao orderDao;

    // request path: /product
    @RequestMapping(value = "index")
    public String index(Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "BowerBird");

        return "ProductMain/index";
    }

    // Request path: /product/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("title","Add Product");
        model.addAttribute(new Product());

        return"ProductMain/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Product product,Errors errors, Model model) {

        model.addAttribute(product);

        // validating errors
        if (errors.hasErrors()) {
            return"ProductMain/add";

        }

        productDao.save(product);
        model.addAttribute(new Product());
        return "ProductMain/add";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {

        model.addAttribute("title","Remove Product");
        model.addAttribute("products", productDao.findAll());

        return "ProductMain/remove";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@ModelAttribute Model model, Product product, int id) {


        model.addAttribute("products", productDao.findAll());

        /*// validating errors
        if (errors.hasErrors()) {
            return"ProductMain/remove";

        }*/

        productDao.deleteById(id);

        return "ProductMain/index";
    }

    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String order (Model model, @RequestParam int id) {

        Optional<Orders> orders;
        orders = orderDao.findById(id);
        List<Product> products = (List<Product>) orders.get();
        model.addAttribute("products", products);
        model.addAttribute("title", "Products are listed in Order: " + orders.get());
        return "OrderMain/add";
    }

}
