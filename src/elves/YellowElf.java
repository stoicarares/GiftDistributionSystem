package elves;

import database.Database;
import enums.Category;
import enums.ElvesType;
import fileio.Child;
import fileio.InputGift;

public final class YellowElf extends ElfCommand {
    @Override
    public void execute() {
        for (Child child : Database.getDatabase().getChildren()) {
            if (child.getElf().equals(ElvesType.YELLOW)) {
                if (child.getReceivedGifts().isEmpty()) {
                    Category preferedCategory = child.getGiftsPreferences().get(0);
                    InputGift cheapestGift = null;
                    for (InputGift gift : Database.getDatabase().getSantaGiftsList()) {
                        if (gift.getCategory().equals(preferedCategory)) {
                            if (cheapestGift == null) {
                                cheapestGift = gift;
                            } else if (gift.getPrice() < cheapestGift.getPrice()) {
                                cheapestGift = gift;
                            }
                        }
                    }
                    if (cheapestGift != null) {
                        if (cheapestGift.getQuantity() > 0) {
                            child.getReceivedGifts().add(cheapestGift);
                            cheapestGift.setQuantity(cheapestGift.getQuantity() - 1);
                        }
                    }
                }
            }
        }
    }
}
