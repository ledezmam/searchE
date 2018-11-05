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
public class Search implements ISearch {

    /**
     * resultFiles, the list of files as the result of the search.
     */
      List<Asset> resultFiles;

    /**
     * Default constructor of the class
     */
    public Search(){

        resultFiles = new ArrayList<>();

    }

    /**
     * Method that cleans ups the list of results
     */
    public void resetResults(){
        this.resultFiles.clear();
    }

    /**
     * Method that looks for the files that matches the criteria under the path
     * specified
     * @param criteria The criteria of the search, it can be a filename,
     *                 extension or part of the name of the files to search.
     * @return A list of files that matched with the criteria
     */
    public List<Asset> searchFilesByCriteria(SearchCriteria criteria)
            throws IOException{
        File fileDir = new File(criteria.getPath());
        if (criteria.getPath().isEmpty()){
            throw new IOException("Search path was not set!");
        }
        if (!fileDir.exists()){
            return null;
        }
        File[] fileList = fileDir.listFiles();

        if(fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()){
                    if (doesFileMatchesCriteria(file, criteria)){
                        resultFiles.add(FactoryAsset.createAsset(file));
                    }
                    criteria.setPath(file.getPath());
                    searchFilesByCriteria(criteria);
                }
                else {
                    if (doesFileMatchesCriteria(file, criteria)){
                        resultFiles.add(FactoryAsset.createAsset(file));
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
        boolean match = true;
        try {

            BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                    BasicFileAttributes.class);
            String owner = Files.getOwner(file.toPath()).getName();
            FileTime dateCreation = attr.creationTime();
            FileTime dateModified = attr.lastModifiedTime();
            FileTime dateAccessed = attr.lastAccessTime();
            Date startDateCreatedCrit = criteria.getDateCreatedStart();
            Date endDateCreatedCrit = criteria.getDateCreatedEnd();
            Date startDateModifiedCrit = criteria.getDateModifiedStart();
            Date endDateModifiedCrit = criteria.getDateModifiedEnd();
            Date startDateAccessedCrit = criteria.getDateAccessedStart();
            Date endDateAccessedCrit = criteria.getDateAccessedEnd();

            if(criteria.getFileName() != null && !doesFileMatchesName(file.getName(), criteria.getFileName())){
                match = false;
            }

            if(criteria.getFileExtension() != null && !doesFileMatchesExtension(file.getName(), criteria.getFileExtension())){
                match = false;
            }

            if(criteria.getFileOwner()!= null && !owner.contains(criteria.getFileOwner())){
                match = false;
            }

            if (startDateCreatedCrit != null && !doesDateMatchCriteria(startDateCreatedCrit, endDateCreatedCrit, dateCreation)){
                match = false;
            }

            if (startDateModifiedCrit != null && !doesDateMatchCriteria(startDateModifiedCrit, endDateModifiedCrit, dateModified)){
                match = false;
            }

            if (startDateAccessedCrit != null && !doesDateMatchCriteria(startDateAccessedCrit, endDateAccessedCrit, dateAccessed)){
                match = false;
            }

            if (criteria.getFileSize() != null && !doesFileSizeMatch(criteria.getFileSize(), file)){
                match = false;
            }
            if (criteria.getFileVisibility() != null && !doesFileMatchVisibility(criteria.getFileVisibility(), file)){
                match = false;
            }
            if (criteria.getReadOnly() != false && file.canWrite()){
                match = false;
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return match;
    }

    /**
     * Method that will verify if the file matches the name criteria
     * @param fileName The file name that will be analyzed to check if it
     *                 matches the name criteria
     * @param critName The name criteria of the search, it can be partial name
     *                 or full name
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesFileMatchesName(String fileName, String critName){
        boolean match = false;
        if (fileName.matches("(?i).*" + critName + ".*")){
            match =  true;
        }
        return match;
    }

    /**
     * Method that will verify if the file matches the extension criteria
     * @param fileName The file name that will be analyzed to check if it
     *                 matches the  extension criteria
     * @param critExt The extension criteria of the search to be matched
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesFileMatchesExtension(String fileName, String critExt){
        boolean match = false;
        if (fileName.matches("(?i).*" + critExt)){
            match =  true;
        }
        return match;
    }

    /**
     * Method that will verify if the file matches the size criteria
     * @param mapSize The map that contains the operator and target size to be
     *                compared
     * @param file the current size of the file that is being
     *                        analyzed
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesFileSizeMatch(Map<String, Long> mapSize, File file){
        boolean match = false;
        if (!file.isDirectory()){
            Long currentFileSize = file.length();
            for ( String operator : mapSize.keySet() ) {
                switch (operator){
                    case "greater than":
                        if (currentFileSize > mapSize.get(operator)){
                            match = true;
                        }
                        break;
                    case "less than":
                        if (currentFileSize < mapSize.get(operator)){
                            match = true;
                        }
                        break;
                    case "equals to":
                        if (mapSize.get(operator) == currentFileSize){
                            match = true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return match;
    }

    /**
     * Method that will verify if the file matches the visibility criteria
     * @param visibility it can be public or hidden
     * @param file the file that is being analyzed to check its visibility
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesFileMatchVisibility(String visibility, File file){
        boolean match = false;
        if (visibility.equalsIgnoreCase("public")){
            if (file.isHidden() == false){
                match = true;
            }
        }else{
            if (file.isHidden() == true){
                match = true;
            }
        }
        return match;
    }

    /**
     * Method that will verify if the file date is between the given start date
     * and end date of the search criteria.
     * @param startDateCrit start date that comes from the criteria
     * @param endDateCrit end date that comes from the criteria
     * @param fileTime represents the value of a file's time stamp
     * @return true if the files matches the criteria and false if not.
     */
    private boolean doesDateMatchCriteria(Date startDateCrit, Date endDateCrit, FileTime fileTime){
        boolean match = false;

        if (fileTime.toMillis() >= startDateCrit.getTime() && fileTime.toMillis() <= endDateCrit.getTime() ){
            match = true;
        }
        return match;
    }
}
