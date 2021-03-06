package com.company.gui;

import com.company.business.AbstractReportGenerator;
import com.company.business.JsonParser;
import com.company.business.ReportGeneratorArrayList;
import com.company.business.ReportGeneratorHashMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gui {
    public JPanel jp_main;
    private JLabel jl_open;
    private JButton bt_bouton;
    private JComboBox cb_day_start;
    private JComboBox cb_month_start;
    private JComboBox cb_year_start;
    private JComboBox cb_day_end;
    private JComboBox cb_month_end;
    private JComboBox cb_year_end;
    private JLabel jl_idGood;
    private JLabel jl_time_start;
    private JLabel jl_time_end;
    private JComboBox cb_goods;
    private JLabel jl_url;
    private JLabel jl_close;
    private JLabel jl_highest;
    private JLabel jl_lowest;
    private JLabel jl_lignes;
    private JRadioButton rb_arrayList;
    private JRadioButton rb_hashMap;
    private JLabel jl_structure;
    public int goodCode = 4947; // par défaut le code de l'or est sélectionné
    public String dateStart;
    public String dateEnd;
    private boolean choix;

    public Gui() {
        // peupler liste des biens
        cb_goods.addItem("Gold");
        cb_goods.addItem("Silver");
        cb_goods.addItem("Platinum");
        cb_goods.addItem("Palladium");

        // peupler liste des jours
        for (int i = 1; i <= 31; i++){
            String day = String.valueOf(i);
            cb_day_start.addItem(day);
            cb_day_end.addItem(day);
        }
        // peupler liste des années
        for (int i = 1995; i <= 2021; i++){
            String year = String.valueOf(i);
            cb_year_start.addItem(year);
            cb_year_end.addItem(year);
        }

        //peupler liste des mois
        for (int i = 1; i <= 12; i++){
            String month = String.valueOf(i);
            cb_month_start.addItem(month);
            cb_month_end.addItem(month);
        }

        //listener
        bt_bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long millisecondsStart = 0, millisecondsEnd = 0;

                // dates de début et fin en String
                dateStart = cb_day_start.getSelectedItem() + "-" + cb_month_start.getSelectedItem() + "-" + cb_year_start.getSelectedItem();
                dateEnd = cb_day_end.getSelectedItem() + "-" + cb_month_end.getSelectedItem() + "-" + cb_year_end.getSelectedItem();
                //convertir dates String en long
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                try{
                    //date début
                    Date dS = f.parse(dateStart);
                    millisecondsStart = dS.getTime();
                    millisecondsStart = millisecondsStart/1000;
                    jl_time_start.setText(String.valueOf(millisecondsStart));

                    //date fin
                    Date dE = f.parse(dateEnd);
                    millisecondsEnd = dE.getTime();
                    millisecondsEnd = millisecondsEnd/1000;
                    jl_time_end.setText(String.valueOf(millisecondsEnd));

                }catch (ParseException x){
                    x.printStackTrace();
                }

                //tester si valeur date de début est bien avant date de fin
                if (millisecondsEnd < millisecondsStart){
                    JOptionPane.showMessageDialog(null, "La date de début doit se trouver avant la date de fin");
                } else {
                    //un interval de minimum trois jours est nécessaire entre les deux plages horaires
                    if ((millisecondsEnd - millisecondsStart) < 172800){
                        JOptionPane.showMessageDialog(null, "Un interval de minimum trois jours est nécessaire");
                    } else {
                        String url = "https://www.zonebourse.com/mods_a/charts/TV/function/history?from=" + millisecondsStart +
                                "&to=" + millisecondsEnd + "&symbol=" + goodCode + "&resolution=D&requestType=GET&src=itfp";

                        if (rb_arrayList.isSelected()){
                            choix = true;
                        }else{
                            choix = false;
                        }

                        JsonParser RecupUrl = new JsonParser();

                        if (choix){
                            AbstractReportGenerator reportGeneratorArrayList = new ReportGeneratorArrayList();

                            RecupUrl.addHistory(url, reportGeneratorArrayList);

                            jl_open.setText(String.valueOf(reportGeneratorArrayList.getOpenPrice()));
                            jl_close.setText(String.valueOf(reportGeneratorArrayList.getClosePrice()));
                            jl_highest.setText(String.valueOf(reportGeneratorArrayList.getHighestPrice()));
                            jl_lowest.setText(String.valueOf(reportGeneratorArrayList.getLowestPrice()));
                        } else {
                            AbstractReportGenerator reportGeneratorHashMap = new ReportGeneratorHashMap();

                            RecupUrl.addHistory(url, reportGeneratorHashMap);

                            jl_open.setText(String.valueOf(reportGeneratorHashMap.getOpenPrice()));
                            jl_close.setText(String.valueOf(reportGeneratorHashMap.getClosePrice()));
                            jl_highest.setText(String.valueOf(reportGeneratorHashMap.getHighestPrice()));
                            jl_lowest.setText(String.valueOf(reportGeneratorHashMap.getLowestPrice()));
                        }

                    }
                }
            }
        });
        cb_goods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "combo " + cb_goods.getSelectedItem());
                JComboBox cb = (JComboBox)e.getSource();
                String good = (String)cb.getSelectedItem();
                switch (good){
                    case "Gold": jl_idGood.setText(String.valueOf(4947));
                        goodCode = (4947);
                        break;
                    case "Silver": jl_idGood.setText(String.valueOf(16221));
                        goodCode = (16221);
                        break;
                    case "Platinum": jl_idGood.setText(String.valueOf(89083));
                        goodCode = (89083);
                        break;
                    case "Palladium": jl_idGood.setText(String.valueOf(89084));
                        goodCode = (89084);
                        break;
                }
            }
        });
    }
    class Item
    {
        private int id;
        private String description;

        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public int getId()
        {
            return id;
        }

        public String getDescription()
        {
            return description;
        }

        public String toString()
        {
            return description;
        }
    }
}
