package com.example.controllers;

import com.example.models.Product;
import com.example.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductDAO productRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product-list";
    }

    @GetMapping("/products/view/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).get());
        return "product-view";
    }

    @GetMapping("/products/form")
    public String getEmptyForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @GetMapping("/products/edit/{id}")
    public String getFormWithProduct(@PathVariable Long id, Model model) {

        if (productRepository.existsById(id)) {
            productRepository.findById(id).ifPresent(p -> {
                model.addAttribute("product", p);
            });
            return "product-form";
        } else {
            return "redirect:/products/form";
        }
    }

    @PostMapping("/products")
    public String create(@ModelAttribute Product product) {

        if (product.getId() != null) {

            //Actualizacion
            productRepository.findById(product.getId()).ifPresent(p -> {
                p.setName(product.getName());
                p.setMark(product.getMark());
                p.setQuantity(product.getQuantity());
                p.setPrice(product.getPrice());
                productRepository.save(p);
            });
        } else {
            //Creacion
            productRepository.save(product);
        }
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        if(productRepository.existsById(id)){
            productRepository.findById(id).ifPresent(b -> {
                productRepository.deleteById(id);
            });
        }
        return "redirect:/products";
    }

}
