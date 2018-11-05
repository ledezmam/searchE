/*
 *  @(#)ISearch.java Copyright (c) 2018 Jalasoft.
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

import com.foundation.controller.SearchCriteria;

import java.io.IOException;
import java.util.List;

public interface ISearch {
    List<Asset> searchFilesByCriteria(SearchCriteria criteria) throws IOException;
}
