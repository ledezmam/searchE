/*
 * @(#)Controller.java Copyright (c) 2018 Jalasoft.
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
 * Class to integrate View and Search classes
 *
 * @author Marco Velasquez
 * @version 1.0.
 */
public class Controller {

    /* Class instance variables */
    Validator validate;
    // View view;
    // Search search;

    /**
     * Controller constructor
     */
    public Controller() {
        // view = new View();
        // search = new Search();

        validate = new Validator();
        //view.getPanel().getButton().addActionListener(e -> getCriteriaView());
    }

    private void getCriteriaView() {
        
    }

}
