package view.menu;

import javax.swing.*;
import java.awt.*;
import controller.AppController;
import constant.ExperimentName;

public class MenuExperimentGrid extends JPanel{
    public MenuExperimentGrid(AppController controller) {
        setLayout(new GridLayout(2, 3, 50, 50));
        for(int i = 1; i <= 6; i++) {
            int experimentId = i;
            String text = "<html><div style='text-align:center;'>" + "Bài số " + experimentId + ": " + ExperimentName.getName(experimentId) + "</div></html>";
                JButton btn = new JButton(text);
                btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
                btn.setPreferredSize(new Dimension(0, 200));
                btn.addActionListener(e -> controller.openExperiment(experimentId));
                add(btn);
            }
    }
}
