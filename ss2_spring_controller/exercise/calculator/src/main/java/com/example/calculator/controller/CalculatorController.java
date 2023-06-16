package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping()
    public String showFormCalculate() {
        return "calculator";
    }

    @PostMapping()
    public String calculate(@RequestParam(value = "calculator") String acton, @RequestParam(value = "operator1") Double operator1, @RequestParam(value = "operator2") Double operator2, Model model) {
        String result = calculatorService.getResult(acton, operator1, operator2);
        model.addAttribute("result", result);
        model.addAttribute("operator1", operator1);
        model.addAttribute("operator2", operator2);
        return "calculator";
    }
}
