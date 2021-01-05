package com.company;

import com.company.business.GoodPriceSummary;

import java.util.ArrayList;
import java.util.Date;

public class ReportGeneratorArrayList {

    // remettre en private pour la version finale
    // goodPrices doit être en public pour pouvoir afficher le nombre de lignes dans le Gui
    public static ArrayList<GoodPriceSummary> goodPrices = null;

    public ReportGeneratorArrayList() {
        goodPrices = new ArrayList<>();
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {

        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.add(goodPrice);
    }

    public static float getOpen() {
        return goodPrices.get(0).getOpenPrice();
    }

    public static float getClose() {
        return goodPrices.get(goodPrices.size()-1).getClosePrice();
    }

    public static float getHighest(){
        float highest = 0;
        for (int i=0; i < goodPrices.size(); i++){
            if (highest < goodPrices.get(i).getHighestPrice()){
                highest = goodPrices.get(i).getHighestPrice();
            }
        }
        return highest;
    }

    public static float getLowest(){
        float lowest = goodPrices.get(0).getLowestPrice();
        for (int i=1; i< goodPrices.size(); i++){
            if ( lowest > goodPrices.get(i).getLowestPrice()){
                lowest = goodPrices.get(i).getLowestPrice();
            }
        }
        return lowest;
    }
}
