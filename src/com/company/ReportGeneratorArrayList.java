package com.company;

import com.company.business.GoodPriceSummary;

import java.util.ArrayList;
import java.util.Date;

public class ReportGeneratorArrayList {

    private static ArrayList<GoodPriceSummary> goodPrices = null;

    public ReportGeneratorArrayList() {
        goodPrices = new ArrayList<>();
    }

    public void addGoodPriceToArrayList(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {

        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.add(goodPrice);

    }

    public static float getOpen() {
        return goodPrices.get(0).getOpenPrice();
    }

    public static float getClose() {
        return goodPrices.get(goodPrices.size()-1).getClosePrice();
    }
}
