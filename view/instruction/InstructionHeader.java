package view.instruction;

import javax.swing.*;
import java.awt.*;

public class InstructionHeader extends JPanel{
    public InstructionHeader() {
        setLayout(new BorderLayout());
        setBackground(new Color(230,230,230));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        JLabel title = new JLabel(
            "Hướng dẫn",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(title);
    }
}
