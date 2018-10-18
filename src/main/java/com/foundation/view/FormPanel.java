
/*
 * @(#)FormPanel.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.foundation.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Panel class setting with grid definition
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class FormPanel extends JPanel {

    private JLabel folderButtonLabel, fileButtonLabel;
    private JTextField folderField, fileField;
    private JButton folderButton, fileButton;
    private FormListener formListener;

    public FormPanel(){
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 100;
        dim.height = 100;
        setPreferredSize(dim);

        folderButtonLabel = new JLabel("Folder Path: ");
        folderField = new JTextField(50);
        folderButton = new JButton("Browse");
        folderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String one = folderField.getText();

                FormEvent event = new FormEvent(this, one);

                if(formListener != null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        fileButtonLabel = new JLabel("File Name: ");
        fileField = new JTextField(50);
        fileButton = new JButton("Search");
        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String one = fileField.getText();

                FormEvent event = new FormEvent(this, one);

                if(formListener != null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Menu");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        // set weight to first row
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        // give gc a little space between components
        gc.insets = new Insets(0,20,0,0);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderField, gc);

        // set weight for Search button
        //gc.weightx = 1;
        //gc.weighty = 2;

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButton, gc);

        // set weight to second row

        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        // give gc a little space between components
        gc.insets = new Insets(0,20,0,0);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileField, gc);

        // set weight for Search button
        //gc.weightx = 1;
        //gc.weighty = 2;

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileButton, gc);
    }

    /*
     * Form listener method
     *
     * @Author Ruben Mendoza
     * @Version 1.0
     */

    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }
}

