package database;

import fileio.Child;
import fileio.InputGift;
import fileio.InputChild;

import java.util.ArrayList;
import java.util.List;

public final class Database {
    private static Double santaBudget = 0.0;
    private final List<Child> children = new ArrayList<>();
    private final List<InputGift> santaGiftsList = new ArrayList<>();

    private static Database database = null;

    private Database() {

    }

    /**
     * Method to form the Singleton and to get access to it.
     * @return The database.
     */
    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    /**
     * Method for transfering the children from the input into the database.
     * @param inputChildren List of children from the input
     */
    public void transferChildren(final List<InputChild> inputChildren) {
        this.children.clear();
        for (InputChild child:inputChildren) {
            Child newChild = new Child(child.getId(), child.getLastName(),
                    child.getFirstName(), child.getAge(),
                    child.getCity(), child.getGiftsPreferences(),
                    child.getNiceScore(), child.getNiceScoreBonus(), child.getElf());
            this.children.add(newChild);
        }
    }

    /**
     * Method for transfering the gifts from the input into the database.
     * @param inputGifts List of gifts from the input
     */
    public void transferGifts(final List<InputGift> inputGifts) {
        this.santaGiftsList.clear();
        for (InputGift gift:inputGifts) {
            InputGift newGift = new InputGift(gift.getProductName(), gift.getPrice(),
                    gift.getCategory(), gift.getQuantity());
            this.santaGiftsList.add(newGift);
        }
    }

    /**
     * Finding a child by his ID
     * @param id The unique child's ID
     * @return The child who has the ID is searched, if found.
     */
    public Child getChildById(final int id) {
        for (Child child:Database.getDatabase().children) {
            if (child.getId().equals(id)) {
                return child;
            }
        }

        return null;
    }
    public static Double getSantaBudget() {
        return santaBudget;
    }

    public static void setSantaBudget(final Double santaBudget) {
        Database.santaBudget = santaBudget;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<InputGift> getSantaGiftsList() {
        return santaGiftsList;
    }
}
