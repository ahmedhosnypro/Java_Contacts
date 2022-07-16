package contacts.cli;

import contacts.database.Dataset;

import java.util.List;

import static contacts.Main.SCANNER;

public class Utiltly {
    private Utiltly() {
    }

    public static int readRecordIndex() {
        System.out.print("Select a record: ");
        return getValidIndex();
    }

    public static int getValidIndex() {
        int index = readInt() - 1;
        while (isInvalidIndex(index)) {
            System.out.print("Invalid index! Try again: ");
            index = readInt() - 1;
        }
        return index;
    }

    public static boolean isInvalidIndex(int index) {
        return index < 0 || index >= Dataset.getSize();
    }

    public static <T> boolean isInvalidIndex(List<T> list, int index) {
        return index < 0 || index >= list.size();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Try again: ");
            }
        }
    }
}
