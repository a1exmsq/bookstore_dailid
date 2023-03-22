package org.belhard.bookstore.data.entity;

import java.util.Objects;

public class Book {

    private Long id;
    private String author;
    private String isbn;
    private String title;
    private String publishingHouse;
    private String publishingYear;
    private String typeOfCover;
    private Integer numberOfPages;
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getTypeOfCover() {
        return typeOfCover;
    }

    public void setTypeOfCover(String typeOfCover) {
        this.typeOfCover = typeOfCover;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getPublishingHouse(), book.getPublishingHouse()) && Objects.equals(getPublishingYear(), book.getPublishingYear()) && Objects.equals(getTypeOfCover(), book.getTypeOfCover()) && Objects.equals(getNumberOfPages(), book.getNumberOfPages()) && Objects.equals(getPrice(), book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getIsbn(), getTitle(), getPublishingHouse(), getPublishingYear(), getTypeOfCover(), getNumberOfPages(), getPrice());
    }
}
