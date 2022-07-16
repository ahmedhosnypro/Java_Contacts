package contacts.cli.menu;

import contacts.cli.CLI;
import contacts.cli.command.SearchCommand;
import contacts.contact.Contact;
import contacts.database.Dataset;

import java.util.List;

import static contacts.Main.SCANNER;
import static contacts.cli.Utiltly.isInvalidIndex;
import static contacts.cli.Utiltly.isNumber;

public class SearchMenu extends Menu {
    private final List<Contact> foundContacts;

    public SearchMenu(List<Contact> foundContacts) {
        this.foundContacts = foundContacts;
    }


    @Override
    public void start() {
        System.out.print("[search] Enter action ([number], back, again): ");
        handleAction(SCANNER.nextLine());
    }

    @Override
    protected void handleAction(String action) {
        if (action.equals("back")) {
            CLI.setQueueMenu(new MainMenu());
            return;
        } else if (action.equals("again")) {
            new SearchCommand().execute();
            return;
        }

        if (!isNumber(action)) {
            System.out.println("Invalid input!");
            return;
        }

        int index = Integer.parseInt(action) - 1;
        if (isInvalidIndex(foundContacts, index)) {
            System.out.print("Invalid index!");
            return;
        }

        System.out.println(Dataset.getRecord(index).getInfo());
        System.out.println();
        CLI.setQueueMenu(new RecordMenu(foundContacts.get(index)));
    }
}
