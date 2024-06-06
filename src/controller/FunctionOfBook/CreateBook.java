package controller.FunctionOfBook;

import controller.FunctionOfBook.validators.BookCreateValidator;
import model.book.Books;
import model.book.BooksData;
import view.ListMenu;

public class CreateBook extends BookCreateValidator {
    private final Books BookModel;
    public CreateBook(Books bookModel) {
        BookModel = bookModel;
    }
    public void UserCreateBook() {
        BooksData bookData = new BooksData();

        String title = validateTitle();
        bookData.setBookTitle(title);

        String author = validateAuthor();
        bookData.setAuthor(author);

        String py = validatePublicationYear();
        bookData.setPublicationYear(py);

        String publisher = validatePublisher();
        bookData.setPublisher(publisher);

        String ISBN = validateISBN();
        bookData.setISBN(ISBN);

        BookModel.add(bookData);

        System.out.println("\nAdded success !");
        bookData.setActive_book(true);
        System.out.println("Continue adding another book ?");
        if (ListMenu.continueFeature() == 1){
            UserCreateBook();
        }
    }
}
