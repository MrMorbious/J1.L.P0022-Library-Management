package model.book;

import java.io.Serializable;

public class BooksData implements Serializable {
    private int bookId;
    private String bookTitle;
    private String author;
    private String publicationYear;
    private String publisher;
    private String ISBN;
    private boolean active_book;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isActive_book() {
        return active_book;
    }

    public void setActive_book(boolean active_book) {
        this.active_book = active_book;
    }

    public String displayOfBook() {
        return String.format(
                "| %-7s | %-30s | %-25s | %-20s | %-25s | %-17s | %-10s  |" ,
                bookId, bookTitle, author, publicationYear, publisher, ISBN , active_book
        );
    }
}
