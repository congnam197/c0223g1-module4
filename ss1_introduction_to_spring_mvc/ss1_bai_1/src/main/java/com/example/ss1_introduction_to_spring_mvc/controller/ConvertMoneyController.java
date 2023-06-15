package com.example.ss1_introduction_to_spring_mvc.controller;

import com.example.ss1_introduction_to_spring_mvc.service.IConvertMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.NumberFormat;
import java.util.Locale;

@Controller
@RequestMapping("convert")
public class ConvertMoneyController {
    @Autowired
    private IConvertMoneyService convertMoneyService;
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

    @PostMapping("calculator")
    public String convertMoney(@RequestParam("money") double money, @RequestParam("rate") double rate, Model model) {
        double vnd = convertMoneyService.changeMoney(money, rate);
        String result = currencyVN.format(vnd);
        model.addAttribute("usd", money);
        model.addAttribute("rate", rate);
        if (vnd > 0) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("error", "Money and Rate must be greater than 0");
        }
        return "convertMoney-form";
    }

    @GetMapping()
    public String showFormConvert() {
        return "convertMoney-form";
    }
}
