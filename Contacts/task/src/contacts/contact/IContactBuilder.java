package contacts.contact;

public class IContactBuilder implements ContactBuilder {
    private String name = "";
    private String surname = "";
    private String number = "";

    @Override
    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ContactBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public ContactBuilder setNumber(String number) {
        this.number = PhoneNumberValidator.validateAndReturn(number);
        return this;
    }

    @Override
    public Contact build() {
        return new Contact(name, surname, number);
    }
}
