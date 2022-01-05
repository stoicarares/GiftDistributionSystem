package fileio;

import java.util.List;

public final class InputAnnualChange {
    private Double newSantaBudget;
    private List<InputGift> newGifts;
    private List<InputChild> newChildren;
    private List<InputChildUpdate> childrenUpdates;

    public InputAnnualChange() {

    }

    public InputAnnualChange(final Double newSantaBudget, final List<InputGift> newGifts,
                             final List<InputChild> newChildren,
                             final List<InputChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<InputGift> getNewGifts() {
        return newGifts;
    }

    public List<InputChild> getNewChildren() {
        return newChildren;
    }

    public List<InputChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    @Override
    public String toString() {
        return "InputAnnualChange{" +
<<<<<<< HEAD
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }
}
=======
            "newSantaBudget=" + newSantaBudget +
            ", newGifts=" + newGifts +
            ", newChildren=" + newChildren +
            ", childrenUpdates=" + childrenUpdates +
            '}';
    }
}
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
