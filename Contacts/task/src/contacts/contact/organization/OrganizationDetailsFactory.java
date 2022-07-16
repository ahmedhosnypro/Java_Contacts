package contacts.contact.organization;

import contacts.contact.ContactDetailsFactory;

import java.time.LocalDateTime;

import static contacts.Main.SCANNER;

public class OrganizationDetailsFactory implements ContactDetailsFactory {

    @Override
    public LocalDateTime addBirthDate() {
        return null;
    }

    @Override
    public String addGender() {
        return null;
    }

    @Override
    public String addAddress() {
        System.out.print("Enter the address: ");
        return SCANNER.nextLine();
    }
}