/*
 * @(#)SearchFilesMain.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package com.foundation;

import com.foundation.controller.Controller;
import java.text.ParseException;

/**
 * Class that calls MVC classes and run the application
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class SearchFilesMain {

    /**
     *  Main method which executes the application
     *
     * @param args parameters passed from command line
     */
    public static void main(String[] args) throws ParseException {

        Controller controller = new Controller();
        //controller.printResult();
    }
}
