package contacts.database;

import contacts.contact.Contact;

import java.util.ArrayList;

public class Dataset {
    private Dataset() {
    }

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static int getSize() {
        return contacts.size();
    }

    public static Contact getRecord(int index) {
        return contacts.get(index);
    }

    public static boolean isEmpty() {
        return contacts.isEmpty();
    }

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
