package fileio;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.List;

public final class InputChild {

    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private Cities city;
    private double niceScore;
    private List<Category> giftsPreferences;
    private double niceScoreBonus;
    private ElvesType elf;

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public void setNiceScoreBonus(final double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

}
