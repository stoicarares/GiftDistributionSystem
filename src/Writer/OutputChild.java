package writer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import fileio.Child;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.List;

public class OutputChild {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private List<Category> giftsPreferences = new ArrayList<>();
    private Double averageScore;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private List<OutputGift> receivedGifts = new ArrayList<>();

    public OutputChild(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.averageScore = child.getAverageScore();
        this.assignedBudget = child.getAssignedBudget();
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

    public List<OutputGift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final List<OutputGift> receivedGifts) {
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
}
