package controller.FunctionOfUser.validators;

import java.time.LocalDate;
import java.util.Scanner;

public class UserUpdateValidator {
    protected int validateID(){
        int id;
        System.out.print("Enter User's ID: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("User's ID cannot empty!");
            return validateID();
        }
        try {
            id = Integer.parseInt(id_input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateID();
        }
        return id;
    }
    protected String validateName(String defaultName){
        System.out.print("Enter user's title ("+defaultName+"): ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if(name.isEmpty()) {
            return defaultName;
        }
        return name;
    }
    protected LocalDate validateDateOfBirth(LocalDate defaultDateOfBirth) {
        LocalDate date;
        System.out.print("Enter user's date of birth (YYYY-MM-DD) (" + defaultDateOfBirth + "): ");
        Scanner sc = new Scanner(System.in);
        String dob = sc.nextLine();
        if (dob.isEmpty()) {
            return defaultDateOfBirth;
        }
        try {
            date = LocalDate.parse(dob);
        } catch (Exception e){
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDateOfBirth(defaultDateOfBirth);
        }
        return date;
    }
    protected String validatePhoneNumber(String defaultPhoneNumber) {
        System.out.print("Enter user's phone (" + defaultPhoneNumber + "): ");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();

        if (phone.isEmpty()) {
            return phone;
        }
        if (phone.length() < 9 || phone.length() > 15) {
            System.out.println("The phone number wrong format !");
            System.out.println("The phone number include 10 to 15 number ");
            return  validatePhoneNumber(defaultPhoneNumber);
        }
        return phone;
    }

    protected String validateEmail(String defaultEmail) {
        System.out.print("Enter user's email (" + defaultEmail + "): ");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        if (email.isEmpty()) {
            return email;
        }
        if (!email.contains("@") || !email.contains(".")){
            System.out.println("The email wrong format !");
            return  validateEmail(defaultEmail);
        }
        return email;
    }
    protected boolean validateChangeActive(boolean defaultActive) {
        System.out.println("\nEnter user's status ("+defaultActive+"): ");
        System.out.println("1. True");
        System.out.println("2. False");
        System.out.print("Your choice: ");
        boolean active;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty())
            return defaultActive;
        try {
            int input_status = Integer.parseInt(input);
            if (input_status == 1)
                active = true;
            else if (input_status == 2)
                active = false;
            else {
                System.out.println("Just choice 1 or 2!");
                return validateChangeActive(defaultActive);
            }
        }catch (NumberFormatException e) {
            System.out.println("Just choice 1 or 2!");
            return validateChangeActive(defaultActive);
        }
        return active;
    }

    protected boolean validateActive() {
        return false;
    }
}
