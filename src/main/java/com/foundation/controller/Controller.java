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

import java.io.IOException;
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
        if (!path.isEmpty()) {
            if (validate.validatePath(path)) {
                criteria.setPath(path);
            } else {
                view.setTextPanel("The specified path is not valid.!!!");
                flag = false;
            }
        } else {
            view.setTextPanel("Folder path is empty, you must specify a path.!!!");
            flag = false;
        }

        String fileName = view.getFormPanel().getSearchTextField().getText();
        if (!fileName.isEmpty()) {
            if (validate.validateFileName(fileName)) {
                criteria.setFileName(fileName);
            } else {
                view.setTextPanel("File Name contains one of these invalid" +
                        " characters: <>:\"\\/|?*");
                flag = false;
            }
        }

        String fileType = view.getFormPanel().getExtList().getSelectedItem()
                .toString();
        if (!fileType.isEmpty() && validate.validateFileType(fileType)) {
            criteria.setFileExtension(fileType);
        }

        String visibility = view.getFormPanel().getVisibilityList()
                .getSelectedItem().toString();
        if (visibility != null && !visibility.isEmpty()) {
            criteria.setFileVisibility(visibility);
        }

        boolean readOnly = view.getFormPanel().getFileIsReadOnlyCheckBox()
                .isSelected();
        if (readOnly) {
            criteria.setReadOnly(readOnly);
        }

        /* file size will be validated an converted to bytes */
        String operator = view.getFormPanel().getFileSizeCompareList()
                .getSelectedItem().toString();
        String unit = view.getFormPanel().getFileSizeList().getSelectedItem()
                .toString();
        String fileSize = view.getFormPanel().getFileSizeTextField().getText();

        if ((!fileSize.isEmpty()) && ((operator.isEmpty()) || (unit.isEmpty()))
                || ((!operator.isEmpty()) && ((fileSize.isEmpty()) || (unit.isEmpty())))
                || ((!unit.isEmpty()) && ((fileSize.isEmpty()) || (operator.isEmpty())))) {
            view.setTextPanel("Please specify all three parameters to search by File Size.!!!");
            flag = false;
        } else if (!fileSize.isEmpty()) {
            if (validate.validateFileSize(fileSize)) {
                long size = Long.valueOf(fileSize);
                switch (unit) {
                    case "KB":
                        size = size * 1024;
                        break;
                    case "MB":
                        size = size * 1024 * 1024;
                        break;
                    case "GB":
                        size = size * 1024 * 1024 * 1024;
                        break;
                    default:
                        break;
                }

                criteria.setFileSize(operator, size);
            } else {
                view.setTextPanel("An invalid file size was specified. " +
                        "Please ensure it's numeric.!!!");
                flag = false;
            }
        }

        String dateModifiedStart = view.getFormPanel().getDateModifiedInitialPicker()
                .getJFormattedTextField().getText();
        String dateModifiedEnd = view.getFormPanel()
                .getDateModifiedFinalPicker()
                .getJFormattedTextField().getText();
        if ((!dateModifiedStart.isEmpty() && dateModifiedEnd.isEmpty())
                || (dateModifiedStart.isEmpty() && !dateModifiedEnd.isEmpty())) {
            view.setTextPanel("One of the modified date is empty, " +
                    "ensure you have entered both.!!!");
            flag = false;
        } else if (validate.validateDate(dateModifiedStart)
                && validate.validateDate(dateModifiedEnd)) {
            criteria.setDateModifiedStart(dateModifiedStart);
            criteria.setDateModifiedEnd(dateModifiedEnd);
        }

        String dateCreatedStart = view.getFormPanel().getDateCreatedInitialPicker()
                .getJFormattedTextField().getText();
        String dateCreatedEnd = view.getFormPanel()
                .getDateCreatedFinalPicker()
                .getJFormattedTextField().getText();
        if ((!dateCreatedStart.isEmpty() && dateCreatedEnd.isEmpty())
                || (dateCreatedStart.isEmpty() && !dateCreatedEnd.isEmpty())) {
            view.setTextPanel("One of the created date is empty, " +
                    "ensure you have entered both.!!!");
            flag = false;
        } else if (validate.validateDate(dateCreatedStart)
                && validate.validateDate(dateCreatedEnd)) {
            criteria.setDateCreatedStart(dateCreatedStart);
            criteria.setDateCreatedEnd(dateCreatedEnd);
        }

        String dateAccessedStart = view.getFormPanel()
                .getDateAccessedInitialPicker()
                .getJFormattedTextField().getText();
        String dateAccessedEnd = view.getFormPanel()
                .getDateAccessedFinalPicker()
                .getJFormattedTextField().getText();
        if ((!dateAccessedStart.isEmpty() && dateAccessedEnd.isEmpty())
                || (dateAccessedStart.isEmpty() && !dateAccessedEnd.isEmpty())) {
            view.setTextPanel("One of the accessed date is empty, " +
                    "ensure you have entered both.!!!");
            flag = false;
        } else if (validate.validateDate(dateAccessedStart)
                && validate.validateDate(dateAccessedEnd)) {
            criteria.setDateAccessedStart(dateAccessedStart);
            criteria.setDateAccessedEnd(dateAccessedEnd);
        }

        String owner = view.getFormPanel().getOwnerField().getText();
        if (!owner.isEmpty()) {
            criteria.setFileOwner(owner);
        }
/*
        String content = "any text here";
        if (content != null) {
            criteria.setFileContent(content);
        }
*/
        if (flag) {
            search.resetResults();
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
