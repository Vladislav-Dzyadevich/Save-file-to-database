package com.company.service;

import com.company.dto.BookDto;
import com.company.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(BookDto bookDto);
    List<Book> showBook();
}
