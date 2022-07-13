package contacts.cli;

import contacts.database.Dataset;

public class CountCommand extends CliCommand {
    public void execute() {
        System.out.printf("The Phone Book has %d records.%n", Dataset.getSize());
    }
}
