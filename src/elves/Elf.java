package elves;

public final class Elf {
    /**
     * Invoker's execute method for ElfCommands
     * @param elfCommand the command to be executed
     */
    public void execute(final ElfCommand elfCommand) {
        elfCommand.execute();
    }
}
