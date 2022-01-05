package fileio;

import java.util.List;

public class Input {
    private int numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private List<InputAnnualChange> annualChanges;

    public List<InputAnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    @Override
    public String toString() {
        return "Input{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
    }


    public int getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

}