package contacts.cli;

import contacts.database.Dataset;

public class RemoveCommand extends CliCommand {
    @Override
    public void execute() {
        if (Dataset.isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }

        int index = readRecordIndex();

        removeRecord(index);
    }

    private void removeRecord(int recordIndex) {
        Dataset.removeContact(Dataset.getRecord(recordIndex));
        System.out.println("The record removed!");
    }
}
