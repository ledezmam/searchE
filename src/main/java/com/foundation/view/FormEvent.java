/*
 * @(#)FormEvent.java Copyright (c) 2018 Jalasoft.
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
import java.util.EventObject;

/**
 * Event class setting with constructor, getter and setter
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class FormEvent extends EventObject {

    private String string;
    private FileCategory extCategory, visibilityCategory, fileSizeCategory,
            dateCreatedCategory, dateModifiedCategory, dateAccessedCategory,
            fileCompareCategory;

    /**
     * Form event constructor with Source only
     *
     * @param source gets the Source from the event
     */
    public FormEvent(Object source) {
        super(source);
    }

    /**
     * Form event constructor with Source and String
     *
     * @param source gets the Source from the event
     * @param string gets the String from the event
     */
    public FormEvent(Object source, String string) {
        super(source);
        this.string = string;
    }

    /**
     * Form event constructor used by the Search Button
     *
     * @param source gets the Source from the event
     * @param string gets the String from the event
     * @param extCategory gets the Extension from the event
     * @param visibilityCategory gets the Visibility from the event
     * @param fileSizeCategory gets the File Size from the event
     * @param dateCreatedCategory gets the Date Created from the event
     * @param dateModifiedCategory gets the Date Modified from the event
     * @param dateAccessedCategory gets the Date Accessed from the event
     * @param fileCompareCategory gets the Comparator from the event
     */
    public FormEvent(Object source, String string, FileCategory extCategory,
                     FileCategory visibilityCategory, FileCategory fileSizeCategory,
                     FileCategory dateCreatedCategory, FileCategory dateModifiedCategory,
                     FileCategory dateAccessedCategory, FileCategory fileCompareCategory) {
        super(source);
        this.string = string;
        this.extCategory = extCategory;
        this.visibilityCategory = visibilityCategory;
        this.fileSizeCategory = fileSizeCategory;
        this.dateCreatedCategory = dateCreatedCategory;
        this.dateModifiedCategory = dateModifiedCategory;
        this.dateAccessedCategory = dateAccessedCategory;
        this.fileCompareCategory = fileCompareCategory;
    }

    /**
     * String input getter
     *
     * @return string input
     */
    public String getInput() {
        return string;
    }

    /**
     * Extension category getter
     *
     * @return extension category
     */
    public FileCategory getExtCategory() {
        return extCategory;
    }

    /**
     * File size getter
     *
     * @return File size category
     */
    public FileCategory getFileSizeCategory() {
        return fileSizeCategory;
    }

    /**
     * Date created getter
     *
     * @return Date created category
     */
    public FileCategory getDateCreatedCategory() {
        return dateCreatedCategory;
    }

    /**
     * Date modified getter
     *
     * @return date modified category
     */
    public FileCategory getDateModifiedCategory() {
        return dateModifiedCategory;
    }

    /**
     * Date accessed getter
     *
     * @return date accessed category
     */
    public FileCategory getDateAccessedCategory() {
        return dateAccessedCategory;
    }

    /**
     * File comparator getter
     *
     * @return File comparator category
     */
    public FileCategory getFileCompareCategory() {
        return fileCompareCategory;
    }

    /**
     * Visibility getter
     *
     * @return file Visibility category
     */
    public FileCategory getVisibilityCategory() {
        return visibilityCategory;
    }
}
