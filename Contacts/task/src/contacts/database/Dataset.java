package contacts.database;

import contacts.contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static List<Contact> search(String query) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        return contacts.stream()
                .filter(contact -> {
                    Matcher matcher = pattern.matcher(contact.getInfo());
                    return matcher.find();
                })
                .toList();
    }

    public static String list() {
        return list(contacts);
    }

    public static String list(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contacts.size(); i++) {
            sb.append(String.format("%d. %s%n", i + 1, contacts.get(i).toString()));
        }
        return sb.toString().trim();
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static void removeContact(Contact contact) {
        contacts.remove(contact);
    }
}
