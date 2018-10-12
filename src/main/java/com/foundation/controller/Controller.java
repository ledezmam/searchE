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

/**
 * Class to integrate View and Search classes
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class Controller {

    /* Class instance variables */
    Validator validate;
    private String path;
    private String fileName;
    private String fileType;

    /**
     * Controller constructor
     */
    public Controller() {
        this.path = "c:\\install";
        this.fileName = "jenkins-2.143.zip";
        this.fileType = ".java";

        validate = new Validator();
    }

    /**
     * Method to read search criteria and call validator methods
     *
     * This method is still in progress
     */
    public void ValidateSearchCriteria() {
        validate.validatePath(this.path);
        validate.validateFileName(this.path);
        validate.validateFileType(this.path);
    }

}
