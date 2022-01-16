package gifting;

import database.Database;
import enums.Category;
import enums.Cities;
import fileio.Child;
import fileio.InputGift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DistriburionByNiceScoreCity extends GiftCommand {

    /**
     * Method creating a map of cities containing all childtren living in average scores
     * @return The new formed cities map.
     */
    public Map<Cities, List<Double>> formCitiesMap() {
        Map<Cities, List<Double>> citiesMap = new HashMap<>();
        for (Child child : Database.getDatabase().getChildren()) {
            if (!citiesMap.containsKey(child.getCity())) {
                citiesMap.put(child.getCity(), new ArrayList<>());
            }
            citiesMap.get(child.getCity()).add(child.getAverageScore());
        }

    return citiesMap;
    }

    /**
     * Method creating a map with cities and calculating their average score
     * @param citiesMap Map formed with the above method formCitiesMap().
     * @return The map containing all cities and their average score
     */
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

    /**
     * Method for sorting descendig firstly by cities average score then alphabetical by name.
     * @param citiesAverageScoresMap Map with cities average score formed with
     *                               method getCitiesAverageScores(...)
     * @return A sorted list containg cities names and their average score.
     */
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
        List<Cities> sortedCities = new ArrayList<>();

       for (Map.Entry<Cities, Double> entry : sortedList) {
           sortedCities.add(entry.getKey());
       }
        Map<Category, List<InputGift>> giftMap = buildGiftMap();
        for (Cities city : sortedCities) {
            for (Child child : Database.getDatabase().getChildren()) {
                if (child.getCity().equals(city)) {
                    distributePreferedGifts(child, giftMap);
                }
            }
        }
    }
}
