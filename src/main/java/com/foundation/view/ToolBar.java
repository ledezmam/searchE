package com.foundation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

