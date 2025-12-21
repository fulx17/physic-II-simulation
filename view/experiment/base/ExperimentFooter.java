package view.experiment.base;

import java.awt.*;
import javax.swing.*;

import controller.CanvasController;

public class ExperimentFooter extends JPanel {

    private JButton addWireBtn;
    private JButton delWireBtn;

    public ExperimentFooter(CanvasController canvasCtr, BaseExperimentPanel panel) {
        setLayout(new BorderLayout());


        addWireBtn = new JButton("Thêm dây");
        styleButton(addWireBtn);
        addWireBtn.addActionListener(e -> canvasCtr.addWire());

        delWireBtn = new JButton("Ghi chú");
        styleButton(delWireBtn);
        delWireBtn.addActionListener(e -> panel.toggleSidebar());

        add(addWireBtn, BorderLayout.WEST);
        add(delWireBtn, BorderLayout.EAST);
    }

    public void styleButton(JButton btn) {
        Font titleFont = new Font("Segoe UI", Font.BOLD, 18);
        btn.setFont(titleFont.deriveFont(14f));
        btn.setBorder(BorderFactory.createCompoundBorder(
            btn.getBorder(),
            BorderFactory.createEmptyBorder(10, 16, 10, 16)
        ));
    }
}
