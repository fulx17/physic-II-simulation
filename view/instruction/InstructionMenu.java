package view.instruction;

import javax.swing.*;
import java.awt.*;
import controller.AppController;

public class InstructionMenu extends JPanel {
    public InstructionMenu(AppController controller) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btn = new JButton("Trang chủ");
        btn.addActionListener(e -> controller.openMenu());
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(btn);
    }
}
