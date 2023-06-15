package com.example.ss1_bai_2.controller;

import com.example.ss1_bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String search(@RequestParam("word") String word, Model model) {
       Map<String,String>stringMap = dictionaryService.getDictionary();
        String result = null;
        for (String text : stringMap.keySet()) {
            if (word.equals(text.toLowerCase(Locale.ROOT))) {
                result = stringMap.get(text);
                break;
            }
        }
        if (result == null) {
            result = "Not Found!";
        }
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        return "/dictionary";
    }

    @GetMapping()
    public String showFormDictionary() {
        return "/dictionary";
    }
}
