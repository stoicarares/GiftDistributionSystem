package main;

import Command.Command;
import Command.Invoker;
import Command.SetAssignedBudgetCommand;
import Command.IncreaseAgeCommand;
import Command.EliminateYoungAdultsCommand;
import Command.GiftDistributionCommand;
import Command.UpdateChildrenCommand;

import checker.Checker;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
import entertainment.Child;
import entertainment.Database;
import entertainment.ScoreStrategy;
import entertainment.ScoreStrategyFactory;
import fileio.Input;
import fileio.InputAnnualChange;
import fileio.InputReader;
import writer.ChildrenOutput;
import writer.Writer;

import Writer.Writer;
import Writer.ChildrenOutput;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
/**
 * Class used to run the code
 @@ -15,7 +49,111 @@ private Main() {
  * @param args
 *          the arguments used to call the main method
 */
<<<<<<< HEAD
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
=======
public static void main(String[] args) throws IOException {
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
        File directory = new File("./tests");
        Path path = Paths.get("output");
        if(!Files.exists(path)) {
        Files.createDirectories(path);
        }

<<<<<<< HEAD
        File outputDirectory = new File("output");

//        action("./tests/tes16.json", "dadwa");
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = Constants.OUTPUT_PATH + file.getName();
            action(file.getAbsolutePath(), filepath);
        }
        Checker.calculateScore();
    }
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
=======
//        action("./tests/tes16.json", "dadwa");
        for (File file : Objects.requireNonNull(directory.listFiles())) {
        String filepath = Constants.OUTPUT_PATH + file.getName();
        action(file.getAbsolutePath(), filepath);
        }
        Checker.calculateScore();
        }
public static void action(final String filePath1,
final String filePath2) throws IOException {
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
        InputReader inputReader = new InputReader(filePath1);
        Input input = null;
        try {
        input = inputReader.readInput();
        } catch (IOException e) {
        e.printStackTrace();
        }
        assert input != null;

        File outFile = new File(filePath2);
<<<<<<< HEAD
        Writer writer = new Writer();
=======

        Writer writer = new Writer();

>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
//        Database.getDatabase().transferSantaBudgets(input.getAnnualChanges(), input.getSantaBudget());
        Database.getDatabase().transferChildren(input.getInitialData().getChildren());
        Database.getDatabase().transferGifts(input.getInitialData().getSantaGiftsList());
        Database.getDatabase().transferAnnualChanges(input.getAnnualChanges());
        Database.setSantaBudget(input.getSantaBudget());

        for (Child child : Database.getDatabase().getChildren()) {
<<<<<<< HEAD
            child.getReceivedGifts().clear();
            ScoreStrategyFactory factory = new ScoreStrategyFactory();
            ScoreStrategy strategy = factory.createStrategy(child);
            strategy.getChildAverageScore(child);
=======
        child.getReceivedGifts().clear();
        ScoreStrategyFactory factory = new ScoreStrategyFactory();
        ScoreStrategy strategy = factory.createStrategy(child);
        strategy.getChildAverageScore(child);
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
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
<<<<<<< HEAD
=======
//        System.out.println(Database.getDatabase().getChildren());
//        System.out.println(Database.getDatabase().getGiftedChildren());
//        writer.getAnnaulChildren().add(new ArrayList<>(Database.getDatabase().getChildren()));
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
        ChildrenOutput childrenOutput = new ChildrenOutput();
        childrenOutput.transferChildren();
        System.out.println("main -> " + childrenOutput.getChildren().get(0));
//        System.out.println("...........");
//        System.out.println(childrenOutput);
        writer.getAnnaulChildren().add(childrenOutput);
        System.out.println("writer -> " + writer.getAnnaulChildren().get(0));
<<<<<<< HEAD



        for (int i = 0; i < input.getNumberOfYears(); i++) {
            invoker.execute(new IncreaseAgeCommand());
            invoker.execute(new EliminateYoungAdultsCommand());

            Database.setSantaBudget(input.getAnnualChanges().get(i).getNewSantaBudget());
//            Pune new children
//            Pune children Updates
            if (input.getAnnualChanges().get(i).getChildrenUpdates() != null)
                invoker.execute(new UpdateChildrenCommand(input.getAnnualChanges().get(i)
                        .getChildrenUpdates()));

            for (Child child : Database.getDatabase().getChildren()) {
                child.getReceivedGifts().clear();
                ScoreStrategyFactory factory = new ScoreStrategyFactory();
                ScoreStrategy strategy = factory.createStrategy(child);
                strategy.getChildAverageScore(child);
            }

            invoker.execute(new SetAssignedBudgetCommand());
            invoker.execute(new GiftDistributionCommand());
=======
//        Database.getDatabase().getGiftedChildren().clear();
//        objectWriter.writeValue(outFile, Database.getDatabase().getChildren());

        for (int i = 0; i < input.getNumberOfYears(); i++) {
        invoker.execute(new IncreaseAgeCommand());
        invoker.execute(new EliminateYoungAdultsCommand());

        Database.setSantaBudget(input.getAnnualChanges().get(i).getNewSantaBudget());
//            Pune new children
//            Pune children Updates
        if (input.getAnnualChanges().get(i).getChildrenUpdates() != null)
        invoker.execute(new UpdateChildrenCommand(input.getAnnualChanges().get(i)
        .getChildrenUpdates()));

        for (Child child : Database.getDatabase().getChildren()) {
        child.getReceivedGifts().clear();
        ScoreStrategyFactory factory = new ScoreStrategyFactory();
        ScoreStrategy strategy = factory.createStrategy(child);
        strategy.getChildAverageScore(child);
        }

        invoker.execute(new SetAssignedBudgetCommand());
        invoker.execute(new GiftDistributionCommand());
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
//            System.out.println(Database.getDatabase().getChildren());
//            System.out.println(Database.getDatabase().getGiftedChildren());
//            Database.getDatabase().getGiftedChildren().clear();
//            writer.getAnnaulChildren().add(new ArrayList<>(Database.getDatabase().getChildren()));
<<<<<<< HEAD
            ChildrenOutput newChildrenOutput = new ChildrenOutput();
            newChildrenOutput.transferChildren();
//            System.out.println(".***********");
//            System.out.println(newChildrenOutput);
            writer.getAnnaulChildren().add(newChildrenOutput);
            System.out.println("writer for -> " + writer.getAnnaulChildren().get(0));
//            System.out.println(annualChange.getNewSantaBudget());
        }
=======
        ChildrenOutput newChildrenOutput = new ChildrenOutput();
        newChildrenOutput.transferChildren();
//            System.out.println(".***********");
//            System.out.println(newChildrenOutput);
        writer.getAnnaulChildren().add(newChildrenOutput);
        System.out.println("writer for -> " + writer.getAnnaulChildren().get(0));
//            objectWriter.writeValue(outFile, Database.getDatabase().getChildren());

//            System.out.println(annualChange.getNewSantaBudget());
        }

>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(outFile, writer);
<<<<<<< HEAD
    }
}
=======
        }

}
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
