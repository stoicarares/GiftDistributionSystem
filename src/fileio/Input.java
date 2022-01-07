package fileio;

import java.util.ArrayList;
import java.util.List;

public final class Input {
    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData = new InitialData();
    private ArrayList<InputAnnualChange> annualChanges = new ArrayList<>();

    public List<InputAnnualChange> getAnnualChanges() {
        return annualChanges;
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

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public void setAnnualChanges(final ArrayList<InputAnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
