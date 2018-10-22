/*
 *  @(#)AdvancedPanel.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 *
 */

package com.foundation.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
 * Panel class setting with grid definition
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class AdvancedPanel extends JPanel {
    private JLabel extLabel, visibilityLabel, ownerLabel, fileSizeLabel, dateCreatedLabel, dateModifiedLabel, dateAccessedLabel;
    private JTextField ownerField, fileSizeField;
    private FormListener formListener;
    private JComboBox extList, visibilityList, fileCompareList, fileSizeList, dateCreatedPicker, dateModifiedPicker, dateAccessedPicker;

    public AdvancedPanel(){
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 100;
        dim.height = 150;
        setPreferredSize(dim);

        extLabel = new JLabel("By Extension: ");
        extList = new JComboBox();
        visibilityLabel = new JLabel("By Visibility: ");
        visibilityList = new JComboBox();
        ownerLabel = new JLabel("By Owner");
        ownerField = new JTextField(15);
        fileSizeLabel = new JLabel("File Size: ");
        fileCompareList = new JComboBox();
        fileSizeList = new JComboBox();
        fileSizeField = new JTextField(10);
        dateCreatedLabel = new JLabel("Date Created");
        dateCreatedPicker = new JComboBox();
        dateModifiedLabel = new JLabel("Date Modified");
        dateModifiedPicker = new JComboBox();
        dateAccessedLabel = new JLabel("Date Accessed");
        dateAccessedPicker = new JComboBox();

        DefaultComboBoxModel extModel = new DefaultComboBoxModel();
        extModel.addElement(new FileCategory(0, "exe"));
        extModel.addElement(new FileCategory(1, "txt"));
        extModel.addElement(new FileCategory(2, "java"));
        extModel.addElement(new FileCategory(3, "Other"));
        extList.setModel(extModel);

        extList.setPreferredSize(new Dimension(100, 20));
        extList.setBorder(BorderFactory.createEtchedBorder());
        extList.setSelectedIndex(1);

        DefaultComboBoxModel visibilityModel = new DefaultComboBoxModel();
        visibilityModel.addElement(new FileCategory(0, "Public"));
        visibilityModel.addElement(new FileCategory(1, "Hidden"));
        visibilityModel.addElement(new FileCategory(2, "All"));
        visibilityList.setModel(visibilityModel);

        visibilityList.setPreferredSize(new Dimension(100, 20));
        visibilityList.setBorder(BorderFactory.createEtchedBorder());
        visibilityList.setSelectedIndex(1);

        DefaultComboBoxModel fileCompareModel = new DefaultComboBoxModel();
        fileCompareModel.addElement(new FileCategory(0, "Less than"));
        fileCompareModel.addElement(new FileCategory(1, "equals to"));
        fileCompareModel.addElement(new FileCategory(2, "More than"));
        fileCompareList.setModel(fileCompareModel);

        fileCompareList.setPreferredSize(new Dimension(100, 20));
        fileCompareList.setBorder(BorderFactory.createEtchedBorder());
        fileCompareList.setSelectedIndex(1);

        DefaultComboBoxModel fileSizeModel = new DefaultComboBoxModel();
        fileSizeModel.addElement(new FileCategory(0, "Less than"));
        fileSizeModel.addElement(new FileCategory(1, "equals to"));
        fileSizeModel.addElement(new FileCategory(2, "More than"));
        fileSizeList.setModel(fileSizeModel);

        fileSizeList.setPreferredSize(new Dimension(100, 20));
        fileSizeList.setBorder(BorderFactory.createEtchedBorder());
        fileSizeList.setSelectedIndex(1);

        Border innerBorder = BorderFactory.createTitledBorder("Advanced Search");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
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

    /*
     * Method to use for component layout
     *
     * @Author Ruben Mendoza
     * @Version 1.0
     */

    public void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        // set first row
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        // give gc a little space between components
        gc.insets = new Insets(0,10,0,0);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_START;
        add(extLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(extList, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedPicker, gc);

        // set second row
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityList, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedPicker, gc);

        // set third row
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerField, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedPicker, gc);

        // set forth row
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("By Size"), gc);

        // set fifth row
        gc.gridx = 0;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileCompareList, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeField, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeList, gc);
    }

}

/*class FileCategory{

    private int id;
    private String text;

    public FileCategory(int id, String text){
        this.id = id;
        this.text = text;
    }

    public String toString(){
        return text;
    }

    public int getId(){
        return id;
    }
}*/