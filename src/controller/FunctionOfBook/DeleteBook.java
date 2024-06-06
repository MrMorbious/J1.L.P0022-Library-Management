package controller.FunctionOfBook;

import controller.FunctionOfBook.validators.BookUpdateValidator;
import model.book.Books;
import model.book.BooksData;
import view.ListMenu;

public class DeleteBook extends BookUpdateValidator {
    public static Books bookModel = new Books();
    public static DisplayBook displayBook = new DisplayBook(bookModel);
    private final Books BookModel;
    public DeleteBook(Books bookModel) {
        BookModel = bookModel;
    }
    public void UserDeleteBook() {
        int idBook = validateID();

        if (BookModel.getIndexById(idBook) == -1) {
            System.out.println("Book's ID is not exist !");
            System.out.println("Continue deleting another book ?");
            if (ListMenu.continueFeature() == 1){
                UserDeleteBook();
            }
            return;
        }
        BooksData bookData = BookModel.getBookById(idBook);
        System.out.println("Are you sure delete this book id ?");
        if (ListMenu.continueFeature() == 1) {
            BookModel.delete(idBook ,bookData);
            bookData.setActive_book(false);
            System.out.println("\nDelete success !");
            displayBook.UserDisplayBook();
        }
        System.out.println("Continue deleting another book ?");
        if (ListMenu.continueFeature() == 1) {
            UserDeleteBook();
        }
    }
}

