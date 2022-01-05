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
<<<<<<< HEAD
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", initialData=" + initialData +
                ", annualChanges=" + annualChanges +
                '}';
=======
            "numberOfYears=" + numberOfYears +
            ", santaBudget=" + santaBudget +
            ", initialData=" + initialData +
            ", annualChanges=" + annualChanges +
            '}';
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
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

<<<<<<< HEAD
}
=======
}
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
