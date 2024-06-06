import controller.FunctionOfBook.*;
import controller.FunctionOfLoan.BorrowBook;
import controller.FunctionOfLoan.DisplayLoan;
import controller.FunctionOfLoan.UpdateLoan;
import controller.FunctionOfUser.CreateUser;
import controller.FunctionOfUser.DeleteUser;
import controller.FunctionOfUser.DisplayUser;
import controller.FunctionOfUser.UpdateUser;
import controller.Reporting.ReportBorrowBook;
import controller.Reporting.ReportOverdueBook;
import controller.Reporting.ReportTotalBorrowingActivities;
import controller.StoreDataToFile;
import model.book.Books;
import model.loan.Loans;
import model.user.Users;
import view.ListMenu;


public class Main {
    public static Books bookModel = new Books();
    public static Users usersModel = new Users();
    public static Loans loansModel = new Loans();
    public static StoreDataToFile storeDataToFile = new StoreDataToFile(bookModel , usersModel, loansModel);
    public static CreateBook createBook = new CreateBook(bookModel);
    public static UpdateBook updateBook = new UpdateBook(bookModel);
    public static DeleteBook deleteBook = new DeleteBook(bookModel);
    public static DisplayBook displayBook = new DisplayBook(bookModel);
    public static CreateUser createUser = new CreateUser(usersModel);
    public static UpdateUser updateUser = new UpdateUser(usersModel);
    public static DeleteUser deleteUser = new DeleteUser(usersModel);
    public static DisplayUser displayUser = new DisplayUser(usersModel);
    public static BorrowBook borrowBook = new BorrowBook(loansModel , usersModel , bookModel);
    public  static UpdateLoan updateLoan = new UpdateLoan(loansModel , usersModel , bookModel);
    public static DisplayLoan displayLoan = new DisplayLoan(loansModel);
    public static ReportBorrowBook reportBorrowBook = new ReportBorrowBook(loansModel);
    public static ReportOverdueBook reportOverdueBook = new ReportOverdueBook(loansModel);
    public static ReportTotalBorrowingActivities reportTotalBorrowingActivities = new ReportTotalBorrowingActivities(loansModel);
    public static void main(String[] args) {
        storeDataToFile.UserReloadDataToFile();
        program();
    }
    public static void program () {
        while(true){
            ListMenu.getWelcome();
            int choice = ListMenu.inputMenu();
            switch (choice) {
                case 1:
                    int choiceManageBook = ListMenu.MenuManageBooks();
                    switch (choiceManageBook) {
                        case 1:
                            createBook.UserCreateBook();
                            break;

                        case 2:
                            updateBook.UserUpdateBook();
                            break;

                        case 3:
                            deleteBook.UserDeleteBook();
                            break;

                        case 4:
                            int choiceDisplay = ListMenu.MenuDisplay();
                            if (choiceDisplay == 1) displayBook.UserDisplayBook();
                            else displayBook.UserDisplayBookNotActive();
                            break;
                    }
                    break;
                case 2:
                    int choiceManageUser = ListMenu.MenuManageUsers();
                    switch (choiceManageUser) {
                        case 1:
                            createUser.UserCreateUser();
                            break;
                        case 2:
                            updateUser.UserUpdateUser();
                            break;

                        case 3:
                            deleteUser.UserDeleteUser();
                            break;

                        case 4:
                            int choiceDisplay = ListMenu.MenuDisplay();
                            if (choiceDisplay == 1) displayUser.UserDisplayUser();
                            else displayUser.UserDisplayUserNotActive();
                            break;
                    }
                    break;

                case 3:
                    int choiceManageLoan = ListMenu.MenuManageLoans();
                    switch (choiceManageLoan) {
                        case 1:
                            borrowBook.UserBorrowBook();
                            break;

                        case 2:
                            updateLoan.UserUpdateLoan();
                            break;

                        case 3:
                            displayLoan.UserDisplayLoan();
                            break;
                    }
                    break;

                case 4:
                    int choiceReporting = ListMenu.MenuReporting();
                    switch (choiceReporting) {
                        case 1:
                            reportBorrowBook.UserReportBorrowedBooks();
                            break;
                        case 2:
                            reportOverdueBook.UserReportOverdueBooks();
                            break;
                        case 3:
                            reportTotalBorrowingActivities.UserReportBorrowingActivities();
                            break;
                    }
                    break;

                case 5: //Store data
                    int choiceManageStore = ListMenu.MenuStoreAndLoad();
                    if (choiceManageStore == 1) storeDataToFile.UserStoreDataToFile();
                    else storeDataToFile.UserReloadDataToFile();
                    break;

                case 6:
                    System.out.println("Quit menu. See you later!");
                    return;
            }
        }
    }
}