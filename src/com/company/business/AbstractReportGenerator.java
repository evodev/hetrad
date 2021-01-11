package com.company.business;

import java.util.Date;

public abstract class AbstractReportGenerator {
    public static float openPrice;
    public static float closePrice;
    public static float highestPrice;
    public static float lowestPrice;

    public void getReport() {}
    public void getOpen() {}
    //public void getOpen(Date key) {}
    public void getClose() {}
    public void getHighest() {}
    public void getLowest() {}
}
