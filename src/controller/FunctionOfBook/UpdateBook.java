package controller.FunctionOfBook;


import controller.FunctionOfBook.validators.BookUpdateValidator;
import model.book.Books;
import model.book.BooksData;
import view.ListMenu;

public class UpdateBook extends BookUpdateValidator {
    private final Books BookModel;

    public UpdateBook(Books bookModel) {
        BookModel = bookModel;
    }
    public void UserUpdateBook () {
        int idBook = validateID();
        if (BookModel.getIndexById(idBook) == -1) {
            System.out.println("Book's ID is not exist!");
            UserUpdateBook();
        }
        System.out.println("\n---> Leave blank to keep current <---");
        BooksData bookData = BookModel.getBookById(idBook);

        String title = validateTitle(bookData.getBookTitle());
        bookData.setBookTitle(title);

        String author = validateAuthor(bookData.getAuthor());
        bookData.setAuthor(author);

        String py = validatePublicationYear(bookData.getPublicationYear());
        bookData.setPublicationYear(py);

        String publisher = validatePublisher(bookData.getPublisher());
        bookData.setPublisher(publisher);

        String ISBN = validateISBN(bookData.getISBN());
        bookData.setISBN(ISBN);

        boolean active = validateChangeActive(bookData.isActive_book());
        bookData.setActive_book(active);

        BookModel.update(idBook,bookData);

        System.out.println("\nUpdate success !");
        System.out.println("Continue updating another book ?");
        if (ListMenu.continueFeature() == 1){
            UserUpdateBook();
        }
    }

}
