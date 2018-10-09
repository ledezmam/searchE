/*
 *  @(#)Search.java Copyright (c) 2018 Jalasoft.
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

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class that will search in the System based on a criteria.
 *
 * @version 1.0 0 Oct 2018
 * @author Maria Ledezma
 */
public class Search {

    private String path;
    private String fileName;

    public Search(String path, String fileName){
        this.path = path;
        this.fileName = fileName;
    }

    public List<String> searchByFileName(){
        List<String> result = new ArrayList<String>();

        return result;
    }

}
