package fileio;

import enums.CityStrategyEnum;

import java.util.List;

public final class InputAnnualChange {
    private Double newSantaBudget;
    private List<InputGift> newGifts;
    private List<InputChild> newChildren;
    private List<InputChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

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

    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public void setNewGifts(final List<InputGift> newGifts) {
        this.newGifts = newGifts;
    }

    public void setNewChildren(final List<InputChild> newChildren) {
        this.newChildren = newChildren;
    }

    public void setChildrenUpdates(final List<InputChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
