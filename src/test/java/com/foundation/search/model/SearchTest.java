
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
import com.foundation.model.Asset;
import com.foundation.model.Search;
import org.junit.Assert;
import org.junit.Test;

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
     * Method that tests method searchFilesByCriteria when the file does not
     * exist
     */
    @Test
    public void searchFilesByCriteriaWhenAFileDoesNotExist () {
        try {
            String path="src/test/java/com/foundation/search/test", fileName = "DoesNotExist.txt";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            Assert.assertEquals(0, actualFiles.size());
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests method searchFilesByCriteria when the path does not
     * exist
     */
    @Test
    public void searchFilesByCriteriaWhenPathDoesNotExist () {
        IOException exception = null;
        try {
            String path="", fileName = "testJPG2.jpg";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);

        } catch (IOException e) {
            exception = e;
        }

        Assert.assertNotNull(exception);
    }

    /**
     * Method that tests method searchByCriteria when a text file exists
     */
    @Test
    public void searchFilesByCriteriaWhenATextFileExists () {
        try{
            String path="src/test/java/com/foundation/search/test", fileName = "testTXT0.txt";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            Assert.assertEquals("testTXT0.txt",
                    actualFiles.get(0).getFilename());
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests method searchFilesByCriteria to search for several
     * files that matches the criteria in the name
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaByName () {
        try{
            String path="src/test/java/com/foundation/search/test", fileName = "testTXT";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset>  actualFiles = search.searchFilesByCriteria(criteria);
            String expectedFiles = "testTXT";
            int i = 0;
            for (Asset file: actualFiles) {
                Assert.assertEquals(expectedFiles + Integer.toString(i) + ".txt", file.getFilename());
                i++;
            }
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search for files that
     * matches the criteria in directories and subdirectories.
     */
    @Test
    public void searchFilesByCriteriaThatMatchesTheCriteriaInDirAndSubDir () {
        try{
            String path="src/test/java/com/foundation/search/test", fileName = "testcsv0.csv";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset>  actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 3;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search by extension
     */
    @Test
    public void searchFilesByCriteriaGivenAnExtension () {
        try{
            String path="src/test/java/com/foundation/search/test", extension = ".csv";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileExtension(extension);
            List<Asset>  actualFiles = search.searchFilesByCriteria(criteria);
            List<String> expectedFiles = new ArrayList<>();
            expectedFiles.add("testCSV0.csv");
            expectedFiles.add("testCSV0.csv");
            expectedFiles.add("testCSV0.csv");
            expectedFiles.add("testCSV1.csv");

            for (int i = 0; i < expectedFiles.size(); i++) {
                Assert.assertEquals(actualFiles.get(i).getFilename(), expectedFiles.get(i));
            }
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search by hidden
     */
    @Test
    public void searchFilesByCriteriaWhenAFileIsHidden () {
        try{
            String path="src/test/java/com/foundation/search/test",
                    visibility = "Hidden";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileVisibility(visibility);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            List<String> expectedFiles = new ArrayList<>();
            expectedFiles.add("docHidden.docx");
            expectedFiles.add("FileHidden.bmp");
            for (int i = 0; i < expectedFiles.size(); i++) {
                Assert.assertEquals(actualFiles.get(i).getFilename(), expectedFiles.get(i));
            }
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests method searchFilesByCriteria to search by name when
     * file and directory match the criteria in the name
     */
    @Test
    public void searchFilesByCriteriaWhenFileAndDirMatchNameCriteria () {
        try{
            String path="src/test/java/com/foundation/search/test",
                    fileName = "samename";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileName(fileName);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 2;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests method searchFilesByCriteria to search by owner
     */
    @Test
    public void searchFilesByCriteriaGivenAnOwnerName () {
        try{
            String path="src/test/java/com/foundation/search/test",
                    owner = "Admin";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileOwner(owner);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 20;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search by more than one
     * condition
     */
    @Test
    public void searchFilesByCriteriaGivenSeveralConditions () {
        try{
            String path="src/test/java/com/foundation/search/test",
                    extension = ".docx", visibility = "Hidden";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileExtension(extension);
            criteria.setFileVisibility(visibility);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            List<String> expectedFiles = new ArrayList<>();
            expectedFiles.add("docHidden.docx");

            for (int i = 0; i < expectedFiles.size(); i++) {
                Assert.assertEquals(actualFiles.get(i).getFilename(), expectedFiles.get(i));
            }
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search by read-only criteria
     */
    @Test
    public void searchFilesByReadOnlyCriteria() {
        try{
            String path="src/test/java/com/foundation/search/test";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setReadOnly(true);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            List<String> expectedFiles = new ArrayList<>();
            expectedFiles.add("OtherFile.docx");
            expectedFiles.add("testCSV0.csv");

            for (int i = 0; i < expectedFiles.size(); i++) {
                Assert.assertEquals(actualFiles.get(i).getFilename(), expectedFiles.get(i));
            }
        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search files that are less
     * than 60 KB
     */
    @Test
    public void searchFilesByCriteriaWhenASizeIsSpecifiedLessThan60KB() {
        try{
            String path="src/test/java/com/foundation/search/test";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileSize("less than",60000);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 15;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());

        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search files that are greater
     * than 60 KB
     */
    @Test
    public void searchFilesByCriteriaWhenASizeIsSpecifiedGreaterThan60KB() {
        try{
            String path="src/test/java/com/foundation/search/test";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileSize("greater than",60000);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 2;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());

        } catch (IOException e) {

        }
    }

    /**
     * Method that tests searchFilesByCriteria to search files that are equals
     * to 0 KB
     */
    @Test
    public void searchFilesByCriteriaWhenASizeIsEqualsTo0KB() {
        try{
            String path="src/test/java/com/foundation/search/test";
            search = new Search();
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPath(path);
            criteria.setFileSize("equals to",0);
            List<Asset> actualFiles = search.searchFilesByCriteria(criteria);
            int expectedSizeFiles = 14;
            Assert.assertEquals(expectedSizeFiles, actualFiles.size());

        } catch (IOException e) {

        }
    }
}
