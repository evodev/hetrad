package com.company;



public class Main {

    public static void main(String[] args) {

        // ID d'une action
        int symbolZoneBourse = 23365019;

        // Nombre de secondes depuis 1970
        int fromTimeStamp = 1;

        int toTimeStamp = 1608382561;

        // Periode de D = day ; 1 = 1 minutes; 3 = 3 minutes
        String period = "D";

        String url = "https://www.zonebourse.com/mods_a/charts/TV/function/history?from=" + fromTimeStamp +
                "&to=" + toTimeStamp + "&symbol=" + symbolZoneBourse + "&resolution=" +  period + "&requestType=GET&src=itfp";

        JsonParser RecupUrl = new JsonParser();
        RecupUrl.addHistory(url);
    }
    //test commit Artur
}
