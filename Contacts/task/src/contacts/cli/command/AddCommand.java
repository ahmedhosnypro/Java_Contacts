package contacts.cli.command;

import contacts.contact.Contact;
import contacts.contact.ContactFactory;
import contacts.contact.organization.OrganizationFactory;
import contacts.contact.person.PersonFactory;
import contacts.database.Dataset;

import static contacts.Main.SCANNER;

public class AddCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization): ");
        String type = SCANNER.nextLine();
        if (!isValidType(type)) {
            System.out.println("Invalid type!");
            return;
        }

        ContactFactory contactFactory;
        switch (type) {
            case "person" -> contactFactory = new PersonFactory();
            case "organization" -> contactFactory = new OrganizationFactory();
            default -> throw new IllegalArgumentException("Invalid type!");
        }

        Contact contact = contactFactory.createContact();
        Dataset.addContact(contact);

        System.out.println("The record added.\n");
    }

    private boolean isValidType(String type) {
        return type.equals("person") || type.equals("organization");
    }
}
