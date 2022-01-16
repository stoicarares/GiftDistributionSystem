package gifting;

import fileio.Child;
import database.Database;
import enums.Category;
import fileio.InputGift;

import java.util.List;
import java.util.Map;

/**
 * Command that distributes the gifts to the children
 */
public final class DistributionById extends GiftCommand {
    /**
     * For each child in the Database, i am looking into it's preferences one by one
     * giving him as many gifts as his budget permits.
     * Also checking not to recieve the same gift twice.
     */
    @Override
    public void execute() {
        Map<Category, List<InputGift>> giftMap = buildGiftMap();

        for (Child child : Database.getDatabase().getChildren()) {
            distributePreferedGifts(child, giftMap);
        }
    }
}
