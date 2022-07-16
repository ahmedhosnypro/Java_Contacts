package contacts.cli;

import contacts.contact.Contact;
import contacts.database.Dataset;

public class InfoCommand extends CliCommand {
    @Override
    void execute() {
        String list = Dataset.list();
        if (list.isEmpty()) {
            System.out.println("No records to show!\n");
            return;
        }

        System.out.println(list);

        System.out.println("Enter index to show info: ");
        int index = readRecordIndex();

        Contact contact = Dataset.getRecord(index);
        System.out.println(contact.getInfo());
        System.out.println();
    }
}
