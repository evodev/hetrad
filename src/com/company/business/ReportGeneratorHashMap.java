package com.company.business;

import com.company.goods.GoodPriceSummary;

import java.sql.Timestamp;
import java.util.*;

public class ReportGeneratorHashMap extends AbstractReportGenerator {

    private HashMap<Date, GoodPriceSummary> goodPrices;
    // variable pour getOpen
    private Timestamp stampGetOpen = new Timestamp(System.currentTimeMillis() * 1000);
    private Date firstDate;
    //variable pour getClose
    private Timestamp stampGetClose = new Timestamp(0);
    private Date lastDate;

    public ReportGeneratorHashMap() {
        //reinitialise les variables lorsqu'on appuie sur le bouton rapport, pour ne pas interferer avec les anciennes valeurs
        goodPrices = new HashMap<>(101);
        firstDate = new Date(stampGetOpen.getTime());
        lastDate = new Date(stampGetClose.getTime());

    }
    @Override
    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.put(date,goodPrice);
    }

    //cette methode est cree pour eviter de faire 4 fois la meme boucle dans chaque methode de calcul, ainsi gagner en rapidite
    @Override
    public void getReport() {

        //boucle sur toutes "lignes de données" et appel les 4 methodes
        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            setOpenDate(entry.getKey());
            setCloseDate(entry.getKey());
            setHighest(entry.getValue().getHighestPrice());
            setLowest(entry.getValue().getLowestPrice());
        }
        //attribue les resultats aux variables static
        setOpenPrice(goodPrices.get(firstDate).getOpenPrice());
        setClosePrice(goodPrices.get(lastDate).getClosePrice());
    }

    public void setOpenDate(Date key) {
        if ((firstDate.compareTo(key)) > 0) {
            firstDate = key;
        }
    }

    public void setCloseDate(Date key ) {
        if ((lastDate.compareTo(key)) < 0) {
            lastDate = key;
        }
    }

    public void setHighest(float highestPriceValue) {
        if (highestPriceValue > getHighestPrice()) {
            setHighestPrice(highestPriceValue);
        }
    }

    public void setLowest(float lowestPriceValue) {
        if (lowestPriceValue < getLowestPrice()) {
            setLowestPrice(lowestPriceValue);
        }
    }
}
