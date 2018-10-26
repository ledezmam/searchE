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

/**
 * View class with variables set.
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class View extends JFrame {

    //private TextPanel textPanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;

    /**
     * View configuration
     */
    public View() {
        super("Search-E");
        init();
        settings();
    }

    /**
     * Form Panel getter
     *
     * @return Form Panel
     */
    public FormPanel getFormPanel() {
        return formPanel;
    }

    /**
     * Text Panel getter
     *
     * @return Text panel
     */
//    public TextPanel getTextPanel() {
//        return textPanel;
//    }

    /**
     * Initiation method
     */
    public void init(){
        setLayout(new BorderLayout());
        //textPanel = new TextPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        //add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);


    }

    /**
     * Method with the settings
     */
    public void settings(){
        // make the program stop and exit correctly when the User presses the 'X' button of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the default size of the frame
        setSize(800, 800);
        // make the Frame be visible
        setVisible(true);
    }
}
