package com.company;

import com.company.business.GoodPriceSummary;

import java.util.ArrayList;
import java.util.Date;

public class ReportGeneratorArrayList {

    // remettre en private pour la version finale
    // goodPrices doit être en public pour pouvoir afficher le nombre de lignes dans le Gui
    public static ArrayList<GoodPriceSummary> goodPrices = null;
    public static float openPrice;
    public static float closePrice;
    public static float highestPrice;
    public static float lowestPrice;

    public ReportGeneratorArrayList() {
        goodPrices = new ArrayList<>();
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {

        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.add(goodPrice);
    }

    public void getOpen() {
        openPrice = goodPrices.get(0).getOpenPrice();
    }

    public void getClose() {
        closePrice = goodPrices.get(goodPrices.size()-1).getClosePrice();
    }

    public void getHighest(){
        float highest = 0;
        for (int i=0; i < goodPrices.size(); i++){
            if (highest < goodPrices.get(i).getHighestPrice()){
                highest = goodPrices.get(i).getHighestPrice();
            }
        }
        highestPrice = highest;
    }

    public void getLowest(){
        float lowest = goodPrices.get(0).getLowestPrice();
        for (int i=1; i< goodPrices.size(); i++){
            if ( lowest > goodPrices.get(i).getLowestPrice()){
                lowest = goodPrices.get(i).getLowestPrice();
            }
        }
        lowestPrice = lowest;
    }
}
