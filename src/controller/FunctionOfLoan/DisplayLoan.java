package controller.FunctionOfLoan;

import model.loan.Loans;
import model.loan.LoansData;
import view.ListMenu;

import java.util.Map;

public class DisplayLoan {
    private final Loans LoanModel;

    public DisplayLoan(Loans loanModel) {
        LoanModel = loanModel;
    }
    public void UserDisplayLoan () {
        System.out.println(ListMenu.displayHeaderOfLoan());
        for (Map.Entry<Integer, LoansData> books : LoanModel.getMapLoans().entrySet()) {
            System.out.println(books.getValue().displayOfLoans());
        }
    }
}
