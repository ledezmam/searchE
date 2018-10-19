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

/*
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

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String string) {
        super(source);
        this.string = string;
    }

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

    public String getInput() {
        return string;
    }

    public FileCategory getExtCategory() {
        return extCategory;
    }

    public FileCategory getFileSizeCategory() {
        return fileSizeCategory;
    }

    public FileCategory getDateCreatedCategory() {
        return dateCreatedCategory;
    }

    public FileCategory getDateModifiedCategory() {
        return dateModifiedCategory;
    }

    public FileCategory getDateAccessedCategory() {
        return dateAccessedCategory;
    }

    public FileCategory getFileCompareCategory() {
        return fileCompareCategory;
    }

    public FileCategory getVisibilityCategory() {
        return visibilityCategory;
    }
}
