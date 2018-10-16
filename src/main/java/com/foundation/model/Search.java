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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class that will search in the System based on a criteria.
 *
 * @version 1.0.0 Oct 2018
 * @author Maria Ledezma
 */
public class Search {

    /**
     * resultFiles, the list of files as the result of the search.
     */
      List<File> resultFiles;

    /**
     * Default constructor of the class
     */
    public Search(){
        resultFiles = new ArrayList<File>();
    }

    /**
     * Method that looks for the files that matches the criteria under the path
     * specified
     * @param path The path of the directory to search
     * @param criteria The criteria of the search, it can be a filename,
     *                 extension or part of the name of the files to search.
     * @return A list of files that matched with the criteria
     */
    public List<File> searchFilesByCriteria(String path, String criteria){
        File fileDir = new File(path);
        File[] fileList = fileDir.listFiles();

        if(fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()){
                    searchFilesByCriteria(file.getAbsolutePath(), criteria);
                }
                else {
                    if (file.getName().contains(criteria)){ // por el negativo y un break
                        resultFiles.add(file);
                    }
                }
            }
        }
        return resultFiles;
    }
}
