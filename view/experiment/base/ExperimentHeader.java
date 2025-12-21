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
        backBtn.setFont(getFont());
        
        JLabel label = new JLabel(
            ExperimentName.getName(id),
            SwingConstants.CENTER
        );
        label.setBorder(
            BorderFactory.createEmptyBorder(12, 0, 12, 0)
        );

        JButton hintBtn = new JButton("Gợi ý");
        hintBtn.addActionListener(e -> expCtr.hint());
        
        Font titleFont = new Font("Segoe UI", Font.BOLD, 18);

        label.setFont(titleFont);
        backBtn.setFont(titleFont.deriveFont(14f));
        hintBtn.setFont(titleFont.deriveFont(14f));

        add(backBtn, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
        add(hintBtn, BorderLayout.EAST);
    }    
}
