package contacts.cli;

import contacts.cli.menu.MainMenu;
import contacts.cli.menu.Menu;

public class CLI {
    private static Menu queueMenu;

    private CLI() {
    }

    public static void run() {
        queueMenu = new MainMenu();
        while (queueMenu != null) {
            queueMenu.start();
        }
    }
    public static void setQueueMenu(Menu menu) {
        queueMenu = menu;
    }
}
