package controller.FunctionOfLoan.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoanUpdateValidator {

    protected int validateIDOfTransaction(){
        int id;
        System.out.print("Enter transaction's ID: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("Transaction's ID cannot empty!");
            return validateIDOfTransaction();
        }
        try {
            id = Integer.parseInt(id_input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateIDOfTransaction();
        }
        return id;
    }

    protected LocalDate validateDateReturn(LocalDate borrowDate , LocalDate defaultReturnDate){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter return date (YYYY-MM-DD) ("+defaultReturnDate+"): ");
        String input = sc.nextLine();
        if (input.isEmpty()){
            return defaultReturnDate;
        }
        try {
            LocalDate returnDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            if (!returnDate.isAfter(borrowDate)) {
                System.out.println("Return date must be at least one day after the borrow date!");
                return validateDateReturn(borrowDate , defaultReturnDate);
            }
            return returnDate;
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateReturn(borrowDate , defaultReturnDate);
        }
    }
}
