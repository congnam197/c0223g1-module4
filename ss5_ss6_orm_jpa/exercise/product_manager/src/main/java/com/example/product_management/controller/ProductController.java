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
        product.setId(productService.findAll().size() + 1);
        productService.add(product);
        redirectAttributes.addFlashAttribute("message", "Add New Product Successfully");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        if (!productService.checkId(id)) {
            model.addAttribute("message", "product not exist!");
            return "/error";
        }
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @PostMapping("/delete")
    public String showDetailProductDelete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes, Model model) {
        if (!productService.checkId(id)) {
            model.addAttribute("message", "product not exist!");
            return "/error";
        }
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete product successfully");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        if (!productService.checkId(id)) {
            model.addAttribute("message", "product not exist!");
            return "/error";
        }
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes, Model model) {
        if (!productService.checkId(product.getId())) {
            model.addAttribute("message", "product not exist!");
            return "/error";
        }
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
