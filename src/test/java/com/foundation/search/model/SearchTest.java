
/*
 *  @(#)SearchTest.java Copyright (c) 2018 Jalasoft.
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

package com.foundation.search.model;

import com.foundation.controller.SearchCriteria;
import com.foundation.model.FileFound;
import com.foundation.model.Search;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Search Model that will verify its functionality based on test
 * cases.
 *
 * @version 1.0 0 Oct 2018
 * @author Maria Ledezma
 */
public class SearchTest {

    /**
     *  Search object that will be tested.
     */
    Search search;

    /**
     * Method that creates files given an extension with or without content
     * @param path The path of the folder where the files will be created.
     * @param patternName The pattern name for the files that will be generated.
     * @param extension The extension of the files that will be generated.
     * @param includeContent The flag that indicates if the the files will
     *                       include some content.
     * @param numbFiles The number of files that will be generated.
     */
    private void createFilesByExtension(String path, String patternName,
                                        String extension, boolean includeContent,
                                        int numbFiles) {

        for (int i = 0; i < numbFiles; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(patternName);
            sb.append(i);
            sb.append('.');
            sb.append(extension);
            String fileName = sb.toString();
            try{
                File file = new File(path + "/" + fileName);
                if (!file.exists()){
                    file.createNewFile();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that tests method searchFilesByCriteria when the file does not
     * exist
     */
    @Test
    public void searchFilesByCriteriaWhenAFileDoesNotExist () {
        String path="src/test/java/com/foundation/search/test", fileName = "DoesNotExist.txt";
        search = new Search();
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath(path);
        criteria.setFileName(fileName);
        List<FileFound> actualFiles = search.searchFilesByCriteria(criteria);
        Assert.assertEquals(0, actualFiles.size());
    }

    /**
     * Method that tests method searchByCriteria when a text file exists
     */
    @Test
    public void searchFilesByCriteriaWhenATextFileExists () {
        String path="src/test/java/com/foundation/search/test", fileName = "testTXT0.txt";
        search = new Search();
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath(path);
        criteria.setFileName(fileName);
        List<FileFound> actualFiles = search.searchFilesByCriteria(criteria);
        Assert.assertEquals("testTXT0.txt",
                actualFiles.get(0).getFilename());
    }

    /**
     * Method that tests method searchFilesByCriteria to search for several
     * files that matches the criteria in the name
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaByName () {
        String path="src/test/java/com/foundation/search/test", fileName = "testTXT";
        search = new Search();
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath(path);
        criteria.setFileName(fileName);
        List<FileFound>  actualFiles = search.searchFilesByCriteria(criteria);
        String expectedFiles = "testTXT";
        int i = 0;
        for (FileFound file: actualFiles) {
            Assert.assertEquals(expectedFiles + Integer.toString(i) + ".txt", file.getFilename());
            i++;
        }
    }

    /**
     * Method that tests searchFilesByCriteria to search for files that
     * matches the criteria in directories and subdirectories.
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaInDirAndSubDir () {
        String path="src/test/java/com/foundation/search/test", fileName = "testCSV0.csv";
        search = new Search();
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath(path);
        criteria.setFileName(fileName);
        List<FileFound>  actualFiles = search.searchFilesByCriteria(criteria);
        int expectedSizeFiles = 3;
        Assert.assertEquals(expectedSizeFiles, actualFiles.size());
    }

    /**
     * Method that tests searchFilesByCriteria to search by extension
     */
    @Test
    public void searchFilesByCriteriaGivenAnExtension () {
        String path="src/test/java/com/foundation/search/test", extension = ".csv";
        search = new Search();
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath(path);
        criteria.setFileExtension(extension);
        List<FileFound>  actualFiles = search.searchFilesByCriteria(criteria);
        List<String> expectedFiles = new ArrayList<>();
        expectedFiles.add("testCSV0.csv");
        expectedFiles.add("testCSV0.csv");
        expectedFiles.add("testCSV0.csv");
        expectedFiles.add("testCSV1.csv");

        for (int i = 0; i < expectedFiles.size(); i++) {
            Assert.assertEquals(actualFiles.get(i).getFilename(), expectedFiles.get(i));
        }
    }
}
