package contacts.contact.organization;

import contacts.contact.Contact;
import contacts.contact.ContactDetailsFactory;
import contacts.validator.PhoneNumberValidator;

import static contacts.Main.SCANNER;

public class Organization extends Contact {
    String address;

    protected Organization(ContactDetailsFactory detailsFactory) {
        super();
        name = detailsFactory.addName();
        address = detailsFactory.addAddress();
        number = detailsFactory.addNumber();
    }

    @Override
    public String toString() {
        return (name.isEmpty() ? "" : name + " ");
    }

    @Override
    public void edit() {
        System.out.print("Select a field (name, address, number): ");
        String field = SCANNER.nextLine();

        if (isInvalidField(field)) {
            System.out.println("Invalid field!");
            return;
        }

        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                String inputName = SCANNER.nextLine();
                setName(inputName);
            }
            case "address" -> {
                System.out.print("Enter address: ");
                String inputAddress = SCANNER.nextLine();
                setAddress(inputAddress);
            }
            case "number" -> {
                System.out.print("Enter number: ");
                String inputNumber = SCANNER.nextLine();
                setNumber(PhoneNumberValidator.validateAndReturn(inputNumber));
            }
            default -> throw new IllegalArgumentException("Invalid field!");
        }

        System.out.println("The record updated!");
    }

    @Override
    protected boolean isInvalidField(String field) {
        return !field.equals("name") && !field.equals("address") && !field.equals("number");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getInfo() {
        String noData = "[no data]";
        return String.format("""
                        Organization name: %s
                        Address: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                (name == null || name.isEmpty() ? noData : name),
                (address == null || address.isEmpty() ? noData : address),
                (number == null || number.isEmpty() ? noData : number),
                (created == null ? noData : created.toString()),
                (lastEdit == null ? noData : lastEdit.toString()));
    }
}
