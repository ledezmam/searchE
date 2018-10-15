
/*
 * @(#)FormEvent.java Copyright (c) 2018 Jalasoft.
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

import java.util.EventObject;

/*
 * Event class setting with constructor, getter and setter
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class FormEvent extends EventObject {

    private String string;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String string) {
        super(source);
        this.string = string;
    }

    public String getInput() {
        return string;
    }
    public void setInput(String one) {
        this.string = string;
    }


}
