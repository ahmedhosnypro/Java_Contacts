package contacts.cli;

import static contacts.Main.SCANNER;

public class CLI {
    private static final CliCommandController controller = new CliCommandController();

    private CLI() {
    }

    public static void start() {
        boolean isRunning = true;
        while (isRunning) {
            isRunning = mainMenu();
        }
    }

    private static boolean mainMenu() {
        System.out.print("Enter action (add, remove, edit, count, list, exit): ");
        String action = SCANNER.nextLine();

        if (!isValidAction(action)) {
            System.out.println("Unknown action!");
            return true;
        }

        controller.setCliCommand(
                switch (action) {
                    case "remove" -> new RemoveCommand();
                    case "edit" -> new EditCommand();
                    case "count" -> new CountCommand();
                    case "info" -> new InfoCommand();
                    case "exit" -> new ExitCommand();
                    default -> new AddCommand();
                }
        );
        controller.executeCommand();
        return !action.equals("exit");
    }

    private static boolean isValidAction(String action) {
        return action.equals("add") || action.equals("remove") ||
                action.equals("edit") || action.equals("count") ||
                action.equals("info") || action.equals("exit");
    }
}
