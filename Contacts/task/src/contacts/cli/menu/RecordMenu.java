package contacts.cli.menu;

import contacts.contact.Contact;
import contacts.database.Dataset;

import static contacts.Main.SCANNER;
import static contacts.cli.CLI.setQueueMenu;

public class RecordMenu extends Menu {
    private final Contact contact;

    public RecordMenu(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void start() {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String action = SCANNER.nextLine();
        handleAction(action);
        System.out.println();
    }

    @Override
    protected void handleAction(String action) {
        switch (action) {
            case "edit" -> contact.edit();
            case "delete" -> {
                Dataset.removeContact(contact);
                setQueueMenu(new MainMenu());
            }
            case "menu" -> {
                setQueueMenu(new MainMenu());
            }
            default -> System.out.println("Invalid input!");
        }
    }
}
