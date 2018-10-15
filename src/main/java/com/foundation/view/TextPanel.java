
/*
 * @(#)TextPanel.java Copyright (c) 2018 Jalasoft.
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

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/*
 * Panel class setting
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        // enabling scrollbar for the textArea
        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    /*
     * Append text method created for testing purposes
     *
     * @Author Ruben Mendoza
     * @Version 1.0
     */

    public void appendText(String text){
        textArea.append(text);
    }

}
