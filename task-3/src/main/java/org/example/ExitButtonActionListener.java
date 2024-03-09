package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }
}
