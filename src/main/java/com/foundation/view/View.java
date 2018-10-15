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

package com.foundation.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/*
 * View class with variables set.
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class View extends JFrame {

    private TextPanel textPanel;
    //private JButton btn;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public View() {
        super("Search-E");
        // make the Frame be visible
        setVisible(true);
        // make the program stop and exit correctly when the User presses the 'X' button of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the default size of the frame
        setSize(800, 800);

        init();
    }

    /*
     * Init Class with the configuration of the View, includes the toolbar, Text Panel and Form Panel
     *
     * @Author Ruben Mendoza
     * @Version 1.0
     */

    public void init(){
        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        add(textPanel, BorderLayout.CENTER);
        //add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.NORTH);

        toolBar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener(){
                                      public void formEventOccurred(FormEvent e){
                                          String input = e.getInput();

                                          textPanel.appendText(input);
                                      }
                                  }
        );
    }
}
