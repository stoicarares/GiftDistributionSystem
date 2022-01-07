package fileio;

import enums.Category;

import java.util.List;

public final class InputChildUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftsPreferences;

    public InputChildUpdate() {

    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Integer getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
