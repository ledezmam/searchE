/*
 * @(#)IValidator.java Copyright (c) 2018 Jalasoft.
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

/**
 * Interface to declare validation methods
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public interface IValidator {

    /**
     * Method declaration to validate folder/directory paths are accurate
     *
     * @param path a windows path like: c:\somePath\subPath
     * @return true if the path is correct, otherwise false
     */
    boolean validatePath(String path);

    /**
     * Method declaration to validate that a file name is accurate
     *
     * @param fileName any file name like: file-name.5.6.exe
     * @return true if the file name is correct, otherwise false
     */
    boolean validateFileName(String fileName);

    /**
     * Method to validate the extension of a file,
     *
     * @param fileType a file extension like: .exe
     * @return true if the file extension is correct, otherwise false
     */
    boolean validateFileType(String fileType);
}
