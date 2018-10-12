/*
 * @(#)ValidatorTest.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.foundation.search.controller;

import com.foundation.controller.Validator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to implement unit tests for Validator controller
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class ValidatorTest {

    /*
     * =============== UNIT TESTS - FOLDER/DIRECTORY ================
     */

    /**
     * Unit test to validate a windows path with dots
     */
    @Test
    public void Validator_validatePath_FolderPathWithDots() {
        Validator validate = new Validator();
        String path = "c:\\install\\test\\text.ese"; /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validatePath(path);
        assertEquals(expected, actual);              /* Unit test assertion*/
    }

    /**
     * Unit test to validate a windows drive letter only
     */
    @Test
    public void Validator_validatePath_FolderPathDriveLetterOnly() {
        Validator validate = new Validator();
        String path = "c:\\";                       /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validatePath(path);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a windows path with invalid characters
     */
    @Test
    public void Validator_validatePath_FolderPathWithInvalidChars() {
        Validator validate = new Validator();
        String path = "c:\\insta<ll\\te:st\\";      /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validatePath(path);
        assertNotEquals(expected, actual);          /* Unit test assertion*/
    }

    /*
     * =============== UNIT TESTS - FILE NAME ================
     */

    /**
     * Unit test to validate a windows file name
     */
    @Test
    public void Validator_validateFileName_FileName() {
        Validator validate = new Validator();
        String file = "jenkins-2.143.zip";          /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateFileName(file);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a windows file without extension
     */
    @Test
    public void Validator_validateFileName_FileNameWithoutExt() {
        Validator validate = new Validator();
        String file = "jenkins-2.143";              /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateFileName(file);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a windows file with dot at the beginning of the name
     */
    @Test
    public void Validator_validateFileName_FileNameDotAtTheBeginning() {
        Validator validate = new Validator();
        String file = ".gitignore";                 /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateFileName(file);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a windows file name with invalid characters
     */
    @Test
    public void Validator_validateFileName_FileNameInvalidChars() {
        Validator validate = new Validator();
        String file = "file:Name.txt";              /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateFileName(file);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /*
     * =============== UNIT TESTS - FILE TYPE/EXTENSION ================
     */

    /**
     * Unit test to validate a valid file extension
     */
    @Test
    public void Validator_validateFileType_FileType() {
        Validator validate = new Validator();
        String extension = ".zip";                  /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateFileType(extension);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate an invalid file extension
     */
    @Test
    public void Validator_validateFileType_WrongFileType() {
        Validator validate = new Validator();
        String extension = ".xyz";                  /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateFileType(extension);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }
}
