package com.wellbrew.wellbrewapp.controller;

import com.wellbrew.wellbrewapp.model.Product;
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

@Controller
@RequestMapping("product")
public class ProductController {

    //arraylist used to pass information (ex. product.add)
    /*static ArrayList<String> products = new ArrayList<>();*/

    //hashmap used to store information (ex.product.put)
   /* static HashMap<String, String> products = new HashMap<>();*/

    /*static ArrayList<Product> products = new ArrayList<>();*/

    @Autowired
    private ProductDao  productDao;

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
        return"product/add";
    }

    // Request path: product/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute @Valid Product newProduct, Errors errors, Model model) {

        // validating errors
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Product");
            return"product/add";

        }

        // wrapping data into java object to be stored
        // using functions from product data
        //eliminated due to using the model to create the data object
       /* Product newProduct = new Product(name,amount, desc, price, inStock, vendor);*/
        /*ProductData.add(newProduct);*/

        //previously added products listed within array WHEN INSIDE index function
        /*products.add(productName);*/

        //saving product
        /*products.put(productName, productDesc);*/

        //redirect to product/
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
    public String processRemoveProductForm(@RequestParam int[] productIds) {

        for (int productId : productIds) {
            productDao.deleteById(productId);
        }

        return "redirect:";
    }

}
