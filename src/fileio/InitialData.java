package fileio;

import java.util.ArrayList;
import java.util.List;

public final class InitialData {
    private List<InputChild> children = new ArrayList<>();
    private List<InputGift> santaGiftsList = new ArrayList<>();

    public List<InputChild> getChildren() {
        return children;
    }

    public List<InputGift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setChildren(final List<InputChild> children) {
        this.children = children;
    }

    public void setSantaGiftsList(final List<InputGift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
