package controller.FunctionOfBook;

import model.book.Books;
import model.book.BooksData;
import view.ListMenu;

import java.util.Map;

public class DisplayBook {
    private final Books BookModel;


    public DisplayBook(Books bookModel) {
        BookModel = bookModel;
    }
    public void UserDisplayBook() {
        System.out.println(ListMenu.displayHeaderOfBook());
        for (Map.Entry<Integer, BooksData> books : BookModel.getMapBooks().entrySet()) {
            if (books.getValue().isActive_book()) {
                System.out.println(books.getValue().displayOfBook());
            }
        }
    }
    public void UserDisplayBookNotActive() {
        System.out.println(ListMenu.displayHeaderOfBook());
        for (Map.Entry<Integer, BooksData> books : BookModel.getMapBooks().entrySet()) {
            if (!books.getValue().isActive_book()) {
                System.out.println(books.getValue().displayOfBook());
            }
        }
    }
}

