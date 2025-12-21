package view.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        setTitle("PHYSIC II SIMULATION");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
        setLayout(new BorderLayout());
    }

    public void setContent(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    } 
}