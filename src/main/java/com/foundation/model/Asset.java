/*
 *  @(#)Asset.java Copyright (c) 2018 Jalasoft.
 *   2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *   All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *   Jalasoft, ("Confidential Information").  You shall not
 *   disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into
 *   with Jalasoft.
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
 * @version 1.0.0 Nov 2018
 * @author Maria Ledezma
 */

public class Asset extends File {
    private String path;
    private String filename;
    private String size;
    private String owner;
    private String dateCreation;
    private String dateModified;
    private String dateAccessed;
    private boolean hidden;
    private boolean isReadable;

    public Asset(File file){
        super(file.getPath());

        try {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            this.owner = Files.getOwner(file.toPath()).toString();
            this.path = file.getPath();
            this.filename = file.getName();
            this.size =  String.valueOf(file.length());
            this.dateCreation = attr.creationTime().toString();
            this.dateModified = attr.lastModifiedTime().toString();
            this.dateAccessed = attr.lastAccessTime().toString();
            this.hidden = file.isHidden();
            this.isReadable = file.canWrite() ? false : true;

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Getter of the hidden attribute
     * @return the hidden attribute of the file
     */
    @Override
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Getter of the isReadable attribute
     * @return the path of the file
     */
    public boolean isReadable() {
        return isReadable;
    }

    /**
     * Getter of the path attribute
     * @return the path of the file
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * Getter of the file name attribute
     * @return the file name of the file
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Getter of the size attribute
     * @return the size of the file
     */
    public String getSize() {
        return size;
    }

    /**
     * Getter of the owner attribute
     * @return the owner of the file
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Getter of the creation date attribute
     * @return the creation date of the file
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * Getter of the modified date attribute
     * @return the modified date of the file
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * Getter of the accessed date attribute
     * @return the last date of access to the file
     */
    public String getDateAccessed() {
        return dateAccessed;
    }

    /**
     * Getter of the hidden attribute
     * @return the hidden status of the file
     */
    public boolean getHidden() {

        return hidden;
    }

}
