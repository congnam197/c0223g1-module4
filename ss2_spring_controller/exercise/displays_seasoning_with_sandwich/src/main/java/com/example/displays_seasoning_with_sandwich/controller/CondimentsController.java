package com.example.displays_seasoning_with_sandwich.controller;

import com.example.displays_seasoning_with_sandwich.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CondimentsController {
    @Autowired
    private ICondimentsService condimentsService;

    @GetMapping()
    public String showFormCheckBox() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("error", "You must be choice a condiment");
        } else {
            List<String> stringList = condimentsService.getCondiment(condiment);
            model.addAttribute("list", stringList);
        }
        return "index";
    }
}
