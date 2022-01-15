package gifting;

import database.Database;
import enums.Category;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GiftCommand {
    public abstract void execute();

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
        InputGift cheapestGift = null;
        if (!giftList.isEmpty()) {
            cheapestGift = giftList.get(0);
            for (int i = 1; i < giftList.size(); i++) {
                if (cheapestGift.getPrice() > giftList.get(i).getPrice()) {
                    cheapestGift = giftList.get(i);
                }
            }
        }

        return cheapestGift;
    }
}
