package com.company.business;

import com.company.goods.GoodPriceSummary;

import java.util.ArrayList;
import java.util.Date;

public class ReportGeneratorArrayList extends AbstractReportGenerator{

    // remettre en private pour la version finale
    // goodPrices doit être en public pour pouvoir afficher le nombre de lignes dans le Gui
    public static ArrayList<GoodPriceSummary> goodPrices = null;

    public ReportGeneratorArrayList() {
        //reinitialise les variables lorsqu'on appuie sur le bouton rapport, pour ne pas interferer avec les anciennes valeurs
        goodPrices = new ArrayList<>();
        super.highestPrice = 0;
        super.lowestPrice = Float.MAX_VALUE;
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.add(goodPrice);
    }

    @Override
    public void getReport() {
        getOpen();
        getClose();
        for (int i=0; i< goodPrices.size(); i++) {
            getHighest(i);
            getLowest(i);
        }
    }

    @Override
    public void getOpen() {
        super.openPrice = goodPrices.get(0).getOpenPrice();
    }

    @Override
    public void getClose() {
        super.closePrice = goodPrices.get(goodPrices.size()-1).getClosePrice();
    }

    public void getHighest(int i){
        if (super.highestPrice < goodPrices.get(i).getHighestPrice()){
            super.highestPrice = goodPrices.get(i).getHighestPrice();
        }
    }

    public void getLowest(int i){
        if ( super.lowestPrice > goodPrices.get(i).getLowestPrice()){
            super.lowestPrice = goodPrices.get(i).getLowestPrice();
        }
    }
}
