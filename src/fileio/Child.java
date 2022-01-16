package fileio;

import common.Constants;
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
    private List<Category> giftsPreferences;
    private Double averageScore;
    private double niceScoreBonus;
    private ElvesType elf;
    private List<Double> niceScoreHistory =  new ArrayList<>();
    private Double assignedBudget;
    private List<InputGift> receivedGifts = new ArrayList<>();


    public Child(final Integer id, final String lastName, final String firstName,
                 final Integer age, final Cities city, final List<Category> giftsPreferences,
                 final Double averageScore, final ElvesType elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory.add(averageScore);
        this.elf = elf;
    }

    public static final class Builder {
        private final Integer id;
        private final String lastName;
        private final String firstName;
        private final Cities city;
        private final Integer age;
        private final Double niceScore;
        private final List<Category> giftsPreferences;
        private final ElvesType elf;
        private double niceScoreBonus = 0;

        public Builder(final Integer id, final String lastName, final String firstName,
                       final Cities city, final Integer age, final Double niceScore,
                       final List<Category> giftsPreferences, final ElvesType elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        /**
         * Builder method for adding niceScoreBonus parameter
         * @param bonusNiceScore Double value meaning cild's niceScoreBonus.
         */
        public Builder niceScoreBonusCount(final double bonusNiceScore) {
            this.niceScoreBonus = bonusNiceScore;
            return this;
        }

        /**
         * Builder method for creating a new child
         * @return A new instance of child.
         */
        public Child build() {
            return new Child(this);
        }
    }

    private Child(final Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.niceScoreHistory.add(builder.niceScore);
        this.giftsPreferences = builder.giftsPreferences;
        this.elf = builder.elf;
        this.niceScoreBonus = builder.niceScoreBonus;
    }

    /**
     * Method that gives a niceScoreBonus to a child's average score.
     */
    public void giveNiceScoreBonus() {
        averageScore += averageScore * niceScoreBonus / Constants.HUNDRED;
        if (averageScore > Constants.MAX_AVERAGE_SCORE) {
            averageScore = Constants.MAX_AVERAGE_SCORE;
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

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }
}
