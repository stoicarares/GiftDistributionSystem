package fileio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.List;

public final class Child {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private List<Category> giftsPreferences = new ArrayList<>();
    private Double averageScore;
    private double niceScoreBonus;
    private ElvesType elf;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private List<InputGift> receivedGifts = new ArrayList<>();


    public Child(final Integer id, final String lastName, final String firstName,
                 final Integer age, final Cities city, final List<Category> giftsPreferences,
                 final Double averageScore, final Double niceScoreBonus, final ElvesType elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory.add(averageScore);
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    /**
     * Constructor helping me at deep copy in forming the output
     * @param child The new child formed
     */
    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.age = child.age;
        this.city = child.city;
        this.averageScore = child.averageScore;
        this.assignedBudget = child.assignedBudget;
    }

    public void giveNiceScoreBonus() {
        averageScore += averageScore * niceScoreBonus / 100;
        if (averageScore > 10.0) {
            averageScore = 10.0;
        }
    }

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

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<InputGift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<InputGift> receivedGifts) {
        this.receivedGifts = receivedGifts;
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

    public void setCity(final Cities city) {
        this.city = city;
    }

    public double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setNiceScoreBonus(final double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city=" + city +
                ", age=" + age +
                ", giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreBonus=" + niceScoreBonus +
                ", elf=" + elf +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +
                ", receivedGifts=" + receivedGifts +
                '}';
    }
}
