package com.company;

import com.company.business.GoodPriceSummary;

import java.sql.Timestamp;
import java.util.*;

public class ReportGeneratorHashMap {
    private static HashMap<Date, GoodPriceSummary> goodPrices = null;

    public ReportGeneratorHashMap() {
        goodPrices = new HashMap<>(101);
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.put(date,goodPrice);
    }

    public static float getOpen() {
        Timestamp stamp = new Timestamp(System.currentTimeMillis() * 1000);
        Date firstDate = new Date(stamp.getTime());

        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            Date key = entry.getKey();

            if ((firstDate.compareTo(key)) > 0) {
                firstDate = key;
            } else if (firstDate.compareTo(key) == 0){
                System.out.println("Erreur dans la réception du JSON Parser, deux dates sont égales dans le JSON parser. Veuillez relancer");
            }
        }
        return goodPrices.get(firstDate).getOpenPrice();
    }

    public static float getClose() {
        Timestamp stamp = new Timestamp(0);
        Date lastDate = new Date(stamp.getTime());

        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            Date key = entry.getKey();

            if ((lastDate.compareTo(key)) < 0) {
                lastDate = key;
            } else if (lastDate.compareTo(key) == 0){
                System.out.println("Erreur dans la réception du JSON Parser, deux dates sont égales dans le JSON parser. Veuillez relancer");
            }
        }
        return goodPrices.get(lastDate).getClosePrice();
    }

    public static float getHighest() {
        float highest = 0;

        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            float highestPriceValue = entry.getValue().getHighestPrice();

            if (highestPriceValue > highest) {
                highest = highestPriceValue;
            }
        }
        return highest;
    }

    public static float getLowest() {
        float lowest = goodPrices.get(goodPrices.keySet().toArray()[0]).getLowestPrice() ;

        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            float lowestPriceValue = entry.getValue().getLowestPrice();

            if (lowestPriceValue < lowest) {
                lowest = lowestPriceValue;
            }
        }
        return lowest;
    }
}
