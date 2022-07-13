package contacts.contact;

public class Contact {
    protected String name;
    protected String surname;
    protected String number;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = PhoneNumberValidator.validateAndReturn(number);
    }

    //getters & setters for properties
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(String number) {
        this.number = PhoneNumberValidator.validateAndReturn(number);
    }

    @Override
    public String toString() {
        return (name.isEmpty() ? "" : name + " ") +
                (surname.isEmpty() ? "" : surname + ", ") +
                (number.isEmpty() ? "[no number]" : number);
    }
}
