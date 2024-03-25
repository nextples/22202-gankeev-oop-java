package org.example.view.game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Sea Battle");
        this.setSize(new Dimension(1366, 768));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icon.png")));
        setIconImage(icon.getImage());
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

//    @Override
//    public void setExtendedState(int state){
//
//    }
}
