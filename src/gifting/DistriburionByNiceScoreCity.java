package gifting;

import com.fasterxml.jackson.databind.JsonSerializable;
import database.Database;
import enums.Category;
import enums.Cities;
import fileio.Child;
import fileio.InputGift;

import java.util.*;

public class DistriburionByNiceScoreCity extends GiftCommand {
    public Map<Cities, List<Double>> formCitiesMap() {
        Map<Cities, List<Double>> citiesMap = new LinkedHashMap<>();
        for (Child child : Database.getDatabase().getChildren()) {
            if (!citiesMap.containsKey(child.getCity())) {
                citiesMap.put(child.getCity(), new ArrayList<>());
            }
            citiesMap.get(child.getCity()).add(child.getAverageScore());
        }

    return citiesMap;
    }

    public Map<Cities, Double> getCitiesAverageScores(final Map<Cities, List<Double>> citiesMap) {
        Map<Cities, Double> citiesAverageScoresMap = new HashMap<>();
        for (Map.Entry<Cities, List<Double>> entry : citiesMap.entrySet()) {
            double average = 0.0;
            for (Double score : entry.getValue()) {
                average += score;
            }

            average /= entry.getValue().size();
            citiesAverageScoresMap.put(entry.getKey(), average);
        }

        return citiesAverageScoresMap;
    }

    public List<Map.Entry<Cities, Double>> mySort(
            final Map<Cities, Double> citiesAverageScoresMap) {
        List<Map.Entry<Cities, Double>> sortedList = new ArrayList<>(citiesAverageScoresMap
                                                                    .entrySet());
        sortedList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().toString().compareTo(o2.getKey().toString());
            }

            return o2.getValue().compareTo(o1.getValue());
        });

        return sortedList;
    }

    @Override
    public void execute() {
        Map<Cities, List<Double>> citiesMap = formCitiesMap();
        Map<Cities, Double> citiesAverageScoresMap = getCitiesAverageScores(citiesMap);
        List<Map.Entry<Cities, Double>> sortedList = mySort(citiesAverageScoresMap);

        System.out.println("ADwdawdadwa------");
        List<Cities> sortedCities = new ArrayList<>();
       for (Map.Entry<Cities, Double> entry : sortedList) {
           System.out.println(entry.getKey() + "  " + entry.getValue());
           sortedCities.add(entry.getKey());
       }
        System.out.println("iiiiiiiiiiiiii\n");
        System.out.println(sortedCities + "\n");
        Map<Category, List<InputGift>> giftMap = buildGiftMap();
        for (Cities city : sortedCities) {
            for (Child child : Database.getDatabase().getChildren()) {
                if (child.getCity().equals(city)) {
                    double childBudget = child.getAssignedBudget();
                    for (Category category : child.getGiftsPreferences()) {
                        if (giftMap.containsKey(category) && giftMap.get(category).size() != 0) {
                            List<InputGift> giftList = giftMap.get(category);
                            giftList.removeIf(gift -> gift.getQuantity() <= 0);
                            InputGift cheapestGift = getCheapest(giftList);
                            if (cheapestGift != null
                                    && !child.getReceivedGifts().contains(cheapestGift)) {
                                if ((childBudget - cheapestGift.getPrice()) > 0) {
                                    child.getReceivedGifts().add(cheapestGift);
                                    childBudget -= cheapestGift.getPrice();
//                            System.out.println("555555\n" + category + ":\n" + giftList);
//                                    if (cheapestGift.getQuantity())
                                    if (cheapestGift.getQuantity() > 0)
                                        cheapestGift.setQuantity(cheapestGift.getQuantity() - 1);
//                                    if (cheapestGift.getQuantity() == 0) {
//                                        giftList.remove(cheapestGift);
//                                        Database.getDatabase().getSantaGiftsList().remove(cheapestGift);
//                                    }
//                            System.out.println(giftList +  "\n66666");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
