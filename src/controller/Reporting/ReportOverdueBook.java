package controller.Reporting;

import model.loan.Loans;
import model.loan.LoansData;
import view.ListMenu;

import java.time.LocalDate;
import java.util.Map;

public class ReportOverdueBook {
    private final Loans LoanModel;

    public ReportOverdueBook(Loans loanModel) {
        LoanModel = loanModel;
    }
    public void UserReportOverdueBooks() {
        System.out.println(ListMenu.displayHeaderOfReportOverdueBook());
        for (Map.Entry<Integer, LoansData> entry : LoanModel.getMapLoans().entrySet()) {
            LoansData loan = entry.getValue();
            if (loan.getReturnDate() != null && loan.getReturnDate().isBefore(LocalDate.now())) {
                System.out.println(entry.getValue().displayOfOverdueBook());
            }
        }
    }
}
