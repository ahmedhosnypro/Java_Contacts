package contacts.cli.command;

import contacts.database.Dataset;

public class CountCommand implements Command {
    public void execute() {
        System.out.printf("The Phone Book has %d records.%n%n", Dataset.getSize());
    }
}
