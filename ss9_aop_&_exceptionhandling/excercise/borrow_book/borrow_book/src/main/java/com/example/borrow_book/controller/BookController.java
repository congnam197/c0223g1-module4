package com.example.borrow_book.controller;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping()
    public String displayBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "home";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Book book =bookService.findById(id);
        if (book==null){
            model.addAttribute("message","The Book not exist!");
            return "error";
        }
        if (book.getQuantity()==0){
            model.addAttribute("message","The books in the library are out of stock");
            return "error";
        }
        model.addAttribute("book", book);
        return "detail";
    }
}
