package com.company.business;

import com.company.goods.GoodPriceSummary;

import java.sql.Timestamp;
import java.util.*;

public class ReportGeneratorHashMap extends AbstractReportGenerator {
    private static HashMap<Date, GoodPriceSummary> goodPrices = null;
    // variable pour getOpen
    Timestamp stampGetOpen = new Timestamp(System.currentTimeMillis() * 1000);
    Date firstDate;
    //variable pour getClose
    Timestamp stampGetClose = new Timestamp(0);
    Date lastDate;

    public ReportGeneratorHashMap() {
        //reinitialise les variables lorsqu'on appuie sur le bouton rapport, pour ne pas interferer avec les anciennes valeurs
        goodPrices = new HashMap<>(101);
        firstDate = new Date(stampGetOpen.getTime());
        lastDate = new Date(stampGetClose.getTime());
        super.highestPrice = 0;
        super.lowestPrice = Float.MAX_VALUE;
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.put(date,goodPrice);
    }

    //cette methode est cree pour eviter de faire 4 fois la meme boucle dans chaque methode de calcul, ainsi gagner en rapidite
    @Override
    public void getReport() {

        //boucle sur toutes "lignes de données" et appel les 4 methodes
        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            getOpen(entry.getKey());
            getClose(entry.getKey());
            getHighest(entry.getValue().getHighestPrice());
            getLowest(entry.getValue().getLowestPrice());
        }
        //attribue les resultats aux variables static
        super.openPrice = goodPrices.get(firstDate).getOpenPrice();
        super.closePrice = goodPrices.get(lastDate).getClosePrice();
    }

    public void getOpen(Date key) {
        if ((firstDate.compareTo(key)) > 0) {
            firstDate = key;
        }
    }

    public void getClose(Date key ) {
        if ((lastDate.compareTo(key)) < 0) {
            lastDate = key;
        }
    }

    public void getHighest(float highestPriceValue) {
        if (highestPriceValue > super.highestPrice) {
            super.highestPrice = highestPriceValue;
        }
    }

    public void getLowest(float lowestPriceValue) {
        if (lowestPriceValue < super.lowestPrice) {
            super.lowestPrice = lowestPriceValue;
        }
    }
}
