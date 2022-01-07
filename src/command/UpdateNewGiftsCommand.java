package command;

import database.Database;
import fileio.InputGift;

import java.util.List;

/**
 * Command for adding new gifts in the Santa's gift list.
 */
public final class UpdateNewGiftsCommand extends Command {
    private final List<InputGift> newGifts;

    public UpdateNewGiftsCommand(final List<InputGift> newGifts) {
        this.newGifts = newGifts;
    }
    @Override
    public void execute() {
        if (newGifts != null) {
            for (InputGift gift : newGifts) {
                InputGift newGift = new InputGift(gift);
                Database.getDatabase().getSantaGiftsList().add(newGift);
            }
        }
    }
}
