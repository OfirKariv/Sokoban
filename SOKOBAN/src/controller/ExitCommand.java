package controller;

public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void execute() {
	System.out.println("Exit Game");
	System.exit(0);

    }

}
