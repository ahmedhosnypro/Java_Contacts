package contacts.contact.person;

import contacts.contact.Contact;
import contacts.contact.ContactDetailsFactory;
import contacts.contact.ContactFactory;

public class PersonFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        ContactDetailsFactory detailsFactory = new PersonDetailsFactory();
        return new Person(detailsFactory);
    }
}
