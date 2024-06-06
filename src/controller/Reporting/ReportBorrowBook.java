package controller.Reporting;

import model.loan.Loans;
import model.loan.LoansData;
import view.ListMenu;

import java.time.LocalDate;
import java.util.Map;

public class ReportBorrowBook {
    private final Loans LoanModel;

    public ReportBorrowBook(Loans loanModel) {
        LoanModel = loanModel;
    }
    public void UserReportBorrowedBooks() {
        System.out.println(ListMenu.displayHeaderOfReportBorrowedBook());
        for (Map.Entry<Integer, LoansData> entry : LoanModel.getMapLoans().entrySet()) {
            LoansData loan = entry.getValue();
            if (loan.getReturnDate() == null || loan.getReturnDate().isAfter(LocalDate.now())) {
                System.out.println(entry.getValue().displayOfBorrowedBook());
            }
        }
    }
}
