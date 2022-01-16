package command;

/**
 * The invoker for all the commands implemented
 */
public final class Santa {
    /**
     * Method for executing a command,
     * @param command The command to be executed
     */
    public void execute(final Command command) {
        command.execute();
    }
}
