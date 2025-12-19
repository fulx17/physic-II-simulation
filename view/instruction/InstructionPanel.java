package view.instruction;

import javax.swing.*;
import java.awt.*;
import controller.AppController;

public class InstructionPanel extends JPanel{
    public InstructionPanel(AppController controller) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        add(new InstructionHeader(), BorderLayout.NORTH);
        add(new InstructionContent(controller), BorderLayout.CENTER);
    }
}
