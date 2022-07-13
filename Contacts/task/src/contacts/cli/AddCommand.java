package contacts.cli;

import contacts.contact.Contact;
import contacts.database.Dataset;

import static contacts.Main.SCANNER;

public class AddCommand extends CliCommand {
    @Override
    public void execute() {
        System.out.print("Enter the name: ");
        String name = SCANNER.nextLine();

        System.out.print("Enter the surname: ");
        String surname = SCANNER.nextLine();

        System.out.print("Enter the number: ");
        String number = SCANNER.nextLine();

        Contact contact = new Contact(name, surname, number);
        Dataset.addContact(contact);

       System.out.println("The record added.");
    }
}
