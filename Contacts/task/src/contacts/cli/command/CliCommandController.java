package contacts.cli.command;

public class CliCommandController {
    private Command command;

    public void executeCommand() {
        command.execute();
    }

    public void setCliCommand(Command command) {
        this.command = command;
    }
}
