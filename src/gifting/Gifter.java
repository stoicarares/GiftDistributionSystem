package gifting;

public final class Gifter {
    /**
     * Invoker's execute method for GiftCommands
     * @param giftCommand the command to be executed
     */
    public void execute(final GiftCommand giftCommand) {
        giftCommand.execute();
    }
}
