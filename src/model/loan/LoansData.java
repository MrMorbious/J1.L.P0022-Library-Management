package model.loan;

import model.user.UsersData;
import model.book.BooksData;

import java.io.Serializable;
import java.time.LocalDate;

public class LoansData implements Serializable {
    private int transactionId;
    private BooksData book;
    private UsersData user;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public LoansData(){
        this.book = null;
        this.user = null;
    }

    public int getBookID() {
        if (book == null){
            return -1;
        }
        return book.getBookId();
    }
    public int getUserID() {
        if (user == null) {
            return  -1;
        }
        return user.getUserId();
    }
    public String getTitleBook () {
        if (book == null) {
            return "No element !";
        }
        return book.getBookTitle();
    }

    public BooksData getBook() {
        return book;
    }

    public void setBook(BooksData book) {
        this.book = book;
    }

    public UsersData getUser() {
        return user;
    }

    public void setUser(UsersData user) {
        this.user = user;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public String displayOfLoans() {
        return String.format(
                "| %-15s | %-7s | %-7s | %-15s | %-15s |" ,
                transactionId, getUserID(), getBookID(), borrowDate, returnDate
        );
    }
    public String displayOfBorrowedBook() {
        return String.format(
                "| %-7s | %-30s  |" ,
                 getBookID(), "        "+getTitleBook()
        );
    }
    public String displayOfOverdueBook() {
        return String.format(
                "| %-7s | %-30s  | %-15s | %-15s | %-10s  |" ,
                getBookID(), "        "+getTitleBook(),"  "+borrowDate,"  "+returnDate, "  Overdue"
        );
    }
    public String displayOfTotalLoan() {
        return String.format(
                "| %-15s | %-7s | %-7s | %-30s  | %-15s | %-15s |" ,
                transactionId ,"  "+getUserID(),"  "+getBookID(), "        "+getTitleBook(),"   "+borrowDate,"   "+returnDate
        );
    }


}
