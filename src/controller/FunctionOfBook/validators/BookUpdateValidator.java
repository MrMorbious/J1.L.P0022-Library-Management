package controller.FunctionOfBook.validators;

import java.util.Scanner;

public class BookUpdateValidator {
    protected int validateID(){
        int id;
        System.out.print("Enter Book's ID: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("Book's ID cannot empty!");
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
    protected String validateTitle(String defaultName){
        System.out.print("Enter book's title ("+defaultName+"): ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if(name.isEmpty()) {
            return defaultName;
        }
        return name;
    }
    protected String validateAuthor(String defaultAuthor) {
        System.out.print("Enter book's author (" + defaultAuthor + "): ");
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine();

        if (author.isEmpty()) {
            return defaultAuthor;
        }
        return author;
    }
    protected String validatePublicationYear(String defaultPy) {
        System.out.print("Enter book's publication year (" + defaultPy + "): ");
        Scanner sc = new Scanner(System.in);
        String py = sc.nextLine();

        if (py.isEmpty()) {
            return defaultPy;
        }
        return py;
    }
    protected String validatePublisher(String defaultPublisher) {
        System.out.print("Enter book's publisher (" + defaultPublisher + "): ");
        Scanner sc = new Scanner(System.in);
        String publisher = sc.nextLine();

        if (publisher.isEmpty()) {
            return defaultPublisher;
        }
        return publisher;
    }
    protected String validateISBN(String defaultISBN) {
        System.out.print("Enter book's ISBN (" + defaultISBN + "): ");
        Scanner sc = new Scanner(System.in);
        String ISBN = sc.nextLine();

        if (defaultISBN.isEmpty()) {
            return defaultISBN;
        }
        return defaultISBN;
    }
    protected boolean validateChangeActive(boolean defaultActive) {
        System.out.println("\nEnter book's status ("+defaultActive+"): ");
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
}
