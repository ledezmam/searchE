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

import com.foundation.controller.SearchCriteria;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

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
      List<FileFound> resultFiles;

    /**
     * Default constructor of the class
     */
    public Search(){

        resultFiles = new ArrayList<FileFound>();

    }

    /**
     * Method that looks for the files that matches the criteria under the path
     * specified
     * @param criteria The criteria of the search, it can be a filename,
     *                 extension or part of the name of the files to search.
     * @return A list of files that matched with the criteria
     */
    public List<FileFound> searchFilesByCriteria(SearchCriteria criteria){
        File fileDir = new File(criteria.getPath());
        if (!fileDir.exists()){
            return null;
        }
        File[] fileList = fileDir.listFiles();

        if(fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()){
                    criteria.setPath(file.getPath());
                    searchFilesByCriteria(criteria);
                }
                else {
                    //file.getName().contains(criteria)
                    if (doesFileMatchesCriteria(file, criteria)){
                        FileFound fileFound = new FileFound(file);
                        resultFiles.add(fileFound);
                    }
                }
            }
        }
        return resultFiles;
    }

    /**
     * Method that will verify if the file matches the search criteria
     * @param file The file that will be analyzed to check if it matches the
     *             criteria
     * @param criteria The criteria of the search, it can be a filename,
     *                 extension or part of the name of the files to search.
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesFileMatchesCriteria(File file, SearchCriteria criteria) {

        try {
            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            String owner = Files.getOwner(file.toPath()).toString();
            Long size =  file.getTotalSpace();
            FileTime dateCreation = attr.creationTime();
            FileTime dateModified = attr.lastModifiedTime();
            FileTime dateAccessed = attr.lastAccessTime();
            boolean hidden = file.isHidden();

            Date criteriaDateCreated = criteria.getDateCreated();
            Date criteriaDateModified = criteria.getDateModified();
            Date criteriaDateAccessed = criteria.getDateAccessed();

            if(criteria.getFileName() != null && !file.getName().contains(criteria.getFileName())){
                return false;
            }

            if(criteria.getFileExtension() != null && !file.getName().contains(criteria.getFileExtension())){
                return false;
            }

            if(criteria.getFileOwner()!= null && !criteria.getFileOwner().equalsIgnoreCase(owner)){
                return false;
            }

            if (criteriaDateCreated != null && criteriaDateCreated.getTime() != dateCreation.toMillis()){
                return false;
            }

            if (criteriaDateModified != null && criteriaDateModified.getTime() != dateModified.toMillis()){
                return false;
            }

            if (criteriaDateAccessed != null && criteriaDateAccessed.getTime() != dateAccessed.toMillis()){
                return false;
            }

            if (criteria.getFileSize() != null && !doesFileSizeMatch(criteria.getFileSize(), file.length())){
                return false;
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return true;
    }
    private boolean doesFileSizeMatch(Map<String, Long> mapSize, Long currentFileSize){
        for ( String operator : mapSize.keySet() ) {
            switch (operator){
                case "greater than":
                    if (mapSize.get(operator) > currentFileSize){
                        return true;
                    }
                case "less than":
                    if (mapSize.get(operator) < currentFileSize){
                        return true;
                    }
                case "equals":
                    if (mapSize.get(operator) == currentFileSize){
                        return true;
                    }
                default:
                    return false;

            }
        }
        return false;
    }
}
