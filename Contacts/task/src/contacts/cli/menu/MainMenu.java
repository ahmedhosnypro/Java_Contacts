package contacts.cli.menu;

import contacts.cli.CLI;
import contacts.cli.command.*;

import static contacts.Main.SCANNER;

public class MainMenu extends Menu {
    private static final CliCommandController controller = new CliCommandController();

    public void start() {
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
        String action = SCANNER.nextLine();

        handleAction(action);
    }

    @Override
    protected void handleAction(String action) {
        if (!isValidAction(action)) {
            System.out.println("Unknown action!");
            return;
        }

        controller.setCliCommand(
                switch (action) {
                    case "list" -> new ListCommand();
                    case "search" -> new SearchCommand();
                    case "count" -> new CountCommand();
                    case "exit" -> {
                        CLI.setQueueMenu(null);
                        yield new ExitCommand();
                    }
                    default -> new AddCommand();
                }
        );
        controller.executeCommand();
    }

    private boolean isValidAction(String action) {
        return action.equals("add") || action.equals("list") || action.equals("search") ||
                action.equals("count") || action.equals("exit");
    }
}
