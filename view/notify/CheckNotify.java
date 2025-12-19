package view.notify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckNotify extends JWindow {
    
    public CheckNotify(JFrame parent, String message) {
        // Thiết lập layout và màu sắc
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(50, 50, 50, 220)); // Màu xám đậm, hơi trong suốt
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel label = new JLabel(message);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(label);
        add(panel);
        pack();

        // 1. Vị trí: Hiển thị ở giữa phía dưới của frame chính
        int x = parent.getX() + (parent.getWidth() - getWidth()) / 2;
        int y = parent.getY() + parent.getHeight() - getHeight() - 50;
        setLocation(x, y);

        // 2. Biến mất khi bấm vào thông báo
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });

        // 3. Tự động biến mất sau 5 giây
        Timer timer = new Timer(5000, e -> {
            dispose();
        });
        timer.setRepeats(false);
        timer.start();

        setVisible(true);
    }
}