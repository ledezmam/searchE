
/*
 *  @(#)TablePanel.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */
package com.foundation.view;

import com.foundation.model.Asset;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;

/**
 * Table Panel class
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class TablePanel extends JPanel {

    private JTable table;
    private SearchTableModel tableModel;

    /**
     * Table panel constructor
     */
    public TablePanel(){

        tableModel = new SearchTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    /**
     * Method to set results data
     *
     * @param results gives the results of the search
     */
    public void setData(List<Asset> results){
        tableModel.setData(results);
    }

    /**
     * Method to refresh the panel
     */
    public void refresh(){
        tableModel.fireTableDataChanged();
    }
}
