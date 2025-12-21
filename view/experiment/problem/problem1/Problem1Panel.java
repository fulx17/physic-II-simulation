package view.experiment.problem.problem1;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem1Model;

public class Problem1Panel extends BaseExperimentPanel{
    public Problem1Panel(AppController controller) {
        super(controller, new Problem1Model(), 1);
    }

    protected BaseCanvas createCanvas() {
        return new Problem1Canvas(expCtr);
    }

    protected BaseSidebar createSidebar() {
        return new Problem1Sidebar(expCtr);
    }
}
