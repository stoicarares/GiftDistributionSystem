package entertainment;

import fileio.*;

import java.util.ArrayList;
import java.util.List;

public final class Database {
    private static Double santaBudget = 0.0;
    //    private final List<Double> santaBudgets = new ArrayList<>();
    private final List<Child> children = new ArrayList<>();
    private final List<InputGift> santaGiftsList = new ArrayList<>();
    private final List<InputAnnualChange> annualChanges = new ArrayList<>();;
//    private final List<Child> giftedChildren = new ArrayList<>();

    private static Database database = null;

    private Database() {

    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void transferChildren(final List<InputChild> inputChildren) {
        this.children.clear();
        for (InputChild child:inputChildren) {
            Child newChild = new Child(child.getId(), child.getLastName(),
                    child.getFirstName(), child.getAge(),
                    child.getCity(), child.getGiftsPreferences(),
                    child.getNiceScore());
            this.children.add(newChild);
        }
    }

    public void transferGifts(final List<InputGift> inputGifts) {
        this.santaGiftsList.clear();
        for (InputGift gift:inputGifts) {
            InputGift newGift = new InputGift(gift.getProductName(), gift.getPrice(),
                    gift.getCategory());
            this.santaGiftsList.add(newGift);
        }
    }

    public void transferAnnualChanges(final List<InputAnnualChange> inputAnnualChanges) {
        this.annualChanges.clear();
        for (InputAnnualChange annualChange:inputAnnualChanges) {
            InputAnnualChange newAnnualChange = new InputAnnualChange(
                    annualChange.getNewSantaBudget(),
                    annualChange.getNewGifts(), annualChange.getNewChildren(),
                    annualChange.getChildrenUpdates());
            this.annualChanges.add(newAnnualChange);
        }
    }

    public Child getChildById(int id) {
        for (Child child:Database.getDatabase().children) {
            if (child.getId().equals(id)) {
                return child;
            }
        }

        return null;
    }

    public void updateChild(final InputChildUpdate childUpdate) {

    }

    public double getTotalScore() {
        double sum = 0.0;
        for (Child child:this.children) {
            if (child.getAge() <= 18)
                sum += child.getAverageScore();
        }

        return sum;
    }

    public double getBudgetUnit() {
        return Database.santaBudget / this.getTotalScore();
    }

    public void setChildrenBudget() {
        for (Child child:this.children) {
            child.setAssignedBudget(this.getBudgetUnit() * child.getAverageScore());
        }
    }

    public static Double getSantaBudget() {
        return santaBudget;
    }

    public static void setSantaBudget(Double santaBudget) {
        Database.santaBudget = santaBudget;
    }

    public List<Child> getChildren() {
        return children;
    }

//    public List<Child> getGiftedChildren() {
//        return giftedChildren;
//    }

    public List<InputGift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public List<InputAnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    @Override
    public String toString() {
        return "{" +
                "children=" + children +
                '}';
    }
}