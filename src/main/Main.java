package main;

import Command.Command;
import Command.Invoker;
import Command.SetAssignedBudgetCommand;
import Command.IncreaseAgeCommand;
import Command.EliminateYoungAdultsCommand;
import Command.GiftDistributionCommand;
import checker.Checker;
import common.Constants;
import entertainment.Child;
import entertainment.Database;
import entertainment.ScoreStrategy;
import entertainment.ScoreStrategyFactory;
import fileio.Input;
import fileio.InputAnnualChange;
import fileio.InputReader;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(String[] args) throws IOException {
        File directory = new File("./tests");
        Path path = Paths.get("output");
        if(!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File("output");

        action("./tests/tes16.json", "dadwa");
//        for (File file : Objects.requireNonNull(directory.listFiles())) {
//            String filepath = Constants.OUTPUT_PATH + file.getName();
//            File out = new File(filepath);
//            boolean isCreated = out.createNewFile();
//            if (isCreated) {
//                action(file.getAbsolutePath(), filepath);
//            }
//        }
//        Checker.calculateScore();
    }
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        InputReader inputReader = new InputReader("./tests/test2.json");
        Input input = null;
        try {
            input = inputReader.readInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert input != null;

//        Database.getDatabase().transferSantaBudgets(input.getAnnualChanges(), input.getSantaBudget());
        Database.getDatabase().transferChildren(input.getInitialData().getChildren());
        Database.getDatabase().transferGifts(input.getInitialData().getSantaGiftsList());
        Database.getDatabase().transferAnnualChanges(input.getAnnualChanges());
        Database.setSantaBudget(input.getSantaBudget());

        for (Child child : Database.getDatabase().getChildren()) {
            ScoreStrategyFactory factory = new ScoreStrategyFactory();
            ScoreStrategy strategy = factory.createStrategy(child);
            strategy.getChildAverageScore(child);
        }

//        System.out.println(input);
//        System.out.println(input.getAnnualChanges());
        System.out.println(Database.getSantaBudget());
//        System.out.println(Database.getDatabase().getChildren());
        Invoker invoker = new Invoker();
        invoker.execute(new SetAssignedBudgetCommand());
//        invoker.execute(new IncreaseAgeCommand());
        invoker.execute(new EliminateYoungAdultsCommand());
        invoker.execute(new GiftDistributionCommand());
//        Database.getDatabase().setChildrenBudget();
        System.out.println(Database.getDatabase().getChildren());


        for (InputAnnualChange annualChange : input.getAnnualChanges()) {
            invoker.execute(new IncreaseAgeCommand());
            invoker.execute(new EliminateYoungAdultsCommand());

            Database.setSantaBudget(annualChange.getNewSantaBudget());
//            Pune new children
//            Pune children Updates
            for (Child child : Database.getDatabase().getChildren()) {
                ScoreStrategyFactory factory = new ScoreStrategyFactory();
                ScoreStrategy strategy = factory.createStrategy(child);
                strategy.getChildAverageScore(child);
            }

            invoker.execute(new SetAssignedBudgetCommand());
            invoker.execute(new GiftDistributionCommand());
            System.out.println(Database.getDatabase().getChildren());
//            System.out.println(annualChange.getNewSantaBudget());
        }
    }
}
