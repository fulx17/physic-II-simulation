package view.instruction;

import javax.swing.*;
import controller.AppController;

public class InstructionContent extends JPanel{
    public InstructionContent(AppController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60, 100, 0, 100));
        add(new InstructionTextPanel());
        add(Box.createVerticalStrut(100));
        add(new InstructionMenu(controller));
    } 
}