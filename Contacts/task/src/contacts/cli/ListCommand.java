package contacts.cli;

import contacts.database.Dataset;

public class ListCommand extends CliCommand {
    @Override
    void execute() {
        if (Dataset.isEmpty()) {
            System.out.println("No records to list!");
            return;
        }

        for (int i = 0; i < Dataset.getSize(); i++) {
            System.out.println(i + 1 + ". " + Dataset.getRecord(i).toString());
        }
    }
}
