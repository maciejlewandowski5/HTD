package com;

import java.util.*;

public class CoinDivider {


    private final Map<Double, Integer> rest;
    private double limit;
    private final int numberOfPeople;

    private final Double COIN2 = 2d;
    private final Double COIN1 = 1d;
    private final Double COIN05 = 0.5d;
    private final Double COIN02 = 0.2d;
    private final Double COIN01 = 0.1d;
    private final Double COIN005 = 0.05d;
    private final Double COIN002 = 0.02d;
    private final Double COIN001 = 0.01d;


    public CoinDivider(int numberOfPeople) throws IllegalArgumentException {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException("Number of people must be bigger than zero");
        }
        this.rest = new HashMap<>();
        this.numberOfPeople = numberOfPeople;
        rest.put(COIN2, 0);
        rest.put(COIN1, 0);
        rest.put(COIN05, 0);
        rest.put(COIN02, 0);
        rest.put(COIN01, 0);
        rest.put(COIN005, 0);
        rest.put(COIN002, 0);
        rest.put(COIN001, 0);
        limit = calculateSum(rest) / numberOfPeople;
    }


    List<Map<Double, Integer>> calculateListsOfRests() {
        List<Map<Double, Integer>> rests = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            rests.add(generatePrimaryDivision());
        }

        while (!isThereNoCoinInRest()) {
            Map<Double, Integer> min = Collections.min(rests, Comparator.comparing(this::calculateSum));
            addExtraCoins(min);
        }
        return rests;
    }

    private void addExtraCoins(Map<Double, Integer> min) {
        if (isSpecificCoinInRest(COIN001)) {
            updateRest(min, COIN001);
        } else if (isSpecificCoinInRest(COIN002)) {
            updateRest(min, COIN002);
        } else if (isSpecificCoinInRest(COIN005)) {
            updateRest(min, COIN005);
        } else if (isSpecificCoinInRest(COIN01)) {
            updateRest(min, COIN01);
        } else if (isSpecificCoinInRest(COIN02)) {
            updateRest(min, COIN02);
        } else if (isSpecificCoinInRest(COIN05)) {
            updateRest(min, COIN05);
        } else if (isSpecificCoinInRest(COIN1)) {
            updateRest(min, COIN1);
        } else if (isSpecificCoinInRest(COIN2)) {
            updateRest(min, COIN2);
        }
    }

    private boolean isSpecificCoinInRest(Double coin001) {
        return rest.get(coin001) > 0;
    }

    private boolean isThereNoCoinInRest() {
        for (Map.Entry<Double, Integer> entry : rest.entrySet()) {
            Integer value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


    private Map<Double, Integer> generatePrimaryDivision() {

        Map<Double, Integer> currentRest = new HashMap<>();
        boolean stop = false;

        while (!stop) {
            Double currentSum = calculateSum(currentRest);
            stop = performCoinDivision(currentRest, currentSum);
        }

        return currentRest;
    }

    private boolean performCoinDivision(Map<Double, Integer> currentRest, Double currentSum) {
        if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN2)) {
            updateRest(currentRest, COIN2);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN1)) {
            updateRest(currentRest, COIN1);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN05)) {
            updateRest(currentRest, COIN05);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN02)) {
            updateRest(currentRest, COIN02);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN01)) {
            updateRest(currentRest, COIN01);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN005)) {
            updateRest(currentRest, COIN005);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN002)) {
            updateRest(currentRest, COIN002);
        } else if (isCurrentSumWithCoinBiggerThenLimit(currentSum, COIN001)) {
            updateRest(currentRest, COIN001);
        } else {
            return true;
        }
        return false;
    }

    private boolean isCurrentSumWithCoinBiggerThenLimit(Double currentSum, Double coin) {
        return limit >= currentSum + coin && isSpecificCoinInRest(coin);
    }

    private void updateRest(Map<Double, Integer> subRest, Double coin) {
        subRest.merge(coin, 1, Integer::sum);
        rest.merge(coin, -1, Integer::sum);
    }

    public Double calculateSum(Map<Double, Integer> rest) {
        double sum = 0;
        for (Map.Entry<Double, Integer> entry : rest.entrySet()) {
            Double key = entry.getKey();
            Integer value = entry.getValue();
            sum += key * value;
        }
        return sum;
    }

    public Double getSumOfRest(){
        return calculateSum(rest);
    }


    public void setNumberOfCoins2(int numberOfCoins) {
        rest.put(COIN2, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins1(int numberOfCoins) {
        rest.put(COIN1, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins05(int numberOfCoins) {
        rest.put(COIN05, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins02(int numberOfCoins) {
        rest.put(COIN02, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins01(int numberOfCoins) {
        rest.put(COIN01, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins005(int numberOfCoins) {
        rest.put(COIN005, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins002(int numberOfCoins) {
        rest.put(COIN002, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }

    public void setNumberOfCoins001(int numberOfCoins) {
        rest.put(COIN001, numberOfCoins);
        limit = calculateSum(rest) / numberOfPeople;
    }


}
