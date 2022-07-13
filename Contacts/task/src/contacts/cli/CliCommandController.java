package contacts.cli;

public class CliCommandController {
    private CliCommand cliCommand;

    public void executeCommand() {
        cliCommand.execute();
    }

    public void setCliCommand(CliCommand cliCommand) {
        this.cliCommand = cliCommand;
    }
}
