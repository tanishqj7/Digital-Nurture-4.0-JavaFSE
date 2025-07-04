package com.tanishq.repository;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public void save(String bookTitle) {
        System.out.println("Saving book: " + bookTitle);
    }
}