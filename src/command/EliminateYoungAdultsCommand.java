package command;

import common.Constants;
import database.Database;

/**
 * Command that deletes children who have more than 18 years old from the database
 */
public final class EliminateYoungAdultsCommand extends Command {
    @Override
    public void execute() {
        for (int i = 0; i < Database.getDatabase().getChildren().size(); i++) {
            if (Database.getDatabase().getChildren().get(i).getAge() > Constants.YOUNG_ADULT_AGE) {
                i--;
                Database.getDatabase().getChildren().remove(i + 1);
            }
        }
    }

}
