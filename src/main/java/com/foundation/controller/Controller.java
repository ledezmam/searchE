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

import java.text.ParseException;

/**
 * Class to integrate View and Search classes
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class Controller {

    Validator validate;
    SearchCriteria criteria;
    // View view;
    // Search search;

    /**
     * Controller constructor
     */
    public Controller() {
        // view = new View();
        // search = new Search();

        validate = new Validator();
        criteria = new SearchCriteria();
        //view.getPanel().getButton().addActionListener(e -> getCriteriaView());
    }

    /**
     * Method to get all texts from UI and fill the criteria object with
     * required data to search files
     *
     * @throws ParseException
     */
    private void getCriteriaView() throws ParseException {

        // All hardcoded data must be replaced with data read from UI
        String path = "c:\\install";
        if (path != null && validate.validatePath(path)) {
            criteria.setPath(path);
        }

        String fileName = "jenkins-2.143.zip";
        if (fileName != null && validate.validateFileName(fileName)) {
            criteria.setFileName(fileName);
        }

        String fileType = ".java";
        if (fileType != null && validate.validateFileType(fileType)) {
            criteria.setFileExtension(fileType);
        }

        String visibility = "Hidden";
        if (visibility != null) {
            criteria.setFileVisibility(visibility);
        }

        /* file size will be validated an converted to bytes */
        String operator = "greater than";
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

        String owner = "Marco Velasquez";
        if (owner != null && validate.validateOwnerName(owner)) {
            criteria.setFileOwner(owner);
        }

        String content = "any text here";
        if (content != null) {
            criteria.setFileContent(content);
        }

        //search.setCriteria(criteria);
        //search.fileFound();
    }

}
