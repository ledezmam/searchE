/*
 *  @(#)FileFound.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 *
 */

package com.foundation.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Class that will define the object that will be returned as a result of a
 * search.
 *
 * @version 1.0.0 Oct 2018
 * @author Maria Ledezma
 */
public class FileFound  extends File{
    private String path;
    private String filename;
    private String size;
    private String owner;
    private String dateCreation;
    private String dateModified;
    private String dateAccessed;
    private boolean hidden;

    /**
     * Constructor of the class
     */
    public FileFound(File file){
        super(file.getPath());

        try {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            this.owner = Files.getOwner(file.toPath()).toString();
            this.path = file.getPath();
            this.filename = file.getName();
            this.size =  String.valueOf(file.getTotalSpace());
            this.dateCreation = attr.creationTime().toString();
            this.dateModified = attr.lastModifiedTime().toString();
            this.dateAccessed = attr.lastAccessTime().toString();
            this.hidden = file.isHidden();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getPath() {
        return path;
    }

    public String getFilename() {
        return filename;
    }

    public String getSize() {
        return size;
    }

    public String getOwner() {
        return owner;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDateAccessed() {
        return dateAccessed;
    }

    public boolean getHidden() {
        return hidden;
    }

}
