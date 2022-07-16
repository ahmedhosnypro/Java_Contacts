package contacts.contact.organization;

import contacts.contact.Contact;
import contacts.contact.ContactDetailsFactory;
import contacts.contact.ContactFactory;

public class OrganizationFactory implements ContactFactory {

    @Override
    public Contact createContact() {
        ContactDetailsFactory contactDetailsFactory = new OrganizationDetailsFactory();
        return new Organization(contactDetailsFactory);
    }
}
