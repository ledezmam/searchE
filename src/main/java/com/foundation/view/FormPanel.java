package com.foundation.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel oneLabel;
    private JLabel twoLabel;
    private JTextField oneField;
    private JTextField twoField;
    private JButton okBtn;
    private FormListener formListener;

    public FormPanel(){
        // check the current preferred Size and set a new one
        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        oneLabel = new JLabel("Field one: ");
        twoLabel = new JLabel("Field two: ");
        oneField = new JTextField(10);
        twoField = new JTextField(10);

        okBtn = new JButton("Ok");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String one = oneField.getText();
                String two = twoField.getText();

                FormEvent event = new FormEvent(this, one, two);

                if(formListener != null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Options");
        Border outerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        // set weight to first row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        // give gc a little space between components
        gc.insets = new Insets(0,0,0,5);
        // use anchor to align the elements of GC to either start or end of the line
        gc.anchor = GridBagConstraints.LINE_END;
        add(oneLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(oneField, gc);

        // set weight to second row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(twoLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(twoField, gc);

        // set weight to third row
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_END;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener){
        this.formListener = listener;

    }
}

