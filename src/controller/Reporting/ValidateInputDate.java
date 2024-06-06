package controller.Reporting;

import java.time.LocalDate;
import java.util.Scanner;

public class ValidateInputDate {
    public LocalDate validateDateBorrow(){
        System.out.print("Enter borrow date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate borrow = null;
        if (input.trim().isEmpty()){
            System.out.println("Borrow date cannot empty!");
            return validateDateBorrow();
        }
        try {
            borrow = LocalDate.parse(input);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateBorrow();
        }
        return borrow;
    }
    public LocalDate validateDateReturn(){
        System.out.print("Enter return date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate returnDate = null;
        if (input.isEmpty()){
            System.out.println("Return date cannot empty!");
            return validateDateReturn();
        }
        try {
            returnDate = LocalDate.parse(input);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateReturn();
        }
        return returnDate;
    }
}
