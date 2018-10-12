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
import org.junit.Before;
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

    Validator validate;

    /**
     * Method executed before each unit test
     */
    @Before
    public void executeBeforeEachTest() {
        validate = new Validator();
    }

    /*
     * =============== UNIT TESTS - FOLDER/DIRECTORY ================
     */

    /**
     * Unit test to validate a windows path with dots
     */
    @Test
    public void Validator_validatePath_FolderPathWithDots() {
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
        String extension = ".xyz";                  /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateFileType(extension);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /*
     * =============== UNIT TESTS - FILE SIZE ARE DIGITS ================
     */

    /**
     * Unit test to validate file size parameters are digits
     */
    @Test
    public void Validator_validateFileSize_FileSizeWithDigits() {
        String fileSize = "1025";                   /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateFileSize(fileSize);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate file size parameters are digits
     */
    @Test
    public void Validator_validateFileSize_FileSizeMixedWithChars() {
        String fileSize = "1b0a25";                 /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateFileSize(fileSize);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate file size parameters are digits
     */
    @Test
    public void Validator_validateFileSize_FileSizeWithSpecialChars() {
        String fileSize = "1<0:2|5";                /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateFileSize(fileSize);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /*
     * =============== UNIT TESTS - DATES MM/DD/YYYY ================
     */

    /**
     * Unit test to validate a correct date format MM/DD/YYYY
     */
    @Test
    public void Validator_validateDate_CorrectDate() {
        String date = "10/12/2018";                 /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateDate(date);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate an incorrect date format MM/DD/YYYY
     */
    @Test
    public void Validator_validateDate_IncorrectDate() {
        String date = "13/12/2018";                 /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateDate(date);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate an incorrect date
     */
    @Test
    public void Validator_validateDate_AnyText() {
        String date = "1s-dd20AA";                  /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateDate(date);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate an incorrect date format
     */
    @Test
    public void Validator_validateDate_IncorrectFormat() {
        String date = "2018/12/10";                 /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateDate(date);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /*
     * =============== UNIT TESTS - OWNER NAME ================
     */

    /**
     * Unit test to validate a correct name
     */
    @Test
    public void Validator_validateOwnerName_CorrectName() {
        String name = "Marco Velasquez";            /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateOwnerName(name);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a correct name with dots
     */
    @Test
    public void Validator_validateOwnerName_CorrectNameWithDots() {
        String name = "Maria A. Ledezma";           /* value to be evaluated */
        boolean expected = true;
        boolean actual = validate.validateOwnerName(name);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate an incorrect name
     */
    @Test
    public void Validator_validateOwnerName_IncorrectName() {
        String name = "MA";                         /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateOwnerName(name);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }

    /**
     * Unit test to validate a name with special characters
     */
    @Test
    public void Validator_validateOwnerName_NameWithInvalidChars() {
        String name = "Marco <:>Velasquez";         /* value to be evaluated */
        boolean expected = false;
        boolean actual = validate.validateOwnerName(name);
        assertEquals(expected, actual);             /* Unit test assertion*/
    }
}
