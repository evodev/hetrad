package com.company.goods;

import java.util.Date;

public class GoodPriceSummary {
    private Date time;
    private float volume;
    private float highestPrice;
    private float lowestPrice;
    private float openPrice;
    private float closePrice;

    public GoodPriceSummary() {
    }

    public GoodPriceSummary(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice) {
        this.time = date;
        this.volume = volume;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
    }

    /* On décide de garder les méthodes non utilisés pour les bests practice et dans le cas d'une suite du projet */
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
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

    @Override
    public String toString() {
        return "GoodPriceSummary{" +
                "time=" + time +
                ", volume=" + volume +
                ", highestPrice=" + highestPrice +
                ", lowestPrice=" + lowestPrice +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                '}';
    }
}
