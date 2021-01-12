package com.company.business;

import java.util.Date;

public abstract class AbstractReportGenerator {
    protected float openPrice;
    protected float closePrice;
    protected float highestPrice;
    protected float lowestPrice;

    //réinitialise toutes les variables (setOpenPrice et setClosePrice ne sont pas nécessaires)
    //pour ne pas interferer avec les anciennes valeurs
    public AbstractReportGenerator() {
        setOpenPrice(0);
        setClosePrice(0);
        setHighestPrice(0);
        setLowestPrice(Float.MAX_VALUE);
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(float closePrice) {
        this.closePrice = closePrice;
    }

    public float getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(float highestPrice) {
        this.highestPrice = highestPrice;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public abstract void getReport();

    public abstract void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice);


}
