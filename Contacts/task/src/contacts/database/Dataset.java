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

    public static String list() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Dataset.getSize(); i++) {
            sb.append(String.format("%d. %s%n", i + 1, Dataset.getRecord(i).toString()));
        }
        return sb.toString().trim();
    }
}
