package controller.FunctionOfBook.validators;

import java.util.Scanner;

public class BookCreateValidator {
    protected String validateTitle() {
        System.out.print("Enter book's title: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();

        if (title.isEmpty()) {
            System.out.println("The title not allow contain space characters. Please enter again.");
            return validateTitle();
        }
        return title;
    }
    protected String validateAuthor() {
        System.out.print("Enter book's author: ");
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine();

        if (author.isEmpty()) {
            System.out.println("The author not allow contain space characters. Please enter again.");
            return validateAuthor();
        }
        return author;
    }
    protected String validatePublicationYear() {
        System.out.print("Enter book's publication year (YYYY): ");
        Scanner sc = new Scanner(System.in);
        String py = sc.nextLine();
        String pattern = "[0-9][0-9][0-9][0-9]";

        if (py.isEmpty()) {
            System.out.println("The publication year not allow contain space characters. Please enter again.");
            return validatePublicationYear();
        }
        if (!py.matches(pattern)){
            System.out.println("The publication year wrong format ! . Please enter again.");
            return validatePublicationYear();
        }
        return py;
    }
    protected String validatePublisher() {
        System.out.print("Enter book's publisher: ");
        Scanner sc = new Scanner(System.in);
        String publisher = sc.nextLine();

        if (publisher.isEmpty()) {
            System.out.println("The publisher not allow contain space characters. Please enter again.");
            return validatePublisher();
        }
        return publisher;
    }
    protected String validateISBN() {
        System.out.print("Enter book's ISBN: ");
        Scanner sc = new Scanner(System.in);
        String ISBN = sc.nextLine();

        if (ISBN.isEmpty()) {
            System.out.println("Book's ISBN not allow contain space characters. Please enter again.");
            return validateISBN();
        }
        return ISBN;
    }

}
