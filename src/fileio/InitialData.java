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

    @Override
    public String toString() {
        return "InitialData{" +
<<<<<<< HEAD
                "children=" + children +
                ", santaGiftsList=" + santaGiftsList +
                '}';
=======
            "children=" + children +
            ", santaGiftsList=" + santaGiftsList +
            '}';
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
    }

    public List<InputGift> getSantaGiftsList() {
        return santaGiftsList;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
