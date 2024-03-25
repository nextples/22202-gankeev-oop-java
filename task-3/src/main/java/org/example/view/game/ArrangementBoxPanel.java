package org.example.view.game;

import org.example.model.Field;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ArrangementBoxPanel extends JPanel {
    private Field field;
    private HashMap<Integer, Integer> shipConfig;



    public ArrangementBoxPanel(Field field) {
        this.field = field;
        this.shipConfig = field.getConfig();


        this.setLayout(new GridBagLayout());
        this.initBox();
    }

    private void initBox() {
        ButtonGroup buttonGroup = new ButtonGroup();

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : shipConfig.entrySet()) {
            int shipSize = entry.getKey();
            int shipNumb = entry.getValue();

            JRadioButton button = new JRadioButton(shipSize + "-ship ");
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            buttonGroup.add(button);
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            buttonGroup.add(button);

            JTextArea shipNumbText = new JTextArea(String.valueOf(shipNumb));
            shipNumbText.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            shipNumbText.setEditable(false);

            String path = "src/main/resources/ship" +  shipSize + ".png";
            ImageIcon shipIcon = new ImageIcon(path);
            JLabel shipLabel = new JLabel(shipIcon);

            this.add(button, new GridBagConstraints(0, cnt, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            this.add(shipLabel, new GridBagConstraints(1, cnt, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            this.add(shipNumbText, new GridBagConstraints(2, cnt, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 30, 1, 1), 0, 0));

            cnt++;
        }
        this.setBorder(BorderFactory.createLineBorder(new Color(17, 65, 168)));
    }
}
