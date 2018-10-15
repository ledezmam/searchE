
/*
 * @(#)ToolBar.java Copyright (c) 2018 Jalasoft.
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Toolbar class setting with listener and action recognition. Buttons may be used in the future.
 *
 * @Author Ruben Mendoza
 * @Version 1.0
 */

public class ToolBar extends JPanel implements ActionListener {
    private JButton buttonOne;
    private JButton buttonTwo;

    public ToolBar(){
        buttonOne = new JButton("Button1");
        buttonTwo = new JButton("Button2");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(buttonOne);
        add(buttonTwo);

        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);

        setBorder(BorderFactory.createEtchedBorder());

    }

    private StringListener textListener;

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton clicked = (JButton) e.getSource();
        if (clicked == buttonOne){
            if(textListener != null){
                textListener.textEmitted("Button1\n");
            }
        } else if (clicked == buttonTwo){
            if(textListener != null){
                textListener.textEmitted("Button2\n");
            }
        }
    }

}
