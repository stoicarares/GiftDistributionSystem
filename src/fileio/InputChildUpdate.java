package fileio;

import enums.Category;

import java.util.List;

public final class InputChildUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftsPreferences;

    public Integer getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    @Override
    public String toString() {
        return "InputChildUpdate{" +
                "id=" + id +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences.toString() +
                '}';
    }
}