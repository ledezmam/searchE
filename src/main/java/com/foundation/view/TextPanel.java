package com.foundation.view;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        // enabling scrollbar for the textArea
        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String text){
        textArea.append(text);
    }

}
