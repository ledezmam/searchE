/*
 * @(#)Validator.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package com.foundation.controller;

import java.util.regex.Pattern;

/**
 * Class to validate data entered from View
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class Validator implements IValidator {

    /**
     * Method to validate folder/directory paths are accurate
     *
     * @param path a windows path like: c:\somePath\subPath
     * @return true if the path is correct, otherwise false
     */
    public boolean validatePath(String path) {
        String regEx = "([A-Za-z]\\:\\\\?)(([a-zA-Z_\\-\\s0-9\\.]+\\\\?)+)?";
        Pattern pattern = Pattern.compile(regEx);
        return Pattern.matches(regEx, path);
    }

    /**
     * Method to validate that a file name is accurate
     *
     * @param fileName any file name like: file-name.5.6.exe
     * @return true if the file name is correct, otherwise false
     */
    public boolean validateFileName(String fileName) {
        String regEx = "[^\\:*?\"<>|\r\n]*";
        Pattern pattern = Pattern.compile(regEx);
        return Pattern.matches(regEx, fileName);
    }

    /**
     * Method to validate the extension of a file,
     * this method supports the following extensions:
     * .txt, .gif, .pdf, .doc, .docx, .xls, .xlsx, .xml,
     * .java, .jpg, .bmp, .zip, .exe
     *
     * @param fileType a file extension like: .exe
     * @return true if the file extension is correct, otherwise false
     */
    public boolean validateFileType(String fileType) {
        String regEx = ".(txt|gif|pdf|doc|docx|xls|xlsx|xml|java|jpg|bmp|zip|exe)";
        Pattern pattern = Pattern.compile(regEx);
        return Pattern.matches(regEx, fileType);
    }
}
