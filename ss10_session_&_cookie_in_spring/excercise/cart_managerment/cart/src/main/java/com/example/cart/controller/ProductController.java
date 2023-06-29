package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart getProduct() {
        return new Cart();
    }

    @GetMapping()
    public String displayListProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, Model model,
                            RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("message", "Product not exist");
            return "error";
        }
        cart.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Add " + product.getName() + " to cart successfully");
        return "redirect:/products";
    }
}
