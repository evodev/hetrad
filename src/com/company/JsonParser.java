package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.Date;

public class JsonParser {

    public JsonParser () {
    }

    public void addHistory(String pUrl) {
        JSONParser parser = new JSONParser();
        ReportGeneratorArrayList reportGeneratorArrayList = new ReportGeneratorArrayList();


        try {
            // récupération URL de l'API
            URL oracle = new URL(pUrl); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            // Place les données en JSON dans la variable obj
            String inputLine;
            inputLine = in.readLine();
            Object obj = parser.parse(inputLine);

            //créer un JSON objet
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray times = (JSONArray) jsonObject.get("t");
            JSONArray volumes = (JSONArray) jsonObject.get("v");
            JSONArray highestPrices = (JSONArray) jsonObject.get("h");
            JSONArray lowestPrices = (JSONArray) jsonObject.get("l");
            JSONArray openPrices = (JSONArray) jsonObject.get("o");
            JSONArray closePrices = (JSONArray) jsonObject.get("c");


            // boucle pour chaque "ligne" des données récupérées
            for(int i=0;i<closePrices.size();i++){
                Long time = (Long) times.get(i);
                Long volume = (Long) volumes.get(i);
                Double highestPrice = toDouble(highestPrices.get(i));
                Double lowestPrice = toDouble(lowestPrices.get(i));
                Double openPrice = toDouble(openPrices.get(i));
                Double closePrice = toDouble(openPrices.get(i));


                // timestamp 0 = 01.01.1970 à 00h00 00second
                // timestamp 1 = 01.01.1970 à 00h00 01second
                time = time * 1000; //car Timestamp prend en compte les millisecondes également
                Timestamp stamp = new Timestamp(time);
                Date date = new Date(stamp.getTime());

                reportGeneratorArrayList.addGoodPriceToArrayList(date, volume.floatValue(), highestPrice.floatValue(), lowestPrice.floatValue(), openPrice.floatValue(), closePrice.floatValue());

            }

        in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addLatest(String url){
    }

    private static Double toDouble (Object object){
        Double value = null;
        if (object instanceof Double){
            value = (Double) object;
        }
        else if (object instanceof Long) {
            value = ((Long) object).doubleValue();
        }
        return value;
    }
}
