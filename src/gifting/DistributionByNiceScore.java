package gifting;

import database.Database;
import enums.Category;
import fileio.Child;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DistributionByNiceScore extends GiftCommand {
    @Override
    public void execute() {
        Map<Category, List<InputGift>> giftMap = buildGiftMap();
        List<Child> childs = new ArrayList<>(Database.getDatabase().getChildren());
//        System.out.println(childs);
        childs.sort((o1, o2) -> {
            if (o2.getAverageScore().equals(o1.getAverageScore()))
                return o1.getId().compareTo(o2.getId());

            return o2.getAverageScore().compareTo(o1.getAverageScore());
        });
//        System.out.println(childs);
//        System.out.println();

        for (Child child : childs) {
            double childBudget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()) {
                if (giftMap.containsKey(category) && giftMap.get(category).size() != 0) {
                    List<InputGift> giftList = giftMap.get(category);
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
