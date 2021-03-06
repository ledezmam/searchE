/*
 *  @(#)FileFound.java Copyright (c) 2018 Jalasoft.
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

import java.io.File;

/**
 * Class that will define the object that will be returned as a result of a
 * search.
 *
 * @version 1.0.0 Oct 2018
 * @author Maria Ledezma
 */
public class FileFound  extends Asset{
    /**
     * Constructor of the class
     */
    public FileFound(File file){
        super(file);
    }
}
