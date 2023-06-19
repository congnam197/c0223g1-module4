package com.example.program_to_store_email_configuration.controller;

import com.example.program_to_store_email_configuration.model.Email;
import com.example.program_to_store_email_configuration.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/setting")
    public String showFromEdit(@ModelAttribute Email email, Model model) {
        List<String> languageList = emailService.getLanguagesList();
        List<Integer> pageSizeList = emailService.getPageSizeList();
        model.addAttribute("email", email);
        model.addAttribute("language", languageList);
        model.addAttribute("pageSize", pageSizeList);
        return "form";
    }

    @GetMapping
    public String showFormEmailDetail(Model model) {
        Email email1 = emailService.getEmail();
        model.addAttribute("email", email1);
        return "detail-email";
    }

    @PostMapping("update")
    public String saveFormEmail(Model model, @ModelAttribute Email email) {
        model.addAttribute("email", email);
        return "detail-email";
    }
}
