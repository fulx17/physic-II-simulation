package view.menu;

import javax.swing.*;
import controller.AppController;

public class MenuContent extends JPanel{
    public MenuContent(AppController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(160, 100, 0, 100));
        add(new MenuExperimentGrid(controller));
        add(Box.createVerticalStrut(100));
        add(new MenuInstruction(controller));
    }
}
