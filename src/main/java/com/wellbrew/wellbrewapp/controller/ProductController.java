package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Orders;
import com.wellbrew.wellbrewapp.model.Product;
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
import java.util.Collections;
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
    ProductDao  productDao;

    @Autowired
    OrderDao orderDao;

    // request path: /product
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "Products");

        return "product/index";
    }

    // Request path: /product/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddProductForm(Model model) {

        model.addAttribute("title","Add Product");
        model.addAttribute(new Product());
        model.addAttribute("orders", orderDao.findAll());
        return"product/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Product newProduct, Errors errors, @RequestParam(value = "id", required = false) int Id, Model model) {

        // validating errors
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Product");
            model.addAttribute("orders", orderDao.findAll());
            return"product/add";

        }

        Orders order = (Orders) orderDao.findAllById(Collections.singleton(Id));
        newProduct.setOrders(order);
        productDao.save(new Product());
        return "redirect:";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveProductForm(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title","Remove Product");
        return "product/remove";
    }

    //Request path: product/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveProductForm(@RequestParam int[] ids) {

        //remove since the order dao is now autowired into product list
        /*for (int productId : productIds) {
            productDao.deleteById(productId);
        }*/
        for (int id : ids) {
            productDao.deleteById(id);
        }

        return "redirect:";
    }

    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String order (Model model, @RequestParam int id) {

        Optional<Orders> orders;
        orders = orderDao.findById(id);
        List<Product> products = (List<Product>) orders.get();
        model.addAttribute("products", products);
        model.addAttribute("title", "Products are listed in Order: " + orders.get());
        return "product/index";
    }

}
