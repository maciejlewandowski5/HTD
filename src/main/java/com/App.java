package com;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    int[] tab;

    final static int YEAR1800 = 81;
    final static int YEAR1899 = 92;
    final static int YEAR1900 = 01;
    final static int YEAR1999 = 12;
    final static int YEAR2000 = 21;
    final static int YEAR2099 = 32;
    final static int YEAR2100 = 41;
    final static int YEAR2199 = 52;
    final static int YEAR2200 = 62;
    final static int YEAR2299 = 72;

    public App(int[] tab) {


    }

    public static void main(String[] args) {

        try {
            CoinDivider coinDivider = new CoinDivider(3);

            coinDivider.setNumberOfCoins2(1);
            coinDivider.setNumberOfCoins1(2);
            coinDivider.setNumberOfCoins05(5);
            coinDivider.setNumberOfCoins02(3);
            coinDivider.setNumberOfCoins01(3);
            coinDivider.setNumberOfCoins005(4);
            coinDivider.setNumberOfCoins002(1);
            coinDivider.setNumberOfCoins001(2);


            System.out.println("Total sum: " + coinDivider.getSumOfRest());
            System.out.println();

            List<Map<Double, Integer>> rests = coinDivider.calculateListsOfRests();


            int i = 0;
            for (Map<Double, Integer> value : rests) {
                System.out.println("Person num: " + i);
                System.out.println("sum: " + coinDivider.calculateSum(value));
                System.out.println("list of coins: " + value);
                System.out.println();
                i++;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    private static String info(String pesel) {

        String year = pesel.substring(0, 2);

        Integer month = Integer.valueOf(pesel.substring(2, 4));

        int sex = Integer.valueOf(pesel.charAt(9));

        String sexString = "Mężczyzna";

        String day = pesel.substring(4, 6);

        if (checkSex(sex)) {
            sexString = "Kobieta";
        }

        if (month >= YEAR1800 && month <= YEAR1899) {

            year = concatYear(year, "19");
            month = calculateMonth(month, 80);

        } else if (month >= YEAR1900 && month < YEAR1999) {
            //1900
            year = concatYear(year, "19");
            month = calculateMonth(month, 0);

        } else if (month >= YEAR2000 && month <= YEAR2099) {
            //2000
            year = concatYear(year, "20");
            month = calculateMonth(month, 20);

        } else if (month >= YEAR2100 && month <= 52) {

            year = concatYear(year, "19");
            month = calculateMonth(month, 40);

            //2100
        } else if (month >= 61 && month <= 72) {

            year = concatYear(year, "19");
            month = calculateMonth(month, 60);
            //2200
        }

        return sexString + ", Data ur:" + day + "." + month + "." + year;

    }

    private static boolean checkSex(int sex) {
        return sex % 2 == 0;
    }

    private static int calculateMonth(Integer month, int i) {
        return month = month - i;
    }

    private static String concatYear(String year, String s) {
        return year = s + year;
    }
}
