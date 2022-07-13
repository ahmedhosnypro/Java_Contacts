package contacts.cli;

import contacts.database.Dataset;

import static contacts.Main.SCANNER;

public class EditCommand extends CliCommand {
    @Override
    public void execute() {
        if (Dataset.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }

        int index = readRecordIndex();

        editRecord(index);
    }

    private void editRecord(int recordIndex) {
        System.out.print("Select a field (name, surname, number): ");
        String field = SCANNER.nextLine();

        if (!isValidField(field)) {
            System.out.println("Invalid field!");
            return;
        }

        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                String name = SCANNER.nextLine();
                Dataset.getRecord(recordIndex).setName(name);
            }
            case "surname" -> {
                System.out.print("Enter surname: ");
                String surname = SCANNER.nextLine();
                Dataset.getRecord(recordIndex).setSurname(surname);
            }
            case "number" -> {
                System.out.print("Enter number: ");
                String number = SCANNER.nextLine();
                Dataset.getRecord(recordIndex).setNumber(number);
            }
            default -> {
            }
        }

        System.out.println("The record updated!");
    }

    private boolean isValidField(String field) {
        return field.equals("name") || field.equals("surname") || field.equals("number");
    }
}
