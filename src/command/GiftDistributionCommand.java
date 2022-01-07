package command;

import fileio.Child;
import database.Database;
import enums.Category;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Command that distributes the gifts to the children
 */
public final class GiftDistributionCommand extends Command {
    /**
     * Method that creates a map which stores all the gifts by their categories.
     * @return The new map formed
     */
    public Map<Category, List<InputGift>> buildGiftMap() {
        Map<Category, List<InputGift>> giftMap = new HashMap<>();
        for (InputGift gift : Database.getDatabase().getSantaGiftsList()) {
            if (!giftMap.containsKey(gift.getCategory())) {
                giftMap.put(gift.getCategory(), new ArrayList<>());
            }
            giftMap.get(gift.getCategory()).add(gift);
        }

        return giftMap;
    }

    /**
     * Method that finds the cheapest gift from a list of gifts
     * @param giftList The list where cheapest gift is to be found
     * @return The least expensive gift from the list
     */
    public InputGift getCheapest(final List<InputGift> giftList) {
        InputGift chepestGift = giftList.get(0);
        for (int i = 1; i < giftList.size(); i++) {
            if (chepestGift.getPrice() > giftList.get(i).getPrice()) {
                chepestGift = giftList.get(i);
            }
        }

        return chepestGift;
    }

    /**
     * For each child in the Database, i am looking into it's preferences one by one
     * giving him as many gifts as his budget permits.
     * Also checking not to recieve the same gift twice.
     */
    @Override
    public void execute() {
        Map<Category, List<InputGift>> giftMap = buildGiftMap();

        for (Child child : Database.getDatabase().getChildren()) {
            double childBudget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()) {
                if (giftMap.containsKey(category)) {
                    List<InputGift> giftList = giftMap.get(category);
                    InputGift cheapestGift = getCheapest(giftList);
                    if (!child.getReceivedGifts().contains(cheapestGift)) {
                        if ((childBudget - cheapestGift.getPrice()) > 0) {
                            child.getReceivedGifts().add(cheapestGift);
                            childBudget -= cheapestGift.getPrice();
                        }
                    }
                }
            }
        }
    }
}
