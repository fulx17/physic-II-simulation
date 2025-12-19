

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.AppController;

public class ExperimentPanel extends JPanel {
    private int experimentId;
    private double scale = 1.0;
    private double offsetX = 0, offsetY = 0;
    private Point lastMouse;
    public ExperimentPanel(int experimentId, AppController controller) {
        setLayout(new BorderLayout());
        this.experimentId = experimentId;
        
        JLabel label = new JLabel("Bài " + this.experimentId, SwingConstants.CENTER);

        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(e -> controller.openMenu());
        add(label, BorderLayout.NORTH);
        add(backButton, BorderLayout.SOUTH);

        addMouseWheelListener(e -> {
            Point p = e.getPoint();

            double oldScale = scale;
            double zoomFactor = (e.getWheelRotation() < 0) ? 1.1 : 0.9;
            scale *= zoomFactor;

            scale = Math.max(0.2, Math.min(scale, 5.0));

            double ratio = scale / oldScale;

            offsetX = (p.x - (p.x - offsetX) * ratio);
            offsetY = (p.y - (p.y - offsetY) * ratio);

            repaint();
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastMouse = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                offsetX += e.getX() - lastMouse.x;
                offsetY += e.getY() - lastMouse.y;
                lastMouse = e.getPoint();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(offsetX, offsetY);
        g2.scale(scale, scale);
    }
    // private Panel createExperimentalHeader() {
    //     JPanel panel = new JPanel();
    //     set 
    // }
}