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

import org.jdatepicker.JDatePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;

/**
 * Panel class setting with grid definition
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class FormPanel extends JPanel {

    private JLabel pathButtonLabel, searchButtonLabel, extLabel, visibilityLabel, ownerLabel,
            fileSizeLabel, dateCreatedLabel, dateModifiedLabel, dateAccessedLabel, fileAttribute;
    private JTextField pathField, searchField, ownerField, fileSizeField;
    private JButton pathButton, searchButton;
    private FormListener formListener;
    private JComboBox extList, visibilityList, fileCompareList, fileSizeList;
    private ActionListener searchActionListener;
    private JDatePickerImpl dateCreatedPicker, dateModifiedPicker, dateAccessedPicker;
    private JCheckBox fileIsReadOnly;

    /**
     * Method used for the Panel configuration
     */
    public FormPanel() {
        settings();
        components();
        layoutComponents();
    }

    /**
     * Method with the class settings
     */
    public void settings(){
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        dim.width = 200;
        dim.height = 240;
        setPreferredSize(dim);
    }

    public JComboBox getExtList() {
        return extList;
    }

    public JComboBox getVisibilityList() {
        return visibilityList;
    }

    public JTextField getOwnerField() {
        return ownerField;
    }

    /**
     * Path value getter
     *
     * @return File Path
     */
    public JTextField getPathField() {
        return pathField;
    }

    /**
     * Search field getter
     *
     * @return value of the serach field
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * Search button getter
     *
     * @return search button criteria
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * File is read only getter
     *
     * @return file attribute
     */
    public JCheckBox getFileIsReadOnly() {
        return fileIsReadOnly;
    }

    /**
     * Form listener method
     *
     * @param listener The listener from the Form
     */
    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }

    /**
     * Method with the components of the class
      */
    public void components(){
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
        dateModifiedLabel = new JLabel("Date Modified");
        dateAccessedLabel = new JLabel("Date Accessed");
        fileAttribute = new JLabel("Read only");
        fileIsReadOnly = new JCheckBox();

        pathButtonLabel = new JLabel("Folder Path: ");
        pathField = new JTextField(30);
        pathButton = new JButton("Browse");
        pathField.setEditable(false);

        UtilDateModel modelCreated = new UtilDateModel();
        UtilDateModel modelAccessed = new UtilDateModel();
        UtilDateModel modelModified = new UtilDateModel();
        //model.setDate(2018, 10, 29);
        //model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanelCreated = new JDatePanelImpl(modelCreated, p);
        JDatePanelImpl datePanelAccessed = new JDatePanelImpl(modelAccessed, p);
        JDatePanelImpl datePanelModified = new JDatePanelImpl(modelModified, p);
        dateCreatedPicker = new JDatePickerImpl(datePanelCreated, new DateLabelFormatter());
        dateModifiedPicker = new JDatePickerImpl(datePanelModified, new DateLabelFormatter());
        dateAccessedPicker = new JDatePickerImpl(datePanelAccessed, new DateLabelFormatter());

        pathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser pathChooser = new JFileChooser();
                pathChooser.setCurrentDirectory(new java.io.File("."));
                pathChooser.setDialogTitle("Select Path");
                pathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                pathChooser.setAcceptAllFileFilterUsed(false);
                pathChooser.showOpenDialog(null);
                File select = pathChooser.getSelectedFile();
                String selection = (select).getAbsolutePath();
                pathField.setText(selection);
            }
        });

        searchButtonLabel = new JLabel("File Name: ");
        searchField = new JTextField(30);
        searchButton = new JButton("Search");
        searchActionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String string = searchField.getText();
                FileCategory extCategory = (FileCategory) extList.getSelectedItem();
                FileCategory visibilityCategory = (FileCategory) visibilityList.getSelectedItem();
                FileCategory fileSizeCategory = (FileCategory) fileSizeList.getSelectedItem();
                JDatePanel dateCreatedCategory = dateCreatedPicker.getJDateInstantPanel();
                JDatePanel dateModifiedCategory = dateModifiedPicker.getJDateInstantPanel();
                JDatePanel dateAccessedCategory = dateAccessedPicker.getJDateInstantPanel();
                FileCategory fileCompareCategory = (FileCategory) fileCompareList.getSelectedItem();
                boolean readOnly = fileIsReadOnly.isSelected();
                FormEvent event = new FormEvent(this, string, extCategory, visibilityCategory,
                        fileSizeCategory, dateCreatedCategory, dateModifiedCategory, dateAccessedCategory,
                        fileCompareCategory, readOnly);
                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }
            }
        };
        searchButton.addActionListener(searchActionListener );

        DefaultComboBoxModel extModel = new DefaultComboBoxModel();
        extModel.addElement(new FileCategory(0, ""));
        extModel.addElement(new FileCategory(1, ".txt"));
        extModel.addElement(new FileCategory(2, ".gif"));
        extModel.addElement(new FileCategory(3, ".pdf"));
        extModel.addElement(new FileCategory(4, ".doc"));
        extModel.addElement(new FileCategory(5, ".docx"));
        extModel.addElement(new FileCategory(6, ".xls"));
        extModel.addElement(new FileCategory(7, ".xlsx"));
        extModel.addElement(new FileCategory(8, ".xml"));
        extModel.addElement(new FileCategory(9, ".java"));
        extModel.addElement(new FileCategory(10, ".jpg"));
        extModel.addElement(new FileCategory(11, ".bmp"));
        extModel.addElement(new FileCategory(12, ".zip"));
        extModel.addElement(new FileCategory(13, ".exe"));
        extModel.addElement(new FileCategory(14, ".csv"));
        extList.setModel(extModel);

        extList.setPreferredSize(new Dimension(100, 20));
        extList.setBorder(BorderFactory.createEtchedBorder());
        extList.setSelectedIndex(0);

        DefaultComboBoxModel visibilityModel = new DefaultComboBoxModel();
        visibilityModel.addElement(new FileCategory(0, ""));
        visibilityModel.addElement(new FileCategory(1, "Public"));
        visibilityModel.addElement(new FileCategory(2, "Hidden"));
        visibilityList.setModel(visibilityModel);

        visibilityList.setPreferredSize(new Dimension(100, 20));
        visibilityList.setBorder(BorderFactory.createEtchedBorder());
        visibilityList.setSelectedIndex(0);

        DefaultComboBoxModel fileCompareModel = new DefaultComboBoxModel();
        fileCompareModel.addElement(new FileCategory(0, ""));
        fileCompareModel.addElement(new FileCategory(1, "equals to"));
        fileCompareModel.addElement(new FileCategory(2, "greater than"));
        fileCompareModel.addElement(new FileCategory(3, "Less than"));
        fileCompareList.setModel(fileCompareModel);

        fileCompareList.setPreferredSize(new Dimension(100, 20));
        fileCompareList.setBorder(BorderFactory.createEtchedBorder());
        fileCompareList.setSelectedIndex(0);

        DefaultComboBoxModel fileSizeModel = new DefaultComboBoxModel();
        fileSizeModel.addElement(new FileCategory(0, ""));
        fileSizeModel.addElement(new FileCategory(1, "KB"));
        fileSizeModel.addElement(new FileCategory(2, "MB"));
        fileSizeModel.addElement(new FileCategory(3, "GB"));
        fileSizeList.setModel(fileSizeModel);

        fileSizeList.setPreferredSize(new Dimension(100, 20));
        fileSizeList.setBorder(BorderFactory.createEtchedBorder());
        fileSizeList.setSelectedIndex(0);

        Border innerBorder = BorderFactory.createTitledBorder("Options");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    /**
     * Method used for the Grid components layout     *
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
        add(pathButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(pathField, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(pathButton, gc);

        // set second row
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchField, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchButton, gc);

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
        gc.insets = new Insets(1,0,3,0);
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
        add(fileAttribute, gc);

        gc.gridx = 3;
        gc.gridy = 6;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileIsReadOnly, gc);

        // set eight row
        gc.gridx = 0;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeField, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeList, gc);
    }

}

/**
 * Complementary Class to get the Id and Text from the file information
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
class FileCategory{

    private int id;
    private String text;

    /**
     * File category constructor
     *
     * @param id used to the get Id of the input
     * @param text used to get the Text of the input
     */
    public FileCategory(int id, String text){
        this.id = id;
        this.text = text;
    }

    /**
     * Method to get the text input return
     *
     * @return
     */
    public String toString(){
        return text;
    }

    /**
     * Method to get the Id input return
     *
     * @return
     */
    public int getId(){
        return id;
    }
}
