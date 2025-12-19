package view.experiment.base;

import javax.swing.*;

import constant.ExperimentName;

import java.awt.*;
import controller.AppController;
import controller.ExperimentController;

public class ExperimentHeader extends JPanel{
    public ExperimentHeader(AppController controller, ExperimentController expCtr, int id) {
        setLayout(new BorderLayout());

        JButton backBtn = new JButton("Trang chủ");
        backBtn.addActionListener(e -> controller.openMenu());
        
        JLabel label = new JLabel(
            ExperimentName.getName(id),
            SwingConstants.CENTER
        );

        JButton hintBtn = new JButton("Gợi ý");
        hintBtn.addActionListener(e -> expCtr.hint());
        
        add(backBtn, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
        add(hintBtn, BorderLayout.EAST);
    }    
}
