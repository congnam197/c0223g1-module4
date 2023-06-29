package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.BorrowBook;
import com.example.borrow_book.repository.IBorrowBookRepository;
import com.example.borrow_book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository borrowBookRepository;

    @Override
    public List<BorrowBook> findAll() {
        return borrowBookRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public List<BorrowBook> findBorrowByBook(Book book) {
        return borrowBookRepository.findBorrowBookByBook(book);
    }

    @Override
    public BorrowBook getBookByCode(Integer code) {
        return borrowBookRepository.findBorrowBookByCode(code);
    }

    @Override
    public void updateFlagDelete(BorrowBook borrowBook) {
        borrowBook.setFlagDelete(true);
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public boolean existsBorrowBookByCode(Integer code) {
        return true;
    }

    @Override
    public Integer create(Book book) {
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setFlagDelete(false);
        borrowBook.setBorrowDate(LocalDate.now());
        borrowBook.setBook(book);
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        borrowBook.setCode(code);
        borrowBookRepository.save(borrowBook);
        return code;
    }
}
