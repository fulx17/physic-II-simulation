package view.menu;

import javax.swing.*;
import java.awt.*;

public class MenuHeader extends JPanel{
    public MenuHeader() {
        setLayout(new BorderLayout());
        setBackground(new Color(230,230,230));
        setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        JLabel title = new JLabel(
            "Giả lập thí nghiệm Vật lí Đại cương II",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(title);
    }
}
