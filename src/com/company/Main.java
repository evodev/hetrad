package com.company;


import com.company.gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        /*
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
         */

        JFrame frame = new JFrame("HE-Trade");
        frame.setContentPane(new Gui().jp_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 450));
        frame.pack();
        frame.setVisible(true);

    }



}
