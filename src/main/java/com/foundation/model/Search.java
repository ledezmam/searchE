/*
 *  @(#)Search.java Copyright (c) 2018 Jalasoft.
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

import java.io.*;

/**
 * Model class that will search in the System based on a criteria.
 *
 * @version 1.0 0 Oct 2018
 * @author Maria Ledezma
 */
public class Search {

    /**
     * path, it is the directory to search
     * criteria, the criteria of the search, it can be a filename, extension or part of the name of the files to search.
     */
    private String path;
    private String criteria;

    /**
     * Constructor of the class that initializes the path and criteria that will be used in the search.
     * @param path The path of the directory to search
     * @param criteria The criteria of the search, it can be a filename, extension or part of the name of the files to
     *                 search.
     */
    public Search(String path, String criteria){
        this.path = path;
        this.criteria = criteria;
    }

    /**
     * Method that looks for the files that matches the criteria under the path specified
     * @return A list of files that matched with the criteria
     */
    public String[] searchByCriteria(){
        File fileDir = new File(this.path);
        FilenameFilter filter = new FilenameFilter(){
            public boolean accept(File fileDir, String name){
                return name.contains(criteria);
            }
        };
        return fileDir.list(filter);
    }

}
