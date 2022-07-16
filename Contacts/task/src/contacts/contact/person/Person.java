package contacts.contact.person;

import contacts.contact.Contact;
import contacts.contact.ContactDetailsFactory;
import contacts.validator.BirthDateValidator;
import contacts.validator.GenderValidator;
import contacts.validator.PhoneNumberValidator;

import java.time.LocalDateTime;

import static contacts.Main.SCANNER;

public class Person extends Contact {
    protected String nickName;
    protected LocalDateTime birthDate;
    protected String gender;

    public Person(ContactDetailsFactory detailsFactory) {
        super();
        name = detailsFactory.addName();
        nickName = detailsFactory.addSurname();
        birthDate = detailsFactory.addBirthDate();
        gender = detailsFactory.addGender();
        number = detailsFactory.addNumber();
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setBirthDate(String birthDate) {

        LocalDateTime birthDateTime = null;
        try {
            birthDateTime = LocalDateTime.parse(BirthDateValidator.validateAndReturn(birthDate));
        } catch (Exception e) {
            System.out.println("Bad birth date!");
        }

        this.birthDate = birthDateTime;
    }

    public void setGender(String gender) {
        this.gender = GenderValidator.validateAndReturn(gender);
    }

    @Override
    public String toString() {
        return (name.isEmpty() ? "" : name + " ") +
                (nickName.isEmpty() ? "" : nickName + ", ");
    }

    @Override
    public void edit() {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String field = SCANNER.nextLine();

        if (isInvalidField(field)) {
            System.out.println("Invalid field!");
            return;
        }

        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                setName(SCANNER.nextLine());
            }
            case "surname" -> {
                System.out.print("Enter surname: ");
                setNickName(SCANNER.nextLine());
            }
            case "birth" -> {
                System.out.print("Enter birth date: ");
                setBirthDate(SCANNER.nextLine());
            }
            case "gender" -> {
                System.out.println("Enter the gender (M, F): ");
                setGender(GenderValidator.validateAndReturn(SCANNER.nextLine()));
            }
            case "number" -> {
                System.out.print("Enter number: ");
                String inputNumber = SCANNER.nextLine();
                setNumber(PhoneNumberValidator.validateAndReturn(inputNumber));
            }
            default -> throw new IllegalArgumentException("Invalid field!");
        }
    }

    @Override
    protected boolean isInvalidField(String field) {
        return !field.equals("name") && !field.equals("surname") && !field.equals("birth") &&
                !field.equals("gender") && !field.equals("number");
    }

    @Override
    public String getInfo() {
        String noData = "[no data]";
        return String.format("""
                        Name: %s
                        Surname: %s
                        Birth date: %s
                        Gender: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                (name == null || name.isEmpty() ? noData : name),
                (nickName == null || nickName.isEmpty() ? noData : nickName),
                (birthDate == null ? noData : birthDate.toString()),
                (gender == null || gender.isEmpty() ? noData : gender),
                (number == null || number.isEmpty() ? noData : number),
                (created == null ? noData : created.toString()),
                (lastEdit == null ? noData : lastEdit.toString()));
    }
}
