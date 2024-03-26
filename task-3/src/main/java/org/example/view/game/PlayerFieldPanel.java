package org.example.view.game;

import org.example.event.Event;
import org.example.model.Field;

import java.awt.*;

import static org.example.model.Cell.*;

public class PlayerFieldPanel extends FieldPanel {
    public PlayerFieldPanel(Field field) {
        super(field);
    }

    @Override
    protected Color getColorByCellStatus(int status) {
        return switch (status) {
            case CELL_WATER -> Color.CYAN;
            case CELL_WELL -> Color.GREEN;
            case CELL_INJURED -> Color.ORANGE;
            case CELL_KILLED -> Color.RED;
            case CELL_MISSED -> Color.GRAY;
            default -> null;
        };
    }

    @Override
    public void update(Event event) {

    }
}
