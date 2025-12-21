package view.experiment.problem.problem4;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem4Model;

public class Problem4Panel extends BaseExperimentPanel{
    public Problem4Panel(AppController controller) {
        super(controller, new Problem4Model(), 4);
    }

    protected BaseCanvas createCanvas() {
        return new Problem4Canvas(expCtr);
    }

    protected BaseSidebar createSidebar() {
        return new Problem4Sidebar(expCtr);
    }
}
