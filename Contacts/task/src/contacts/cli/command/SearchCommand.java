package contacts.cli.command;

import contacts.cli.CLI;
import contacts.cli.menu.SearchMenu;
import contacts.database.Dataset;

import static contacts.Main.SCANNER;

public class SearchCommand implements Command {
    @Override
    public void execute() {
        if (Dataset.isEmpty()) {
            System.out.println("No records to search!");
            return;
        }

        System.out.print("Enter search query: ");
        String query = SCANNER.nextLine();

        var foundContacts = Dataset.search(query);
        System.out.println(Dataset.list(foundContacts));
        System.out.println();

        CLI.setQueueMenu(new SearchMenu(foundContacts));
    }
}
