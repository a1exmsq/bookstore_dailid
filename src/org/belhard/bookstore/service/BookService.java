package org.belhard.bookstore.service;

import org.belhard.bookstore.service.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto create(BookDto book);

    BookDto findById(long id);

    List<BookDto> findAll();

    BookDto update(BookDto book);

    void delete(long id);
}
