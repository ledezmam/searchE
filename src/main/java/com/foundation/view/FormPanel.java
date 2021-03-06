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

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.net.URL;


/**
 * Panel class setting with grid definition
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class FormPanel extends JPanel {

    private JLabel folderButtonLabel, searchButtonLabel, extensionLabel, visibilityLabel,
            ownerLabel, fileSizeLabel, dateCreatedLabel, dateModifiedLabel, dateAccessedLabel,
            fileIsReadOnlyLabel, fileContentLabel;
    private JTextField folderTextField, searchTextField, ownerTextField, fileSizeTextField,
            fileContentTextField;
    private JButton folderButton, searchButton;
    private FormListener formListener;
    private JComboBox extensionList, visibilityList, fileSizeCompareList, fileSizeList;
    private ActionListener searchActionListener;
    private JDatePickerImpl dateCreatedInitialPicker, dateModifiedInitialPicker, dateAccessedInitialPicker,
            dateCreatedFinalPicker, dateModifiedFinalPicker, dateAccessedFinalPicker;
    private JCheckBox fileIsReadOnlyCheckBox;

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
        dim.height = 280;
        setPreferredSize(dim);
    }

    /**
     * Combobox getter
     *
     * @return extension list of combobox
     */
    public JComboBox getExtList() {
        return extensionList;
    }

    /**
     * Owner text field getter
     *
     * @return Owner text input
     */
    public JTextField getOwnerField() {
        return ownerTextField;
    }

    /**
     * Path value getter
     *
     * @return File Path
     */
    public JTextField getFolderTextField() {
        return folderTextField;
    }

    /**
     * Search field getter
     *
     * @return value of the serach field
     */
    public JTextField getSearchTextField() {
        return searchTextField;
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
    public JCheckBox getFileIsReadOnlyCheckBox() {
        return fileIsReadOnlyCheckBox;
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
     * Owner field getter
     *
     * @return Owner
     */
    public JTextField getOwnerTextField() {
        return ownerTextField;
    }

    /**
     * File Size input field getter
     *
     * @return file size input
     */
    public JTextField getFileSizeTextField() {
        return fileSizeTextField;
    }

    /**
     * Extension getter
     *
     * @return file extension
     */
    public JComboBox getExtensionList() {
        return extensionList;
    }

    /**
     * File visibility getter
     *
     * @return fle visiblity
     */
    public JComboBox getVisibilityList() {
        return visibilityList;
    }

    /**
     * File comparison criteria getter
     *
     * @return File comparison criteria
     */
    public JComboBox getFileSizeCompareList() {
        return fileSizeCompareList;
    }

    /**
     * File size unit getter
     *
     * @return file size unit
     */
    public JComboBox getFileSizeList() {
        return fileSizeList;
    }

    /**
     * Initial date created picker
     *
     * @return initial date created
     */
    public JDatePickerImpl getDateCreatedInitialPicker() {
        return dateCreatedInitialPicker;
    }

    /**
     * Initial date modified picker
     *
     * @return initial date modified
     */
    public JDatePickerImpl getDateModifiedInitialPicker() {
        return dateModifiedInitialPicker;
    }

    /**
     * Initial date accessed picker
     *
     * @return initial date accessed
     */
    public JDatePickerImpl getDateAccessedInitialPicker() {
        return dateAccessedInitialPicker;
    }

    /**
     * Folder button getter
     *
     * @return folder button
     */
    public JButton getFolderButton() {
        return folderButton;
    }

    /**
     * Final date created picker
     *
     * @return
     */
    public JDatePickerImpl getDateCreatedFinalPicker() {
        return dateCreatedFinalPicker;
    }

    /**
     * Final date modified picker
     *
     * @return
     */
    public JDatePickerImpl getDateModifiedFinalPicker() {
        return dateModifiedFinalPicker;
    }

    /**
     * Final date accessed picker
     *
     * @return
     */
    public JDatePickerImpl getDateAccessedFinalPicker() {
        return dateAccessedFinalPicker;
    }

    /**
     * File content text getter
     *
     * @return file content
     */
    public JTextField getFileContentTextField() {
        return fileContentTextField;
    }

    /**
     * Method to load an icon
     *
     * @param path where the icon is located
     * @return icon loaded
     */
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        if(url ==null){
            System.err.println("Unable to load image: " + path);
        }
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }

    /**
     * Method with the components of the class
      */
    public void components(){
        extensionLabel = new JLabel("Extension: ");
        extensionList = new JComboBox();
        visibilityLabel = new JLabel("Visibility: ");
        visibilityList = new JComboBox();
        ownerLabel = new JLabel("Owner");
        ownerTextField = new JTextField(15);
        fileSizeLabel = new JLabel("File Size: ");
        fileSizeCompareList = new JComboBox();
        fileSizeList = new JComboBox();
        fileSizeTextField = new JTextField(10);
        dateCreatedLabel = new JLabel("Date Created");
        dateModifiedLabel = new JLabel("Date Modified");
        dateAccessedLabel = new JLabel("Date Accessed");
        fileContentLabel = new JLabel("Content");
        fileContentTextField = new JTextField(10);

        fileIsReadOnlyLabel = new JLabel("Read only");
        fileIsReadOnlyCheckBox = new JCheckBox();

        folderButtonLabel = new JLabel("Folder Path: ");
        folderTextField = new JTextField(25);
        folderButton = new JButton("Browse");
        folderTextField.setEditable(false);

        UtilDateModel modelCreatedInitial = new UtilDateModel();
        UtilDateModel modelModifiedInitial = new UtilDateModel();
        UtilDateModel modelAccessedInitial = new UtilDateModel();
        UtilDateModel modelCreatedFinal = new UtilDateModel();
        UtilDateModel modelModifiedFinal = new UtilDateModel();
        UtilDateModel modelAccessedFinal = new UtilDateModel();

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanelCreatedInitial = new JDatePanelImpl(modelCreatedInitial, p);
        JDatePanelImpl datePanelModifiedInitial = new JDatePanelImpl(modelModifiedInitial, p);
        JDatePanelImpl datePanelAccessedInitial = new JDatePanelImpl(modelAccessedInitial, p);
        JDatePanelImpl datePanelCreatedFinal = new JDatePanelImpl(modelCreatedFinal, p);
        JDatePanelImpl datePanelModifiedFinal = new JDatePanelImpl(modelModifiedFinal, p);
        JDatePanelImpl datePanelAccessedFinal = new JDatePanelImpl(modelAccessedFinal, p);
        dateCreatedInitialPicker = new JDatePickerImpl(datePanelCreatedInitial, new DateLabelFormatter());
        dateModifiedInitialPicker = new JDatePickerImpl(datePanelModifiedInitial, new DateLabelFormatter());
        dateAccessedInitialPicker = new JDatePickerImpl(datePanelAccessedInitial, new DateLabelFormatter());
        dateCreatedFinalPicker = new JDatePickerImpl(datePanelCreatedFinal, new DateLabelFormatter());
        dateModifiedFinalPicker = new JDatePickerImpl(datePanelModifiedFinal, new DateLabelFormatter());
        dateAccessedFinalPicker = new JDatePickerImpl(datePanelAccessedFinal, new DateLabelFormatter());

        folderButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser pathChooser = new JFileChooser();
                pathChooser.setCurrentDirectory(new java.io.File("."));
                pathChooser.setDialogTitle("Select Path");
                pathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                pathChooser.setAcceptAllFileFilterUsed(false);
                pathChooser.showOpenDialog(null);
                File select = pathChooser.getSelectedFile();
                String selection = (select).getAbsolutePath();
                folderTextField.setText(selection);
            }
        });

        searchButtonLabel = new JLabel("File Name: ");
        searchTextField = new JTextField(25);
        searchButton = new JButton("Search ");
        //searchButton.setIcon(createIcon("/src/images/icon.png"));

        searchActionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String string = searchTextField.getText();
                FileCategory extCategory = (FileCategory) extensionList.getSelectedItem();
                FileCategory visibilityCategory = (FileCategory) visibilityList.getSelectedItem();
                FileCategory fileSizeCategory = (FileCategory) fileSizeList.getSelectedItem();

                JDatePanel dateCreatedInitialCategory = dateCreatedInitialPicker.getJDateInstantPanel();
                JDatePanel dateModifiedInitialCategory = dateModifiedInitialPicker.getJDateInstantPanel();
                JDatePanel dateAccessedInitialCategory = dateAccessedInitialPicker.getJDateInstantPanel();
                JDatePanel dateCreatedFinalCategory = dateCreatedFinalPicker.getJDateInstantPanel();
                JDatePanel dateModifiedFinalCategory = dateModifiedFinalPicker.getJDateInstantPanel();
                JDatePanel dateAccessedFinalCategory = dateAccessedFinalPicker.getJDateInstantPanel();
                FileCategory fileCompareCategory = (FileCategory) fileSizeCompareList.getSelectedItem();
                boolean readOnly = getFileIsReadOnlyCheckBox().isSelected();

                FormEvent event = new FormEvent(this, string, extCategory, visibilityCategory,
                        fileSizeCategory, dateCreatedInitialCategory, dateModifiedInitialCategory, dateAccessedInitialCategory,
                        fileCompareCategory, readOnly, dateCreatedFinalCategory, dateModifiedFinalCategory, dateAccessedFinalCategory);
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
        extensionList.setModel(extModel);

        extensionList.setPreferredSize(new Dimension(100, 25));
        extensionList.setBorder(BorderFactory.createEtchedBorder());
        extensionList.setSelectedIndex(0);

        DefaultComboBoxModel visibilityModel = new DefaultComboBoxModel();
        visibilityModel.addElement(new FileCategory(0, ""));
        visibilityModel.addElement(new FileCategory(1, "Public"));
        visibilityModel.addElement(new FileCategory(2, "Hidden"));
        visibilityList.setModel(visibilityModel);

        visibilityList.setPreferredSize(new Dimension(100, 25));
        visibilityList.setBorder(BorderFactory.createEtchedBorder());
        visibilityList.setSelectedIndex(0);

        DefaultComboBoxModel fileCompareModel = new DefaultComboBoxModel();
        fileCompareModel.addElement(new FileCategory(0, ""));
        fileCompareModel.addElement(new FileCategory(1, "equals to"));
        fileCompareModel.addElement(new FileCategory(2, "greater than"));
        fileCompareModel.addElement(new FileCategory(3, "less than"));
        fileSizeCompareList.setModel(fileCompareModel);

        fileSizeCompareList.setPreferredSize(new Dimension(100, 25));
        fileSizeCompareList.setBorder(BorderFactory.createEtchedBorder());
        fileSizeCompareList.setSelectedIndex(0);

        DefaultComboBoxModel fileSizeModel = new DefaultComboBoxModel();
        fileSizeModel.addElement(new FileCategory(0, ""));
        fileSizeModel.addElement(new FileCategory(1, "KB"));
        fileSizeModel.addElement(new FileCategory(2, "MB"));
        fileSizeModel.addElement(new FileCategory(3, "GB"));
        fileSizeList.setModel(fileSizeModel);

        fileSizeList.setPreferredSize(new Dimension(100, 25));
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
        gc.insets = new Insets(1,1,1,1);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderTextField, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(folderButton, gc);

        // set second row
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchButtonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchTextField, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(searchButton, gc);

        // set Third row
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(extensionLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(extensionList, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityLabel, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(visibilityList, gc);

        // set forth row
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerLabel, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(ownerTextField, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileIsReadOnlyLabel, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileIsReadOnlyCheckBox, gc);

        // set fifth row
        gc.gridx = 0;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeCompareList, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeTextField, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileSizeList, gc);

        // set sixth row
        gc.gridx = 0;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedLabel, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedInitialPicker, gc);

        gc.gridx = 2;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(" to "), gc);

        gc.gridx = 3;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateCreatedFinalPicker, gc);

        // set seventh row
        gc.gridx = 0;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedLabel, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedInitialPicker, gc);

        gc.gridx = 2;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(" to "), gc);

        gc.gridx = 3;
        gc.gridy = 6;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateModifiedFinalPicker, gc);

        // set eighth row
        gc.gridx = 0;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedLabel, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedInitialPicker, gc);

        gc.gridx = 2;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel(" to "), gc);

        gc.gridx = 3;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateAccessedFinalPicker, gc);

        // set ninth row
        gc.gridx = 0;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileContentLabel, gc);

        gc.gridx = 1;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fileContentTextField, gc);
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
