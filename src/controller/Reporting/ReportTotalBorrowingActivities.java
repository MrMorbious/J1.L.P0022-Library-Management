package controller.Reporting;

import model.loan.Loans;
import model.loan.LoansData;
import view.ListMenu;

import java.time.LocalDate;
import java.util.Map;

public class ReportTotalBorrowingActivities extends ValidateInputDate {
    private final Loans LoanModel;

    public ReportTotalBorrowingActivities(Loans loanModel) {
        LoanModel = loanModel;
    }
    public void UserReportBorrowingActivities() {
        LocalDate startDate = validateDateBorrow();
        LocalDate endDate = validateDateReturn();
        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                               Borrowing Activities from " + startDate + " to " + endDate +"                          |");
        System.out.println(ListMenu.displayHeaderOfTotalLoan());
        for (Map.Entry<Integer, LoansData> entry : LoanModel.getMapLoans().entrySet()) {
            LoansData loan = entry.getValue();
            if ((loan.getBorrowDate().isEqual(startDate) || loan.getBorrowDate().isAfter(startDate)) &&
                    (loan.getBorrowDate().isEqual(endDate) || loan.getBorrowDate().isBefore(endDate))) {
                System.out.println(entry.getValue().displayOfTotalLoan());
            }
        }
    }
}
