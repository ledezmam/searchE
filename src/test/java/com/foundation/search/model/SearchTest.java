
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

import com.foundation.model.Search;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test class for Search Model that will verify its functionality based on test cases.
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
     * Initializes the environment before running the tests, it will create generic files required for the different
     * tests
     */
    @Before
    public void initialize(){
        String testDirName = "c://test";
        File testDir = new File(testDirName);
        if(!testDir.exists()){
            testDir.mkdir();
        }
        this.createFilesByExtension(testDirName,"testJPG", "jpg", false, 3);
        this.createFilesByExtension(testDirName,"testTXT", "txt", false, 5);
        this.createFilesByExtension(testDirName,"testCSV", "csv", false, 2);
    }

    /**
     * Method that creates files given an extension with or without content
     * @param path The path of the folder where the files will be created.
     * @param patternName The pattern name for the files that will be generated.
     * @param extension The extension of the files that will be generated.
     * @param includeContent The flag that indicates if the the files will include some content.
     * @param numbFiles The number of files that will be generated.
     */
    private void createFilesByExtension(String path, String patternName, String extension, boolean includeContent,
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
     * Method that tests method searchByCriteria when the file does not exist
     */
    @Test
    public void searchByCriteriaWhenAFileDoesNotExist () {
        String path="c://", fileName = "DoesNotExist.txt";
        search = new Search(path, fileName);
        String[] actualFiles = search.searchByCriteria();
        Assert.assertEquals(0, actualFiles.length);
    }

    /**
     * Method that tests method searchByCriteria when a text file exists
     */
    @Test
    public void searchByCriteriaWhenATextFileExists () {
        String path="c://test", fileName = "testTXT0.txt";
        search = new Search(path, fileName);
        String[] actualFiles = search.searchByCriteria();
        Assert.assertEquals(fileName, actualFiles[0]);
    }

    /**
     * Method that tests method searchByCriteria to search for several files that matches the criteria in the name
     */
    @Test
    public void searchByCriteriaForSeveralFilesThatMatchesTheCriteriaByName () {
        String path="c://test", fileName = "testTXT";
        search = new Search(path, fileName);
        String[] actualFiles = search.searchByCriteria();
        String[] expectedFiles = {"testTXT0.txt", "testTXT1.txt", "testTXT2.txt", "testTXT3.txt", "testTXT4.txt"};
        Assert.assertArrayEquals(expectedFiles, actualFiles);
    }
}
