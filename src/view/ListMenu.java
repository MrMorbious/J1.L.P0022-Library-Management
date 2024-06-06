package view;

import java.util.Scanner;

public class ListMenu  {
    public static int inputMenu(){
        System.out.print("Your choice is: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int choice;
        if (input.isEmpty()) {
            System.out.println("Your choice cannot empty . Please enter your choice again ");
            inputMenu();
        }
        try {
            choice = Integer.parseInt(input);
            if (choice <= 0 || choice > 6) {
                System.out.println("Please enter function from 1 to 6!");
                return inputMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input number. Please enter your choice again !");
            return inputMenu();
        }
        return choice;
    }
    public static void getWelcome() {
        System.out.println("\n");
        System.out.println("*__________ Welcome to Library Management System ____________*");
        System.out.println("|                                                            |");
        System.out.println("|                   1. Manage Books                          |");
        System.out.println("|                   2. Manage Users                          |");
        System.out.println("|                   3. Manage Loans                          |");
        System.out.println("|                   4. Reporting                             |");
        System.out.println("|                   5. Store Data to Files                   |");
        System.out.println("|                   6. Exit Program                          |");
        System.out.println("|                                                            |");
        System.out.println("*____________________________________________________________*\n");
    }
    public static int continueFeature(){
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        String input_choice = sc.nextLine();
        int choice;
        if (input_choice.isEmpty()){
            System.out.println("Just choice 1 or 2!");
            return continueFeature();
        }
        try {
            choice = Integer.parseInt(input_choice);
            if(choice != 1 && choice != 2){
                System.out.println("Just choice 1 or 2!");
                return continueFeature();
            }
        }catch (NumberFormatException e) {
            System.out.println("Just choice 1 or 2!");
            return continueFeature();
        }
        return choice;
    }
    public static int MenuManageBooks(){
        System.out.println("1. Add a New Book");
        System.out.println("2. Update Book Information");
        System.out.println("3. Delete a Book");
        System.out.println("4. Show All Books");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 4!\n");
            return MenuManageBooks();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 4){
                System.out.println("\nJust choice 1 to 4!\n");
                return MenuManageBooks();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 4!\n");
            return MenuManageBooks();
        }
        return choice;
    }
    public static int MenuManageUsers(){
        System.out.println("1. Add a New User");
        System.out.println("2. Update User Information");
        System.out.println("3. Delete a User");
        System.out.println("4. Display User List");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 4!\n");
            return MenuManageUsers();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 4){
                System.out.println("\nJust choice 1 to 4!\n");
                return MenuManageUsers();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 4!\n");
            return MenuManageUsers();
        }
        return choice;
    }
    public static int MenuManageLoans(){
        System.out.println("1. Borrow Books");
        System.out.println("2. Update Loan Information");
        System.out.println("3. Display All Borrowed Books");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 3!\n");
            return MenuManageLoans();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 3){
                System.out.println("\nJust choice 1 to 3!\n");
                return MenuManageLoans();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 3!\n");
            return MenuManageLoans();
        }
        return choice;
    }
    public static int MenuReporting(){
        System.out.println("1. Report on Borrowed Books");
        System.out.println("2. Report on Overdue Books");
        System.out.println("3. Report on Total Borrowing Activities");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 3!\n");
            return MenuReporting();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 3){
                System.out.println("\nJust choice 1 to 3!\n");
                return MenuReporting();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 3!\n");
            return MenuReporting();
        }
        return choice;
    }
    public static int MenuStoreAndLoad(){
        System.out.println("1. Data Storage");
        System.out.println("2. Data Reloading");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 2!\n");
            return MenuReporting();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 3){
                System.out.println("\nJust choice 1 to 2!\n");
                return MenuReporting();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 2!\n");
            return MenuReporting();
        }
        return choice;
    }
    public static int MenuDisplay(){
        System.out.println("1. Display Active");
        System.out.println("2. Display Not Active");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 to 2!\n");
            return MenuManageUsers();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 2){
                System.out.println("\nJust choice 1 to 2!\n");
                return MenuManageUsers();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 to 2!\n");
            return MenuManageUsers();
        }
        return choice;
    }
    public static String displayHeaderOfBook () {
        return String.format(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                        "| %-7s | %-30s | %-25s | %-20s | %-25s | %-17s | %-10s |\n" +
                        "-------------------------------------------------------------------------------------------------------------------------------------------------------------",
                "Book ID", "            Title", "         Author", "  Publication Year", "        Publisher", "       ISBN" , "Active Book"
        );
    }
    public static String displayHeaderOfUser () {
        return String.format(
                "---------------------------------------------------------------------------------------------------------------------------\n" +
                        "| %-7s | %-25s | %-15s | %-15s | %-30s | %-12s |\n" +
                        "---------------------------------------------------------------------------------------------------------------------------",
                "User ID", "           Name", "Date of birth", "Phone Number", "            Email" , " Active User"
        );
    }
    public static String displayHeaderOfLoan () {
        return String.format(
                "---------------------------------------------------------------------------\n" +
                        "| %-15s | %-7s | %-7s | %-15s | %-15s | \n" +
                        "---------------------------------------------------------------------------",
                "Transaction ID", "User ID", "Book ID", "Borrow Date", "Return Date"
        );
    }
    public static String displayHeaderOfReportBorrowedBook () {
        return String.format(
                "---------------------------------------------\n" +
                "|      List Of Currently Borrowed Books     |\n" +
                "---------------------------------------------\n" +
                        "| %-7s | %-30s  |\n" +
                        "---------------------------------------------",
                "Book ID", "         Book Title"
        );
    }
    public static String displayHeaderOfReportOverdueBook () {
        return String.format(
                "-----------------------------------------------------------------------------------------------\n" +
                        "|                                     List of Overdue Books                                   |\n" +
                        "-----------------------------------------------------------------------------------------------\n" +
                        "| %-7s | %-30s  | %-15s | %-15s | %-10s  |\n" +
                        "-----------------------------------------------------------------------------------------------",
                "Book ID", "           Book Title","  Borrow Date","  Return Date" ,"  Status"
        );
    }
    public static String displayHeaderOfTotalLoan () {
        return String.format(
                "-------------------------------------------------------------------------------------------------------------\n" +
                        "| %-15s | %-7s | %-7s | %-30s  | %-15s | %-15s | \n" +
                        "-------------------------------------------------------------------------------------------------------------",
                "Transaction ID", "User ID", "Book ID","           Book Title", "Borrow Date", "Return Date"
        );
    }
}
