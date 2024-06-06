package controller.FunctionOfUser.validators;

import java.time.LocalDate;
import java.util.Scanner;

public class UserCreateValidator {
    protected String validateName() {
        System.out.print("Enter user's name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("The name not allow contain space characters. Please enter again.");
            return validateName();
        }
        return name;
    }
    protected LocalDate validateDateOfBirth() {
        LocalDate dob;
        System.out.print("Enter user's date of birth(YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input_date = sc.nextLine();

        if (input_date.trim().isEmpty()){
            System.out.println("User's date of birth cannot be empty!");
            return validateDateOfBirth();
        }
        try {
            dob = LocalDate.parse(input_date);
        } catch (Exception e){
            System.out.println("Invalid date format. Please enter date of birth in the format YYYY-MM-DD.");
            return validateDateOfBirth();
        }
        return dob;
    }
    protected String validatePhoneNumber() {
        System.out.print("Enter user's phone number: ");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        if (phone.isEmpty()) {
            System.out.println("The phone number not allow contain space characters. Please enter again.");
            return validatePhoneNumber();
        }
        if (phone.length() < 9 || phone.length() > 15) {
            System.out.println("The phone number wrong format !");
            System.out.println("The phone number include 10 to 15 number ");
            return  validatePhoneNumber();
        }
        return phone;
    }
    protected String validateEmail() {
        System.out.print("Enter user's email: ");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        if (email.isEmpty()) {
            System.out.println("The email not allow contain space characters. Please enter again.");
            return validateEmail();
        }
        if (!email.contains("@") || !email.contains(".")){
            System.out.println("The email wrong format !");
            return  validateEmail();
        }
        return email;
    }

}
