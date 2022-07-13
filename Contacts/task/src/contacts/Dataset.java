package contacts;

import java.util.ArrayList;

public class Dataset {
    private Dataset() {
    }

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public static void removeAllContacts() {
        contacts.clear();
    }

    public static boolean containsContact(Contact contact) {
        return contacts.contains(contact);
    }
}
