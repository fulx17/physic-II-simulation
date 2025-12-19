import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GraphPanel extends JPanel {

    private double scale = 1.0;
    private double offsetX = 0, offsetY = 0;
    private Point lastMouse;

    public GraphPanel() {
        addMouseWheelListener(e -> {
            scale *= (e.getWheelRotation() < 0) ? 1.1 : 0.9;
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

        // vẽ trục, đồ thị
    }
}
