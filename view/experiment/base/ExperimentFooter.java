package view.experiment.base;

import java.awt.*;
import javax.swing.*;

import controller.CanvasController;

public class ExperimentFooter extends JPanel{
    public ExperimentFooter(CanvasController canvasCtr) {
        setLayout(new BorderLayout());
        JButton addWireBtn = new JButton("Thêm dây");
        addWireBtn.addActionListener(e -> canvasCtr.addWire());

        JButton delWireBtn = new JButton("Xóa dây");
        delWireBtn.addActionListener(e -> canvasCtr.enableDeleteWire());
    }
}