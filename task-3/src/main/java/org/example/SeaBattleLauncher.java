package org.example;

import org.example.view.menu.StartMenu;

import javax.swing.*;

public class SeaBattleLauncher {
//    private final StartMenu startMenu;

    public SeaBattleLauncher() {
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        StartMenu startMenu = new StartMenu();
        startMenu.init();
    }
}
