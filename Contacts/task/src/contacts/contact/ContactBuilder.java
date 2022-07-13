package contacts.contact;

public interface ContactBuilder {
    ContactBuilder setName(String name);

    ContactBuilder setSurname(String surname);

    ContactBuilder setNumber(String number);

    Contact build();
}
