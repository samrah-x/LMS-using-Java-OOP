package falafal;
// import lib.*;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static Database database;
    public static void main(String[] args) {

        database = new Database();

        int option;
        do {
            System.out.println("""
                               WELCOME TO LMS!
                               0. Exit
                               1. Login
                               2. Sign Up""");
            scanner = new Scanner(System.in);
            option = scanner.nextInt();

            switch (option) {
                case 1 -> login();
                case 2 -> signup();
                default -> System.out.println("Error! Enter valid option.");
            }
        }
        while (option !=0);

        
        
    }
    private static void login() {
        System.out.println("Enter phone number: ");
        String phonenumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
        }
        else {
        }
    }

    private static void signup() {
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String phonenumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2. Member");
        int option = scanner.nextInt();
        if(option == 1) {
            User admin = new Admin(name, email, phonenumber);
            database.AddUser(admin);
        }
        else {
            User member = new Member(name, email, phonenumber);
            database.AddUser(member);
        }
    }

}