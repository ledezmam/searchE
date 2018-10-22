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

    private TextPanel textPanel;
    private FormPanel formPanel;

    /**
     * View configuration
     */
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

    public FormPanel getFormPanel() {
        return formPanel;
    }

    /**
     * Initiation method
     */
    public void init(){
        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);

//        toolBar.setStringListener(new StringListener() {
//            public void textEmitted(String text) {
//                textPanel.appendText(text);
//            }
//        });
//        formPanel.setFormListener(new FormListener(){
//                                      public void formEventOccurred(FormEvent e){
//                                          String input = e.getInput();
//                                          FileCategory ext = e.getExtCategory();
//                                          FileCategory vis = e.getVisibilityCategory();
//                                          FileCategory size = e.getFileSizeCategory();
//                                          FileCategory created = e.getDateCreatedCategory();
//                                          FileCategory mod = e.getDateModifiedCategory();
//                                          FileCategory accs = e.getDateAccessedCategory();
//                                          FileCategory comp = e.getFileCompareCategory();
//                                          textPanel.appendText("input: " + input + " extension: " + ext + " Visibility: "
//                                                  + vis + " File size: " + size + "\n" + "File comparator: " + comp
//                                                  + " Date created: " + created + " Date modified: " + mod + " Date accessed: "
//                                                  + accs + "\n" + "\n");
//                                      }
//                                  }
//        );

    }
}
