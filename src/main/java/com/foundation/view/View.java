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
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View class with variables set.
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class View extends JFrame {

    private TextPanel textPanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private JFileChooser fileChooser;

    /**
     * View configuration
     */
    public View() {
        super("Search-E");
        init();
        settings();
    }

    /**
     * Table panel getter
     *
     * @return Table panel
     */
    public TablePanel getTablePanel() {
        return tablePanel;
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
    public TextPanel getTextPanel() {
        return textPanel;
    }

    /**
     * Text panel setter
     *
     * @param textPanel message displayed
     */
    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    /**
     * Initiation method
     */
    public void init(){
        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        fileChooser = new JFileChooser();

        add(textPanel, BorderLayout.SOUTH);
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
        // set Menu bar
        setJMenuBar(menuBar());
    }

    /**
     * Method to create Menu Bar on the Top
     *
     * @return menu bar
     */
    private JMenuBar menuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Menu");
        JMenuItem aboutOption = new JMenuItem("About");
        JMenuItem exitOption = new JMenuItem("Exit");

        optionsMenu.add(aboutOption);
        optionsMenu.addSeparator();
        optionsMenu.add(exitOption);

        menuBar.add(optionsMenu);

        aboutOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(View.this,
                        "This is a project created by group E for the DevFund class\n\nMaria Ledezma - Model" +
                                "\nMarco Velasquez - Controller\nRuben Mendoza - View",
                        "About", JOptionPane.PLAIN_MESSAGE);
            }
        });

        exitOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(View.this,
                        "Do you really want to exit the application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION|JOptionPane.WARNING_MESSAGE);

                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }
}
