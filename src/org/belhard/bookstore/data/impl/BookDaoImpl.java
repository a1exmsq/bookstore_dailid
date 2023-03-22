package org.belhard.bookstore.data.impl;

import org.belhard.bookstore.data.BookDao;
import org.belhard.bookstore.data.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5342/bookstore_bh";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final String DB_QUERY_INSERT_ROW = "INSERT INTO books (author, isbn, title, publishing_house, publishing_year, type_of_cover, number_of_pages, price)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);" ;
    private static final String DB_QUERY_DELETE_BY_ID = "DELETE FROM books WHERE id = ?";
    private static final String DB_QUERY_READ_ALL = "SELECT author, isbn, title, publishing_house, publishing_year, type_of_cover, number_of_pages, price FROM books";
    private static final String DB_QUERY_READ_BY_ID = "SELECT author, isbn, title, publishing_house, publishing_year, type_of_cover, number_of_pages, price FROM books WHERE id = ?";
    private static final String DB_QUERY_UPDATE_ISBN_BY_ID = "UPDATE books SET isbn = ? WHERE id = ?";

    public Book create(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DB_QUERY_INSERT_ROW, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4, book.getPublishingHouse());
            preparedStatement.setString(5, book.getPublishingYear());
            preparedStatement.setString(6, book.getTypeOfCover());
            preparedStatement.setInt(7, book.getNumberOfPages());
            preparedStatement.setDouble(8, book.getPrice());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                long id = resultSet.getLong(1);
                return findById(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Couldn't create book: " + book);
    }

    @Override
    public Book findById(long id) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DB_QUERY_READ_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                book = mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
              Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(DB_QUERY_READ_ALL);
            while (resultSet.next()){
                Book book = mapRow(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    private Book mapRow(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setTitle(resultSet.getString("title"));
        book.setPublishingHouse(resultSet.getString("publishing_house"));
        book.setPublishingYear(resultSet.getString("publishing_year"));
        book.setTypeOfCover(resultSet.getString("type_of_cover"));
        book.setNumberOfPages(resultSet.getInt("number_of_pages"));
        book.setPrice(resultSet.getDouble("price"));
        return book;
    }


    @Override
    public Book update(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(DB_QUERY_UPDATE_ISBN_BY_ID)) {
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setLong(2,book.getId());
            preparedStatement.executeUpdate();
            return findById(book.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(Long id) {
         try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement =  connection.prepareStatement(DB_QUERY_DELETE_BY_ID)){
             preparedStatement.setLong(1, id);
             return preparedStatement.executeUpdate() == 1;
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }
}
