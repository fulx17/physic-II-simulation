package view.experiment.base;

import java.awt.*;
import javax.swing.*;

import controller.CanvasController;

public class ExperimentFooter extends JPanel{
    private JButton addWireBtn;
    private JButton delWireBtn;
    public ExperimentFooter(CanvasController canvasCtr) {
        setLayout(new BorderLayout());
        addWireBtn = new JButton("Thêm dây");
        addWireBtn.addActionListener(e -> canvasCtr.addWire());

        delWireBtn = new JButton("Xóa dây");
        delWireBtn.addActionListener(e -> {
            canvasCtr.enableDeleteWire();
            delWireBtn.setBackground(Color.BLUE);
        });

        add(addWireBtn, BorderLayout.WEST);
        add(delWireBtn, BorderLayout.EAST);
    }
    public JButton getDelWireBtn() {
        return delWireBtn;
    }
}