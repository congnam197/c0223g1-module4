package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showFormProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("search", new Product());
        return "/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 1000));
        productService.add(product);
        redirectAttributes.addFlashAttribute("message", "Add New Product Successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }

    @PostMapping("/delete")
    public String showDetailProductDelete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete product successfully");
        return "redirect:/product";
    }


    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Update product successfully");
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Product product, Model model) {
        if (product.getName().equals("")) {
            return "redirect:/product";
        } else {
            model.addAttribute("search", new Product());
            model.addAttribute("products", productService.findByName(product.getName()));
            return "/index";
        }
    }
}
