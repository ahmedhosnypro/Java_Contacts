package contacts;

import java.util.Scanner;

public class ContactBuilder {
    static Scanner scanner = new Scanner(System.in);

    public static void createContact() {
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        Contact contact = new Contact(name, surname, number);
        Dataset.addContact(contact);

        System.out.println("""
                A record created!
                A Phone Book with a single record created!
                """);
    }
}
