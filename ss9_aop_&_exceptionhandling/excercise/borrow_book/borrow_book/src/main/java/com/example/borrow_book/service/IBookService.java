package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void updateQuantityWhenBorrow(Book book);

    void updateQuantityWhenGiveBack(Book book);


}
