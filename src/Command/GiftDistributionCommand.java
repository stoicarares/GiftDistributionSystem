package Command;

import entertainment.Child;
import entertainment.Database;
import enums.Category;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiftDistributionCommand extends Command {
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

    public InputGift getCheapest(List<InputGift> giftList) {
        InputGift chepestGift = giftList.get(0);
        for (int i = 1; i < giftList.size(); i++) {
            if (chepestGift.getPrice() > giftList.get(i).getPrice())
                chepestGift = giftList.get(i);
        }

        return chepestGift;
    }

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
                            //                        Database.getDatabase().getSantaGiftsList().remove(cheapestGift);
                            //                        giftMap.get(category).remove(cheapestGift);
                        }
                    }
                }
            }
        }


    }
}