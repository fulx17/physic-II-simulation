package view.menu;

import javax.swing.*;
import java.awt.*;
import controller.AppController;

public class MenuPanel extends JPanel {
    public MenuPanel(AppController controller) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        add(new MenuHeader(), BorderLayout.NORTH);
        add(new MenuContent(controller), BorderLayout.CENTER);
    }
}
