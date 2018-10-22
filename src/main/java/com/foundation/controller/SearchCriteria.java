/*
 * @(#)SearchCriteria.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.foundation.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to create an object for search criteria
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class SearchCriteria {

    private String path;
    private String fileName;
    private String fileExtension;
    private String visibility;
    private Map fileSize;
    private Date dateModified;
    private Date dateCreated;
    private Date dateAccessed;
    private String owner;
    private String content;

    /**
     * Method to set the path of a folder
     *
     * @param path folder/directory name
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Method to get the path of a folder
     *
     * @return folder/directory name
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Method to set the file name
     *
     * @param fileName file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method to get the file name
     *
     * @return file name
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Method to set the file extension
     *
     * @param fileExtension file extension
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * Method to get the file extension
     *
     * @return file extension
     */
    public String getFileExtension() {
        return this.fileExtension;
    }

    /**
     * Method to set the file visibility
     *
     * @param visibility file visibility. e.g.: All, Hidden, Visible
     */
    public void setFileVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * Method to get the file visibility
     *
     * @return the file visibility. e.g.: All, Hidden, Visible
     */
    public String getFileVisibility() {
        return this.visibility;
    }

    /**
     * Method to set the file size and operator
     *
     * @param operator this should be: "greater than", "less than", "equal"
     * @param fileSize A size of the file
     */
    public void setFileSize(String operator, long fileSize) {
        this.fileSize = new HashMap();
        this.fileSize.put(operator, fileSize);
    }

    /**
     * Method to get the file visibility
     *
     * @return file size as a map<operator, size>
     */
    public Map<String, Long> getFileSize() {
        return this.fileSize;
    }

    /**
     * Method to set the date modified of the file
     *
     * @param date date modified as "MM/DD/YYYY"
     */
    public void setDateModified(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateModified = sourceFormat.parse(date);
    }

    /**
     * Method to get the date modified of the file
     *
     * @return date modified as "MM/DD/YYYY"
     */
    public Date getDateModified() {
        return this.dateModified;
    }

    /**
     * Method to set the date created of the file
     *
     * @param date date created as "MM/DD/YYYY"
     */
    public void setDateCreated(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateCreated = sourceFormat.parse(date);
    }

    /**
     * Method to get the date created of the file
     *
     * @return date created as "MM/DD/YYYY"
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Method to set the date accessed of the file
     *
     * @param date date accessed as "MM/DD/YYYY"
     */
    public void setDateAccessed(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateAccessed = sourceFormat.parse(date);
    }

    /**
     * Method to get the date accessed of the file
     *
     * @return date accessed as "MM/DD/YYYY"
     */
    public Date getDateAccessed() {
        return this.dateAccessed;
    }

    /**
     * Method to set the file owner
     *
     * @param fileOwner name of the file owner
     */
    public void setFileOwner(String fileOwner) {
        this.owner = fileOwner;
    }

    /**
     * Method to get the file owner
     *
     * @return name of the file owner
     */
    public String getFileOwner() {
        return this.owner;
    }

    /**
     * Method to set the file content
     *
     * @param fileContent content of the file
     */
    public void setFileContent(String fileContent) {
        this.content = fileContent;
    }

    /**
     * Method to get the file content
     *
     * @return content of the file
     */
    public String getFileContent() {
        return this.content;
    }
}
