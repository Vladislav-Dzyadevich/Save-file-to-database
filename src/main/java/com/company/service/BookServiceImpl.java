package com.company.service;

import com.company.dto.BookDto;
import com.company.entity.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        book.setGenre(bookDto.getGenre());
        bookRepository.save(book);
    }

    @Override
    public List<Book> showBook() {
        return bookRepository.findAll();
    }
}
