package controller.FunctionOfLoan;

import controller.FunctionOfLoan.validators.LoanBorrowBookValidator;
import model.book.Books;
import model.book.BooksData;
import model.loan.Loans;
import model.loan.LoansData;
import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

import java.time.LocalDate;

public class BorrowBook extends LoanBorrowBookValidator {
    private final Loans LoanModel;
    private final Users UserModel;
    private final Books BookModel;


    public BorrowBook(Loans loanModel, Users userModel, Books bookModel) {
        LoanModel = loanModel;
        UserModel = userModel;
        BookModel = bookModel;
    }
    public void UserBorrowBook () {
        LoansData loanData = new LoansData();

        UsersData user = inputUser();
        loanData.setUser(user);

        BooksData book = inputBook();
        loanData.setBook(book);

        LocalDate borrowDate = validateDateBorrow();
        loanData.setBorrowDate(borrowDate);

        LocalDate returnDate = validateDateReturn(borrowDate);
        loanData.setReturnDate(returnDate);

        LoanModel.add(loanData);

        System.out.println("\nBorrowed book success !");
        System.out.println("Continue borrowing another book ?");
        if (ListMenu.continueFeature() == 1){
            UserBorrowBook();
        }
        return;
    }
    public UsersData inputUser () {
        int idUser = validateIDOfUser();
        if (UserModel.getIndexUserById(idUser) == -1 ) {
            System.out.println("User's ID is not exist!");
            inputUser();
        }
        if (!UserModel.getUserById(idUser).isActive_user()) {
            System.out.println("User's ID is not available");
            inputUser();
        }
        return UserModel.getUserById(idUser);
    }
    public BooksData inputBook() {
        int idBook = validateIDOfBook();
        if (BookModel.getIndexById(idBook) == -1) {
            System.out.println("Book's ID is not exist!");
            inputBook();
        }
        if (!BookModel.getBookById(idBook).isActive_book()) {
            System.out.println("Book's ID is not available");
            inputBook();
        }
        return BookModel.getBookById(idBook);
    }

}
