package com.example.validate_register_form.controller;

import com.example.validate_register_form.dto.UserDto;
import com.example.validate_register_form.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String showFromRegister(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "form";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return "result";
    }
}
