package gifting;

import database.Database;
import enums.Category;
import fileio.Child;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DistributionByNiceScore extends GiftCommand {
    @Override
    public void execute() {
        Map<Category, List<InputGift>> giftMap = buildGiftMap();
        List<Child> childs = new ArrayList<>(Database.getDatabase().getChildren());
        childs.sort((o1, o2) -> {
            if (o2.getAverageScore().equals(o1.getAverageScore())) {
                return o1.getId().compareTo(o2.getId());
            }

            return o2.getAverageScore().compareTo(o1.getAverageScore());
        });

        for (Child child : childs) {
            distributePreferedGifts(child, giftMap);
        }
    }
}
