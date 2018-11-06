
/*
 *  @(#)SearchTableModel.java Copyright (c) 2018 Jalasoft.
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

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model class
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class SearchTableModel extends AbstractTableModel {

    private List<Asset> results;
    private String[] colNames = {"Path", "File Name", "File Size", "Owner",
            "Date Created", "Date Modified", "Date Accessed", "Hidden", "Read Only"};

    /**
     * Table model constructor
     */
    public SearchTableModel(){
        this.results = new ArrayList<>();
    }

    /**
     * Method to get the Column names
     *
     * @param column read column data
     * @return Column name
     */
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    /**
     * Method to set the search results data
     *
     * @param results read search results
     */
    public void setData(List<Asset> results){
        this.results = results;
    }

    /**
     * Method to get the total result rows count
     *
     * @return size of the results
     */
    @Override
    public int getRowCount() {
        return results.size();
    }

    /**
     * Define the total number of columns
     *
     * @return the number of columns
     */
    @Override
    public int getColumnCount() {
        return 9;
    }

    /**
     * Method to get the values of the result
     *
     * @param row number of row
     * @param column number of column
     * @return null
     */
    @Override
    public Object getValueAt(int row, int column) {
        Asset filefound = results.get(row);

        switch(column){
            case 0:
                return filefound.getPath();
            case 1:
                return filefound.getFilename();
            case 2:
                return filefound.getSize();
            case 3:
                return filefound.getOwner();
            case 4:
                return filefound.getDateCreation();
            case 5:
                return filefound.getDateModified();
            case 6:
                return filefound.getDateAccessed();
            case 7:
                return filefound.getHidden();
            case 8:
                return filefound.isReadable();
        }
        return null;
    }
}
