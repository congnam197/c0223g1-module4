package com.example.borrow_book.controller;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.BorrowBook;
import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowBookController {
    @Autowired
    private IBorrowBookService borrowBookService;
    @Autowired
    private IBookService bookService;

    @PostMapping("")
    public String borrow(@ModelAttribute Book book, Model model, RedirectAttributes redirectAttributes) {
        if (book == null) {
            model.addAttribute("message", "The Book not exist!");
        }
        bookService.updateQuantityWhenBorrow(book);
        borrowBookService.create(book);
        redirectAttributes.addFlashAttribute("message", "Borrow successfully! Your code borrow is " + borrowBookService.create(book));
        return "redirect:/book";
    }

    @PostMapping("/give-back")
    public String giveBack(@RequestParam("code") Integer code, RedirectAttributes redirectAttributes, Model model) {
        if (!borrowBookService.existsBorrowBookByCode(code)) {
            model.addAttribute("message", "The Book not exist!");
            return "error";
        }
        BorrowBook borrowBook = borrowBookService.getBookByCode(code);
        bookService.updateQuantityWhenGiveBack(borrowBook.getBook());
        borrowBookService.updateFlagDelete(borrowBook);
        redirectAttributes.addFlashAttribute("message", "Give Back Book Successfully");
        return "redirect:/book";
    }

    @GetMapping()
    public String showFormCodeBorrow(Model model) {
        model.addAttribute("borrow", borrowBookService.findAll());
        return "borrow";
    }
}
