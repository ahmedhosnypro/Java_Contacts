package contacts.cli;

import contacts.database.Dataset;

public class RemoveCommand extends CliCommand {
    @Override
    public void execute() {
        String list = Dataset.list();
        if (list.isEmpty()) {
            System.out.println("No records to remove!\n");
            return;
        }

        System.out.println(list);

        int index = readRecordIndex();

        removeRecord(index);
        System.out.println();
    }

    private void removeRecord(int recordIndex) {
        Dataset.removeContact(Dataset.getRecord(recordIndex));
        System.out.println("The record removed!");
    }
}
