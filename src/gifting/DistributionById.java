package gifting;

import command.Command;
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
            double childBudget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()) {
                if (giftMap.containsKey(category) && giftMap.get(category).size() != 0) {
                    List<InputGift> giftList = new ArrayList<>(giftMap.get(category));
                    giftList.removeIf(gift -> gift.getQuantity() <= 0);
                    InputGift cheapestGift = getCheapest(giftList);
                    if (cheapestGift != null
                        && !child.getReceivedGifts().contains(cheapestGift)) {
                        if ((childBudget - cheapestGift.getPrice()) > 0) {
                            child.getReceivedGifts().add(cheapestGift);
                            childBudget -= cheapestGift.getPrice();
//                            System.out.println("555555\n" + category + ":\n" + giftList);
                            if (cheapestGift.getQuantity() > 0)
                                cheapestGift.setQuantity(cheapestGift.getQuantity() - 1);
//                            if (cheapestGift.getQuantity() == 0) {
//                                giftList.remove(cheapestGift);
//                                Database.getDatabase().getSantaGiftsList().remove(cheapestGift);
//                            }
//                            System.out.println(giftList +  "\n66666");
                        }
                    }
                }
            }
        }
    }
}
