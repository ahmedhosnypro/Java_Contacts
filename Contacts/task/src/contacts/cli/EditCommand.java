package contacts.cli;

import contacts.database.Dataset;

public class EditCommand extends CliCommand {
    @Override
    public void execute() {
        String list = Dataset.list();
        if (list.isEmpty()) {
            System.out.println("No records to edit!\n");
            return;
        }

        System.out.println(list);

        int index = readRecordIndex();

        Dataset.getRecord(index).edit();
        System.out.println("The record updated!\n");
    }
}
