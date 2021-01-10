package com.company;

import com.company.business.GoodPriceSummary;

import java.sql.Timestamp;
import java.util.*;

public class ReportGeneratorHashMap {
    private static HashMap<Date, GoodPriceSummary> goodPrices = null;
    public static float openPrice;
    public static float closePrice;
    public static float highestPrice;
    public static float lowestPrice;

    public ReportGeneratorHashMap() {
        goodPrices = new HashMap<>(101);
    }

    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.put(date,goodPrice);
    }

    //cette methode est cree pour eviter de faire 4 fois la meme boucle dans chaque methode de calcul, ainsi gagner en rapidite
    public void getCalcul() {
        // variable pour getOpen
        Timestamp stampGetOpen = new Timestamp(System.currentTimeMillis() * 1000);
        Date firstDate = new Date(stampGetOpen.getTime());
        //variable pour getClose
        Timestamp stampGetClose = new Timestamp(0);
        Date lastDate = new Date(stampGetClose.getTime());
        //variable pour getHighest
        float theHighest = 0;
        //variable pour getLowest
        //prend un lowestprice aleatoire pour le comparer aux autres valeurs
        float theLowest = Float.MAX_VALUE ;

        //boucle sur toutes "lignes de données" et appel les 4 methodes
        for(Map.Entry<Date, GoodPriceSummary> entry : goodPrices.entrySet()) {
            firstDate = getOpen(firstDate, entry.getKey());
            lastDate = getClose(lastDate, entry.getKey());
            theHighest = getHighest(theHighest, entry.getValue().getHighestPrice());
            theLowest = getLowest(theLowest, entry.getValue().getLowestPrice());

        }
        //attribue les resultats aux variables static
        openPrice = goodPrices.get(firstDate).getOpenPrice();
        closePrice = goodPrices.get(lastDate).getClosePrice();
        highestPrice = theHighest;
        lowestPrice = theLowest;
    }

    public Date getOpen(Date firstDate, Date key) {
        if ((firstDate.compareTo(key)) > 0) {
            firstDate = key;
        }
        return firstDate;
    }

    public Date getClose(Date lastDate, Date key ) {
        if ((lastDate.compareTo(key)) < 0) {
            lastDate = key;
        } else if (lastDate.compareTo(key) == 0){
            System.out.println("Erreur dans la réception du JSON Parser, deux dates sont égales dans le JSON parser. Veuillez relancer");
        }
        return lastDate;
    }

    public float getHighest(float theHighest, float highestPriceValue) {
        if (highestPriceValue > theHighest) {
            theHighest = highestPriceValue;
        }
        return theHighest;
    }

    public float getLowest(float theLowest, float lowestPriceValue) {

        if (lowestPriceValue < theLowest) {
            theLowest = lowestPriceValue;
        }
        return theLowest;
    }
}
