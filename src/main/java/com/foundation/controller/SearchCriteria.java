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
    private Date dateModifiedStart;
    private Date dateModifiedEnd;
    private Date dateCreatedStart;
    private Date dateCreatedEnd;
    private Date dateAccessedStart;
    private Date dateAccessedEnd;
    private String owner;
    private String content;
    private boolean readOnly;

    /**
     * Class constructor
     */
    public SearchCriteria() {
        path = null;
        fileName = null;
        fileExtension = null;
        visibility = null;
        fileSize = null;
        dateModifiedStart = null;
        dateModifiedEnd = null;
        dateCreatedStart = null;
        dateCreatedEnd = null;
        dateAccessedStart = null;
        dateAccessedEnd = null;
        owner = null;
        content = null;
        readOnly = false;
    }

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
     * Method to set the start date modified of the file
     *
     * @param date start date modified as "MM/DD/YYYY"
     */
    public void setDateModifiedStart(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateModifiedStart = sourceFormat.parse(date);
    }

    /**
     * Method to get the start date modified of the file
     *
     * @return start date modified as "MM/DD/YYYY"
     */
    public Date getDateModifiedStart() {
        return this.dateModifiedStart;
    }

    /**
     * Method to set the start date modified of the file
     *
     * @param date start date modified as "MM/DD/YYYY"
     */
    public void setDateModifiedEnd(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateModifiedEnd = sourceFormat.parse(date);
    }

    /**
     * Method to get the end date modified of the file
     *
     * @return end date modified as "MM/DD/YYYY"
     */
    public Date getDateModifiedEnd() {
        return this.dateModifiedEnd;
    }

    /**
     * Method to set the start date created of the file
     *
     * @param date start date created as "MM/DD/YYYY"
     */
    public void setDateCreatedStart(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateCreatedStart = sourceFormat.parse(date);
    }

    /**
     * Method to get the start date created of the file
     *
     * @return start date created as "MM/DD/YYYY"
     */
    public Date getDateCreatedStart() {
        return this.dateCreatedStart;
    }

    /**
     * Method to set the end date created of the file
     *
     * @param date end date created as "MM/DD/YYYY"
     */
    public void setDateCreatedEnd(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateCreatedEnd = sourceFormat.parse(date);
    }

    /**
     * Method to get the end date created of the file
     *
     * @return end date created as "MM/DD/YYYY"
     */
    public Date getDateCreatedEnd() {
        return this.dateCreatedEnd;
    }

    /**
     * Method to set the start date accessed of the file
     *
     * @param date start date accessed as "MM/DD/YYYY"
     */
    public void setDateAccessedStart(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateAccessedStart = sourceFormat.parse(date);
    }

    /**
     * Method to get the start date accessed of the file
     *
     * @return start date accessed as "MM/DD/YYYY"
     */
    public Date getDateAccessedStart() {
        return this.dateAccessedStart;
    }

    /**
     * Method to set the end date accessed of the file
     *
     * @param date end date accessed as "MM/DD/YYYY"
     */
    public void setDateAccessedEnd(String date) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.dateAccessedEnd = sourceFormat.parse(date);
    }

    /**
     * Method to get the end date accessed of the file
     *
     * @return end date accessed as "MM/DD/YYYY"
     */
    public Date getDateAccessedEnd() {
        return this.dateAccessedEnd;
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

    /**
     * Method to set read only status
     *
     * @param readOnly content of the file
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Method to get the the read only status
     *
     * @return read only status as boolean
     */
    public boolean getReadOnly() {
        return this.readOnly;
    }
}
