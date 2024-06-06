package controller.FunctionOfLoan;

import controller.FunctionOfLoan.validators.LoanUpdateValidator;
import model.book.Books;
import model.book.BooksData;
import model.loan.Loans;
import model.loan.LoansData;
import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class UpdateLoan extends LoanUpdateValidator {
    private final Loans LoanModel;
    private final Users UserModel;
    private final Books BookModel;

    public UpdateLoan(Loans loanModel, Users userModel, Books bookModel) {
        LoanModel = loanModel;
        UserModel = userModel;
        BookModel = bookModel;
    }

    public void UserUpdateLoan() {
        int idTransaction = validateIDOfTransaction();
        if (LoanModel.getIndexById(idTransaction) == -1) {
            System.out.println("Transaction's ID is not exist!");
            UserUpdateLoan();
        }
        System.out.println("\n---> Leave blank to keep current <---");
        LoansData loanData = LoanModel.getLoanById(idTransaction);

        UsersData user = inputUser(loanData.getUserID());
        loanData.setUser(user);

        BooksData book = inputBook(loanData.getBookID());
        loanData.setBook(book);

        LocalDate returnDate = validateDateReturn(loanData.getBorrowDate(), loanData.getReturnDate());
        loanData.setReturnDate(returnDate);

        LoanModel.update(idTransaction,loanData);

        System.out.println("\nUpdate success !");
        System.out.println("Continue updating another loans ?");
        if (ListMenu.continueFeature() == 1){
            UserUpdateLoan();
        }
    }
    private UsersData inputUser(int currentUserId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User's ID (" + currentUserId + "): ");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            return UserModel.getUserById(currentUserId);
        }
        int idUser;
        try {
            idUser = Integer.parseInt(input);
            if (UserModel.getIndexUserById(idUser) == -1) {
                System.out.println("User's ID does not exist!");
                return inputUser(currentUserId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
            return inputUser(currentUserId);
        }
        return UserModel.getUserById(idUser);
    }
    private BooksData inputBook(int currentBookId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book's ID (" + currentBookId + "): ");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            return BookModel.getBookById(currentBookId);
        }
        int idBook;
        try {
            idBook = Integer.parseInt(input);
            if (BookModel.getIndexById(idBook) == -1) {
                System.out.println("Book's ID does not exist!");
                return inputBook(currentBookId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
            return inputBook(currentBookId);
        }
        return BookModel.getBookById(idBook);
    }


}
