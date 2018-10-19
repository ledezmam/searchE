/*
 * @(#)FormListener.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.foundation.view;

import java.util.EventListener;

/*
 * Interface created for the Event listener
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public interface FormListener extends EventListener {
    public void formEventOccurred(FormEvent e);
}
