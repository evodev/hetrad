package com.company.business;


public abstract class AbstractReportGenerator implements ReportGenerator {
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

    @Override
    public float getOpenPrice() {
        return openPrice;
    }

    @Override
    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    @Override
    public float getClosePrice() {
        return closePrice;
    }

    @Override
    public void setClosePrice(float closePrice) {
        this.closePrice = closePrice;
    }

    @Override
    public float getHighestPrice() {
        return highestPrice;
    }

    @Override
    public void setHighestPrice(float highestPrice) {
        this.highestPrice = highestPrice;
    }

    @Override
    public float getLowestPrice() {
        return lowestPrice;
    }

    @Override
    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
}
