package contacts.cli;

import contacts.database.Dataset;

import static contacts.Main.SCANNER;

public abstract class CliCommand {
    abstract void execute();

    int readRecordIndex() {
        new ListCommand().execute();
        System.out.print("Select a record: ");
        return getValidIndex();
    }

    int getValidIndex() {
        int index = readInt() - 1;
        while (!isValidIndex(index)) {
            System.out.print("Invalid index! Try again: ");
            index = readInt() - 1;
        }
        return index;
    }

    boolean isValidIndex(int index) {
        return index >= 0 && index < Dataset.getSize();
    }

    int readInt() {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Try again: ");
            }
        }
    }
}
