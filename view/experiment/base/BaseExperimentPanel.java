package view.experiment.base;

import javax.swing.*;
import java.awt.*;
import controller.AppController;
import model.experiment.base.BaseExperimentModel;
import controller.ExperimentController;

public abstract class BaseExperimentPanel extends JPanel{
    
    protected ExperimentController expCtr;
    protected ExperimentFooter footer;
    public BaseExperimentPanel(AppController controller, BaseExperimentModel model, int id) {
        expCtr = new ExperimentController(controller, this, model);
        setLayout(new BorderLayout());
        
        // header
        ExperimentHeader header = new ExperimentHeader(controller, expCtr, id);

        // canvas
        BaseCanvas canvas = createCanvas();

        // footer
        footer = new ExperimentFooter(canvas.canvasCtr);
        expCtr.addVersionChecker();

        // layout
        add(header, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }
    public ExperimentFooter getFooter() {
        return footer;
    }
    protected abstract BaseCanvas createCanvas();
}
