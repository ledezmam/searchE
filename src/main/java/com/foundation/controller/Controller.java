/*
 * @(#)Controller.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package com.foundation.controller;

import com.foundation.model.FileFound;
import com.foundation.model.Search;
import com.foundation.view.View;

import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.List;

/**
 * Class to integrate View and Search classes
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class Controller {

    Validator validate;
    SearchCriteria criteria;
    View view;
    Search search;

    /**
     * Controller constructor
     */
    public Controller() throws ParseException {
        view = new View();
        search = new Search();

        validate = new Validator();
        criteria = new SearchCriteria();

        view.getFormPanel().getSearchButton().addActionListener(e -> {
            try {
                view.getTextPanel().clean();
                view.getTablePanel().refresh();
                //view.getTablePanel().setData(null);
                getCriteriaView();
            } catch (ParseException | IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    /**
     * Method to get all texts from UI and fill the criteria object with
     * required data to search files
     *
     * @throws ParseException
     */
    private void getCriteriaView() throws ParseException, IOException {

        boolean flag = true;

        String path = view.getFormPanel().getFolderTextField().getText();
        if (path != null && !path.isEmpty()) {
            if (validate.validatePath(path)) {
                criteria.setPath(path);
            } else {
                view.setTextPanel("The specified path is not valid.!!!");
                flag = false;
            }
        } else {
            view.setTextPanel("Folder path is empty");
            flag = false;
        }

        String fileName = view.getFormPanel().getSearchTextField().getText();
        if (fileName != null && !fileName.isEmpty()) {
            if (validate.validateFileName(fileName)) {
                criteria.setFileName(fileName);
            } else {
                view.setTextPanel("File Name contains one of these invalid characters: <>:\"\\/|?*");
                flag = false;
            }
        }

        String fileType = view.getFormPanel().getExtList().getSelectedItem().toString();
        if (fileType != null && validate.validateFileType(fileType)) {
            criteria.setFileExtension(fileType);
        }

        String visibility = view.getFormPanel().getVisibilityList().getSelectedItem().toString();
        if (visibility != null && !visibility.isEmpty()) {
            criteria.setFileVisibility(visibility);
        }

        /* file size will be validated an converted to bytes */
/*        String operator = "greater than";
        String fileSize = "12";
        String unit = "MB";
        if (fileSize != null
                && (operator != null)
                && (unit != null)
                && validate.validateFileSize(fileSize)) {

            long size = Long.valueOf(fileSize);
            switch (unit) {
                case "KB":
                    size = size * 1024;
                    break;
                case "MB":
                    size = size * 1024 *1024;
                    break;
                case "GB":
                    size = size * 1024 * 1024 * 1024;
                    break;
                default:
                    break;
            }

            criteria.setFileSize(operator, size);
        }

        String dateModified = "10/17/2018";
        if (dateModified != null && validate.validateDate(dateModified)) {
            criteria.setDateModified(dateModified);
        }

        String dateCreated = "10/17/2018";
        if (dateCreated != null && validate.validateDate(dateCreated)) {
            criteria.setDateCreated(dateCreated);
        }

        String dateAccessed = "10/17/2018";
        if (dateAccessed != null && validate.validateDate(dateAccessed)) {
            criteria.setDateAccessed(dateAccessed);
        }
*/
        String owner = view.getFormPanel().getOwnerField().getText();
        if (owner != null && !owner.isEmpty()) {
            criteria.setFileOwner(owner);
        }
/*
        String content = "any text here";
        if (content != null) {
            criteria.setFileContent(content);
        }
*/
        if (flag) {
            List<FileFound> results = search.searchFilesByCriteria(criteria);
            printResult(results);
        }
    }

    /**
     * Method to print results in console
     *
     * @throws ParseException
     */
    public void printResult(List<FileFound> results) throws ParseException {
        for (FileFound item : results) {
            //view.getTablePanel().clear();
            view.getTablePanel().setData(results);
        }
    }

}
