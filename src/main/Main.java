package main;

import command.Invoker;
import command.SetAssignedBudgetCommand;
import command.IncreaseAgeCommand;
import command.EliminateYoungAdultsCommand;
import enums.CityStrategyEnum;
import gifting.DistriburionByNiceScoreCity;
import gifting.DistributionById;
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
import elves.BlackElf;
import elves.Elf;
import elves.PinkElf;
import elves.YellowElf;
import fileio.Child;
import database.Database;
import gifting.DistributionByNiceScore;
import gifting.Gifter;
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
        Path path = Paths.get(Constants.OUTPUT);

        if (!Files.exists(path)) {
        Files.createDirectories(path);
        }

//        action("./tests/test26.json", "out.txt");

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            File file = new File(Constants.TESTS_PATH + Constants.TEST + i
                                    + Constants.FILE_EXTENSION);
            String filepath = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            try {
                action(file.getAbsolutePath(), filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        Gifter gifter = new Gifter();
        Elf elf = new Elf();


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


            elf.execute(new PinkElf());

            elf.execute(new BlackElf());

//            System.out.println(i);
//            System.out.println(Database.getDatabase().getSantaGiftsList().toString());
            if (i == 0) {
                gifter.execute(new DistributionById());
            } else {
                if (input.getAnnualChanges().get(i - 1).getStrategy().equals(CityStrategyEnum.ID)) {
                    gifter.execute(new DistributionById());
                } else if (input.getAnnualChanges().get(i - 1).getStrategy()
                        .equals(CityStrategyEnum.NICE_SCORE)) {
                    gifter.execute(new DistributionByNiceScore());
                } else if (input.getAnnualChanges().get(i - 1).getStrategy()
                        .equals(CityStrategyEnum.NICE_SCORE_CITY)) {
                    gifter.execute(new DistriburionByNiceScoreCity());
                }
            }
//            System.out.println(Database.getDatabase().getSantaGiftsList().toString());
//            System.out.println();
//            gifter.execute(new DistriburionByNiceScoreCity());

            elf.execute(new YellowElf());
//            System.out.println(Database.getDatabase().getSantaGiftsList().toString());

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
