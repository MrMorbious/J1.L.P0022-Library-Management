package controller;


import model.book.Books;
import model.loan.Loans;
import model.user.Users;

public class StoreDataToFile {
    private final Books BookModel;
    private final Users UserModel;
    private final Loans LoanModel;

    public StoreDataToFile(Books bookModel, Users userModel, Loans loanModel) {
        BookModel = bookModel;
        UserModel = userModel;
        LoanModel = loanModel;
    }
    public void UserStoreDataToFile() {
        BookModel.storeDataOfBookToFile();
        UserModel.storeDataOfUserToFile();
        LoanModel.storeDataOfLoanToFile();
        System.out.println("Store data to file success!");
    }
    public void UserReloadDataToFile () {
        BookModel.loadDataOfBooksFromFile();
        UserModel.loadDataOfUserFromFile();
        LoanModel.loadDataOfLoanFromFile();
        System.out.println("Load data from file success!");
    }
}
