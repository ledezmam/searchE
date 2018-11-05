/*
 *  @(#)factoryAsset.java Copyright (c) 2018 Jalasoft.
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
 * Factory class that will create the instance for the asset.
 *
 * @version 1.0.0 Oct 2018
 * @author Maria Ledezma
 */

public class FactoryAsset {

    /**
     * Creates a new instance of the Asset.
     * @param file the file that will be used by the Asset constructor
     * @return a new instance of the Asset
     */
    public static Asset createAsset(File file){
        return new Asset(file);
    }
}
