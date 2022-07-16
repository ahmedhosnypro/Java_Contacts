package contacts.cli.menu;

public abstract class Menu {
    public abstract void start();

    protected abstract void handleAction(String action);
}
