package Command;

import entertainment.Database;

public class EliminateYoungAdultsCommand extends Command {
    @Override
    public void execute() {
        for (int i = 0; i < Database.getDatabase().getChildren().size(); i++) {
            if (Database.getDatabase().getChildren().get(i).getAge() > 18) {
                i--;
                Database.getDatabase().getChildren().remove(i + 1);
            }
        }
    }

}