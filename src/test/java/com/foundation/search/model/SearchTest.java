
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

import com.foundation.model.FileFound;
import com.foundation.model.Search;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
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
     * Initializes the environment before running the tests, it will create
     * generic files required for the different
     * tests
     */
    @Before
    public void initialize(){
        String testDirName = "c://test";
        String subDirName1 = testDirName + "/subDir1";
        String subDirName2 = subDirName1 + "/subDir1";
        File testDir = new File(testDirName);
        File subDir1 = new File(subDirName1);
        File subDir2 = new File(subDirName2);
        if(!testDir.exists()){
            testDir.mkdir();
            subDir1.mkdir();
            subDir2.mkdir();
        }
        this.createFilesByExtension(testDirName,"testJPG", "jpg",false, 3);
        this.createFilesByExtension(testDirName,"testTXT", "txt",false, 5);
        this.createFilesByExtension(testDirName,"testCSV", "csv",false, 2);
        this.createFilesByExtension(subDirName1,"testCSV", "csv",false, 1);
        this.createFilesByExtension(subDirName2,"testCSV", "csv",false, 1);
    }

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
        String path="c://test", fileName = "DoesNotExist.txt";
        search = new Search();
        List<FileFound> actualFiles = search.searchFilesByCriteria(path, fileName);
        Assert.assertEquals(0, actualFiles.size());
    }

    /**
     * Method that tests method searchByCriteria when a text file exists
     */
    @Test
    public void searchFilesByCriteriaWhenATextFileExists () {
        String path="c://test", fileName = "testTXT0.txt";
        search = new Search();
        List<FileFound> actualFiles = search.searchFilesByCriteria(path, fileName);
        System.out.println(actualFiles.size());
        Assert.assertEquals("c:\\test\\testTXT0.txt",
                actualFiles.get(0).getAbsolutePath());
    }

    /**
     * Method that tests method searchFilesByCriteria to search for several
     * files that matches the criteria in the name
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaByName () {
        String path="c://test", fileName = "testTXT";
        search = new Search();
        List<FileFound>  actualFiles = search.searchFilesByCriteria(path, fileName);
        String expectedFiles = "[c:\\test\\testTXT0.txt," +
                " c:\\test\\testTXT1.txt, c:\\test\\testTXT2.txt," +
                " c:\\test\\testTXT3.txt, c:\\test\\testTXT4.txt]";
        Assert.assertEquals(expectedFiles, actualFiles.toString());
    }

    /**
     * Method that tests searchFilesByCriteria to search for files that
     * matches the criteria in directories and subdirectories
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaInDirAndSubDir () {
        String path="c://test", fileName = "testCSV0.csv";
        search = new Search();
        List<FileFound>  actualFiles = search.searchFilesByCriteria(path, fileName);
        String expectedFiles = "[c:\\test\\subDir1\\subDir1\\testCSV0.csv," +
                " c:\\test\\subDir1\\testCSV0.csv, c:\\test\\testCSV0.csv]";
        Assert.assertEquals(expectedFiles, actualFiles.toString());
    }
}
