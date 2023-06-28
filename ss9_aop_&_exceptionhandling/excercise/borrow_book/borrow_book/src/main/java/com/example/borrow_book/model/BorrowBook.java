package com.example.borrow_book.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer code;
    private LocalDate borrowDate;
    private boolean flagDelete;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public BorrowBook(Integer id, int code, LocalDate borrowDate, boolean flagDelete, Book book) {
        this.id = id;
        this.code = code;
        this.borrowDate = borrowDate;
        this.flagDelete = flagDelete;
        this.book = book;
    }

    public BorrowBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
