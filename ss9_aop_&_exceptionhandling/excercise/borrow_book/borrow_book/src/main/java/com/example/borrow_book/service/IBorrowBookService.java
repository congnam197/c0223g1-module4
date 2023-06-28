package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowBookService {
    Integer create(Book book);

    List<BorrowBook> findAll();

    List<BorrowBook> findBorrowByBook(Book book);

    BorrowBook getBookByCode(Integer code);

    void updateFlagDelete(BorrowBook borrowBook);
}
