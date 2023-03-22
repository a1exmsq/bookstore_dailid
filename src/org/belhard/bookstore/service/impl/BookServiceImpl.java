package org.belhard.bookstore.service.impl;

import org.belhard.bookstore.data.BookDao;
import org.belhard.bookstore.data.entity.Book;
import org.belhard.bookstore.data.impl.BookDaoImpl;
import org.belhard.bookstore.service.BookService;
import org.belhard.bookstore.service.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public BookDto create(BookDto book) {
        return null;
    }

    @Override
    public BookDto findById(long id) {
        Book book = bookDao.findById(id);
        if (book == null) {
            throw new RuntimeException("No book with id: " + id);
        }
        return toDto(book);
    }

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setNumberOfPages(book.getNumberOfPages());
        bookDto.setPublishingHouse((book.getPublishingHouse()));
        bookDto.setPublishingYear(book.getPublishingYear());
        bookDto.setTypeOfCover(book.getTypeOfCover());
        return bookDto;
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookDao.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            bookDtos.add(toDto(book));
        }
        return bookDtos;
    }

    @Override
    public BookDto update(BookDto book) {
//        Book bookUpdate = bookDao.update();
//        return toDto(bookUpdate);
        return null;
    }

    @Override
    public void delete(long id) {
        boolean isDeleted = bookDao.delete(id);
        if (!isDeleted) {
            throw new RuntimeException("Can not delete book with id" + id);
        }
    }
}
