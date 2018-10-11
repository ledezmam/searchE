package com.foundation.view;
/*
 *  @(#)View.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 *
 */

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    //private JPanel topPanel;
    private JTextArea textArea;
    private JButton btn;

    public View(){
        super("Search-E");
        // make the frame be visible
        setVisible(true);
        // make the program stop and exit correctly when the User presses the 'X' button of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the default size of the frame
        setSize(600, 500);

        setLayout(new BorderLayout());
        textArea = new JTextArea();
        btn = new JButton("Search");

        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);


    }

//    private class mainPanel{
//
//    }



}
