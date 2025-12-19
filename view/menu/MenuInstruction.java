package view.menu;

import javax.swing.*;
import java.awt.*;
import controller.AppController;

public class MenuInstruction extends JPanel{
    public MenuInstruction(AppController controller) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btn = new JButton("Hướng dẫn");
        btn.addActionListener(e -> controller.openInstruction());
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(btn);
    }
}
