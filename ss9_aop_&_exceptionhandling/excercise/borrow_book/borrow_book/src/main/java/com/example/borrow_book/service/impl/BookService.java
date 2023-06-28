package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.repository.IBookRepository;
import com.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateQuantityWhenBorrow(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    @Override
    public void updateQuantityWhenGiveBack(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
