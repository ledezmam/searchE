package com.foundation.view;

import javax.swing.*;

public class App {

    public static void main(String[] args){

        // run swing on a thread to avoid possible multithreading problems
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new View();
            }
        });
    }
}
