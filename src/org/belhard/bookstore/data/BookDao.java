package org.belhard.bookstore.data;

import org.belhard.bookstore.data.entity.Book;

import java.util.List;

public interface BookDao {

    Book create(Book book);

    Book findById(long id);

    List<Book> findAll();

    Book update(Book book);

    boolean delete(Long id);

}
