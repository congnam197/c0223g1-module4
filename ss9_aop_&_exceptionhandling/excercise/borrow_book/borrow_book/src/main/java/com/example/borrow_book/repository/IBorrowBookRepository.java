package com.example.borrow_book.repository;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.BorrowBook;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    List<BorrowBook> findAllByFlagDeleteIsFalse();

    List<BorrowBook> findBorrowBookByBook(Book book);

    BorrowBook findBorrowBookByCode(Integer code);
    boolean existsBorrowBookByCode(Integer code);

}
