package com.company.business;

import com.company.goods.GoodPriceSummary;

import java.util.ArrayList;
import java.util.Date;

public class ReportGeneratorArrayList extends AbstractReportGenerator{

    private ArrayList<GoodPriceSummary> goodPrices;

    public ReportGeneratorArrayList() {
        //reinitialise la ArrayList lorsqu'on appuie sur le bouton rapport, pour ne pas interferer avec les anciennes valeurs
        goodPrices = new ArrayList<>();
    }

    @Override
    public void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        GoodPriceSummary goodPrice = new GoodPriceSummary(date, volume, highestPrice, lowestPrice, openPrice, closePrice);
        goodPrices.add(goodPrice);
    }

    @Override
    public void getReport() {
        setOpen();
        setClose();
        for (int i=0; i< goodPrices.size(); i++) {
            setHighest(i);
            setLowest(i);
        }
    }

    public void setOpen() {
        setOpenPrice(goodPrices.get(0).getOpenPrice());
    }

    public void setClose() {
        setClosePrice(goodPrices.get(goodPrices.size()-1).getClosePrice());
    }

    public void setHighest(int i){
        if (getHighestPrice() < goodPrices.get(i).getHighestPrice()){
            setHighestPrice(goodPrices.get(i).getHighestPrice());
        }
    }

    public void setLowest(int i){
        if ( getLowestPrice() > goodPrices.get(i).getLowestPrice()){
            setLowestPrice(goodPrices.get(i).getLowestPrice());
        }
    }
}
