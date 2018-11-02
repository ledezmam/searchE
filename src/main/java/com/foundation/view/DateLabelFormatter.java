/*
 *  @(#)DateLabelFormatter.java Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  <p>
 *  This software is the confidential and proprietary information of
 *  Jalasoft, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package com.foundation.view;

import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Date label Formatter class
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "MM/dd/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    /**
     * String to Value method
     *
     * @param text String value
     * @return Date formatter of the text
     * @throws ParseException
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Value to string method
     *
     * @param value Object value
     * @return Date formatter of the object
     * @throws ParseException
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }
}
