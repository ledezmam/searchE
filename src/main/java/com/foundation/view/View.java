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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private TextPanel textPanel;
    //private JButton btn;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public View(){
        super("Search-E");
        // make the Frame be visible
        setVisible(true);
        // make the program stop and exit correctly when the User presses the 'X' button of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the default size of the frame
        setSize(600, 500);

        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        //btn = new JButton("Search");
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        add(textPanel, BorderLayout.CENTER);
        //add(btn, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);

        toolBar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener(){
                                      public void formEventOccurred(FormEvent e){
                                          String name = e.getOne();
                                          String occupation = e.getTwo();

                                          textPanel.appendText(name + " : " + occupation + "\n");

                                      }
                                  }
        );
    }
}
