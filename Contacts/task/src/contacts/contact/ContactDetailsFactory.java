package contacts.contact;

import contacts.validator.BirthDateValidator;
import contacts.validator.PhoneNumberValidator;

import java.time.LocalDateTime;

import static contacts.Main.SCANNER;

public interface ContactDetailsFactory {

    default String addName() {
        System.out.print("Enter the name: ");
        return SCANNER.nextLine();
    }

    default String addSurname() {
        System.out.print("Enter the surname: ");
        return SCANNER.nextLine();
    }

    LocalDateTime addBirthDate();

    String addGender();

    String addAddress();

    default String addNumber() {
        System.out.print("Enter the number: ");
        var number = SCANNER.nextLine();
        return PhoneNumberValidator.validateAndReturn(number);
    }
}
