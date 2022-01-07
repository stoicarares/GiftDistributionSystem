package main;

import command.Invoker;
import command.SetAssignedBudgetCommand;
import command.IncreaseAgeCommand;
import command.EliminateYoungAdultsCommand;
import command.GiftDistributionCommand;
import command.UpdateChildrenCommand;
import command.UpdateNewChildrenCommand;
import command.UpdateNewGiftsCommand;

import checker.Checker;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
import fileio.Child;
import database.Database;
import strategy.ScoreStrategy;
import strategy.ScoreStrategyFactory;
import fileio.Input;
import fileio.InputReader;

import writer.Writer;
import writer.ChildrenOutput;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * Class used to run the code
     @@ -15,7 +49,111 @@ private Main() {
      * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File("./tests");
        Path path = Paths.get("output");

        if (!Files.exists(path)) {
        Files.createDirectories(path);
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = Constants.OUTPUT_PATH + file.getName();
            action(file.getAbsolutePath(), filepath);
        }
        Checker.calculateScore();
    }

    /**
     * Additional function that resolve the simulation flow
     * @param filePath1 The input file
     * @param filePath2 The output file
     * @throws IOException
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        InputReader inputReader = new InputReader(filePath1);
        Input input = new Input();

        try {
            input = inputReader.readInput();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outFile = new File(filePath2);
        Writer writer = new Writer();
        Invoker invoker = new Invoker();


        assert input != null;
        Database.getDatabase().transferChildren(input.getInitialData().getChildren());
        Database.getDatabase().transferGifts(input.getInitialData().getSantaGiftsList());
        Database.setSantaBudget(input.getSantaBudget());


        for (int i = 0; i <= input.getNumberOfYears(); i++) {
            invoker.execute(new EliminateYoungAdultsCommand());

            if (i != 0) {
                Database.setSantaBudget(input.getAnnualChanges().get(i - 1).getNewSantaBudget());
                if (input.getAnnualChanges().get(i - 1).getChildrenUpdates() != null) {
                    invoker.execute(new UpdateChildrenCommand(input.getAnnualChanges().get(i - 1)
                            .getChildrenUpdates()));
                }
                invoker.execute(new UpdateNewChildrenCommand(input.getAnnualChanges().get(i - 1)
                                .getNewChildren()));
                invoker.execute(new UpdateNewGiftsCommand(input.getAnnualChanges().get(i - 1)
                                .getNewGifts()));
            }

            for (Child child : Database.getDatabase().getChildren()) {
                child.getReceivedGifts().clear();
                ScoreStrategyFactory factory = new ScoreStrategyFactory();
                ScoreStrategy strategy = factory.createStrategy(child);
                strategy.getChildAverageScore(child);
            }

            invoker.execute(new SetAssignedBudgetCommand());
            invoker.execute(new GiftDistributionCommand());

            ChildrenOutput newChildrenOutput = new ChildrenOutput();
            newChildrenOutput.transferChildren();
            writer.getAnnaulChildren().add(newChildrenOutput);

            invoker.execute(new IncreaseAgeCommand());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(outFile, writer);
    }
}
