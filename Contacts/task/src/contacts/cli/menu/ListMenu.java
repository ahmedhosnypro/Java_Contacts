package contacts.cli.menu;

import contacts.cli.CLI;
import contacts.database.Dataset;

import static contacts.Main.SCANNER;
import static contacts.cli.Utiltly.isInvalidIndex;
import static contacts.cli.Utiltly.isNumber;

public class ListMenu extends Menu {
    @Override
    public void start() {
        System.out.print("[list] Enter action ([number], back): ");
        handleAction(SCANNER.nextLine());
    }

    @Override
    protected void handleAction(String action) {
        if (action.equals("back")) {
            CLI.setQueueMenu(new MainMenu());
            return;
        }

        if (!isNumber(action)) {
            System.out.println("Invalid input!");
            return;
        }

        int index = Integer.parseInt(action) - 1;
        if (isInvalidIndex(index)) {
            System.out.print("Invalid index!");
            return;
        }

        System.out.println(Dataset.getRecord(index).getInfo());
        System.out.println();
        CLI.setQueueMenu(new RecordMenu(Dataset.getRecord(index)));
    }
}
