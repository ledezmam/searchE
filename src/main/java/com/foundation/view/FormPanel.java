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

import javax.swing.*;
import javax.swing.border.Border;
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

    private JLabel folderButtonLabel, fileButtonLabel, extLabel, visibilityLabel,
            ownerLabel, fileSizeLabel, dateCreatedLabel, dateModifiedLabel, dateAccessedLabel;
    private JTextField folderField, fileField, ownerField, fileSizeField;
    private JButton folderButton, fileButton;
    private FormListener formListener;
    private JComboBox extList, visibilityList, fileCompareList, fileSizeList,
            dateCreatedPicker, dateModifiedPicker, dateAccessedPicker;


    public FormPanel() {
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 150;
        dim.height = 200;
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

        folderButtonLabel = new JLabel("Folder Path: ");
        folderField = new JTextField(30);
        folderButton = new JButton("Browse");
        folderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string = folderField.getText();

                FormEvent event = new FormEvent(this, string);

                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }
            }
        });

        fileButtonLabel = new JLabel("File Name: ");
        fileField = new JTextField(30);
        fileButton = new JButton("Search");
        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string = fileField.getText();
                FileCategory extCategory = (FileCategory) extList.getSelectedItem();
                FileCategory visibilityCategory = (FileCategory) visibilityList.getSelectedItem();
                FileCategory fileSizeCategory = (FileCategory) fileSizeList.getSelectedItem();
                FileCategory dateCreatedCategory = (FileCategory) dateCreatedPicker.getSelectedItem();
                FileCategory dateModifiedCategory = (FileCategory) dateModifiedPicker.getSelectedItem();
                FileCategory dateAccessedCategory = (FileCategory) dateAccessedPicker.getSelectedItem();
                FileCategory fileCompareCategory = (FileCategory) fileCompareList.getSelectedItem();

                FormEvent event = new FormEvent(this, string, extCategory, visibilityCategory,
                        fileSizeCategory, dateCreatedCategory, dateModifiedCategory, dateAccessedCategory,
                        fileCompareCategory);
                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }
            }
        });

        DefaultComboBoxModel extModel = new DefaultComboBoxModel();
        extModel.addElement(new FileCategory(0, "All"));
        extModel.addElement(new FileCategory(1, "txt"));
        extModel.addElement(new FileCategory(2, "java"));
        extModel.addElement(new FileCategory(3, "exe"));
        extList.setModel(extModel);

        extList.setPreferredSize(new Dimension(100, 20));
        extList.setBorder(BorderFactory.createEtchedBorder());
        extList.setSelectedIndex(0);

        DefaultComboBoxModel visibilityModel = new DefaultComboBoxModel();
        visibilityModel.addElement(new FileCategory(0, "All"));
        visibilityModel.addElement(new FileCategory(1, "Public"));
        visibilityModel.addElement(new FileCategory(2, "Hidden"));
        visibilityList.setModel(visibilityModel);

        visibilityList.setPreferredSize(new Dimension(100, 20));
        visibilityList.setBorder(BorderFactory.createEtchedBorder());
        visibilityList.setSelectedIndex(1);

        DefaultComboBoxModel fileCompareModel = new DefaultComboBoxModel();
        fileCompareModel.addElement(new FileCategory(0, "All"));
        fileCompareModel.addElement(new FileCategory(1, "Less than"));
        fileCompareModel.addElement(new FileCategory(2, "equals to"));
        fileCompareModel.addElement(new FileCategory(4, "More than"));
        fileCompareList.setModel(fileCompareModel);

        fileCompareList.setPreferredSize(new Dimension(100, 20));
        fileCompareList.setBorder(BorderFactory.createEtchedBorder());
        fileCompareList.setSelectedIndex(0);

        DefaultComboBoxModel fileSizeModel = new DefaultComboBoxModel();
        fileSizeModel.addElement(new FileCategory(0, "KB"));
        fileSizeModel.addElement(new FileCategory(1, "MB"));
        fileSizeModel.addElement(new FileCategory(2, "GB"));
        fileSizeList.setModel(fileSizeModel);

        fileSizeList.setPreferredSize(new Dimension(100, 20));
        fileSizeList.setBorder(BorderFactory.createEtchedBorder());
        fileSizeList.setSelectedIndex(0);

        DefaultComboBoxModel dateCreatedModel = new DefaultComboBoxModel();
        dateCreatedModel.addElement(new FileCategory(0, "2018-10-18"));
        dateCreatedModel.addElement(new FileCategory(1, "2018-10-19"));
        dateCreatedModel.addElement(new FileCategory(2, "2018-10-20"));
        dateCreatedPicker.setModel(dateCreatedModel);

        dateCreatedPicker.setPreferredSize(new Dimension(100, 20));
        dateCreatedPicker.setBorder(BorderFactory.createEtchedBorder());
        dateCreatedPicker.setSelectedIndex(0);

        DefaultComboBoxModel dateModifiedModel = new DefaultComboBoxModel();
        dateModifiedModel.addElement(new FileCategory(0, "2018-10-18"));
        dateModifiedModel.addElement(new FileCategory(1, "2018-10-19"));
        dateModifiedModel.addElement(new FileCategory(2, "2018-10-20"));
        dateModifiedPicker.setModel(dateCreatedModel);

        dateModifiedPicker.setPreferredSize(new Dimension(100, 20));
        dateModifiedPicker.setBorder(BorderFactory.createEtchedBorder());
        dateModifiedPicker.setSelectedIndex(0);

        DefaultComboBoxModel dateAccessedModel = new DefaultComboBoxModel();
        dateAccessedModel.addElement(new FileCategory(0, "2018-10-18"));
        dateAccessedModel.addElement(new FileCategory(1, "2018-10-19"));
        dateAccessedModel.addElement(new FileCategory(2, "2018-10-20"));
        dateAccessedPicker.setModel(dateCreatedModel);

        dateAccessedPicker.setPreferredSize(new Dimension(100, 20));
        dateAccessedPicker.setBorder(BorderFactory.createEtchedBorder());
        dateAccessedPicker.setSelectedIndex(0);

        Border innerBorder = BorderFactory.createTitledBorder("Menu");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();
    }

    /*
     * Method used for the Grid components layout
     *
     * @Author Ruben Mendoza
     * @Version 1.0
     */
    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // set first row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        // give gc a little space between components
        gc.insets = new Insets(0,0,0,0);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderField, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButton, gc);

        // set second row
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileField, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileButton, gc);

        // set Third row
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(extLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(extList, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedPicker, gc);

        // set forth row
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityLabel, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityList, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedPicker, gc);

        // set fifth row
        gc.gridx = 0;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerLabel, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerField, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedLabel, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedPicker, gc);

        // set sixth row
        gc.gridx = 0;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("By Size"), gc);

        // set seventh row
        gc.gridx = 0;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileCompareList, gc);

        gc.gridx = 2;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeField, gc);

        gc.gridx = 3;
        gc.gridy = 6;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeList, gc);
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

/*
 * Complementary Class to get the Id and Text from the file information
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
class FileCategory{

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
}
