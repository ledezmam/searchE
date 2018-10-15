
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

    private JLabel inputButton;
    private JTextField inputField;
    private JButton searchButton;
    private FormListener formListener;

    public FormPanel(){
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 100;
        dim.height = 100;
        setPreferredSize(dim);

        inputButton = new JLabel("Search: ");
        inputField = new JTextField(50);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String one = inputField.getText();

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
        add(inputButton, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(inputField, gc);

        // set weight for Search button
        //gc.weightx = 1;
        //gc.weighty = 2;

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchButton, gc);
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

