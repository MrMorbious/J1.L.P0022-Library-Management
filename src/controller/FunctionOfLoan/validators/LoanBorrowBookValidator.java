package controller.FunctionOfLoan.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoanBorrowBookValidator {
    protected int validateIDOfUser(){
        int id;
        System.out.print("Enter User's ID: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("User's ID cannot empty!");
            return validateIDOfUser();
        }
        try {
            id = Integer.parseInt(id_input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateIDOfUser();
        }
        return id;
    }
    protected int validateIDOfBook(){
        int id;
        System.out.print("Enter Book's ID: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("Book's ID cannot empty!");
            return validateIDOfBook();
        }
        try {
            id = Integer.parseInt(id_input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateIDOfBook();
        }
        return id;
    }
    protected LocalDate validateDateBorrow(){
        LocalDate today = LocalDate.now();
        System.out.print("Enter borrow date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate borrow = null;
        if (input.trim().isEmpty()){
            System.out.println("Borrow date cannot empty!");
            return validateDateBorrow();
        }
        try {
            borrow = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            if (!borrow.equals(today)) {
                System.out.println("Borrow date must be today!");
                return validateDateBorrow();
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateBorrow();
        }
        return borrow;
    }
    protected LocalDate validateDateReturn(LocalDate borrowDate){

        System.out.print("Enter return date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate returnDate = null;
        if (input.isEmpty()){
            System.out.println("Return date cannot empty!");
            return validateDateReturn(borrowDate);
        }
        try {
            returnDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            if (!returnDate.isAfter(borrowDate)) {
                System.out.println("Return date must be at least one day after the borrow date!");
                return validateDateReturn(borrowDate);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateReturn(borrowDate);
        }
        return returnDate;
    }

}

