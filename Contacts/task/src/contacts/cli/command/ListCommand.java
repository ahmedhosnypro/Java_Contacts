package contacts.cli.command;

import contacts.cli.CLI;
import contacts.cli.menu.ListMenu;
import contacts.database.Dataset;

public class ListCommand implements Command {
    @Override
    public void execute() {
        if (Dataset.isEmpty()) {
            System.out.println("No records to list!");
            return;
        }

        System.out.println(Dataset.list());
        System.out.println();

        CLI.setQueueMenu(new ListMenu());
    }
}
