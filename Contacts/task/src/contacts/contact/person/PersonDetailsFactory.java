package contacts.contact.person;

import contacts.contact.ContactDetailsFactory;
import contacts.validator.BirthDateValidator;
import contacts.validator.GenderValidator;

import java.time.LocalDateTime;

import static contacts.Main.SCANNER;

public class PersonDetailsFactory implements ContactDetailsFactory {

    @Override
    public LocalDateTime addBirthDate() {
        System.out.print("Enter the birth date");
        return BirthDateValidator.getValidDateOrNull(SCANNER.nextLine());
    }

    @Override
    public String addGender() {
        System.out.print("Enter the gender (M, F): ");
        return GenderValidator.validateAndReturn(SCANNER.nextLine());
    }

    @Override
    public String addAddress() {
        return null;
    }
}
