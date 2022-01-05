package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public final class InitialData {
    private List<InputChild> children;
    private List<InputGift> santaGiftsList;

    public List<InputChild> getChildren() {
        return children;
    }

    public List<InputGift> getSantaGiftsList() {
        return santaGiftsList;
    }
}
