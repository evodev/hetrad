package com.company.business;


import com.company.gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("HE-Trade");
        frame.setContentPane(new Gui().jp_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 500));
        frame.pack();
        frame.setVisible(true);

    }
}
