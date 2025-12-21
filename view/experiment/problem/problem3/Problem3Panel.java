package view.experiment.problem.problem3;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem3Model;

public class Problem3Panel extends BaseExperimentPanel{
    public Problem3Panel(AppController controller) {
        super(controller, new Problem3Model(), 4);
    }

    protected BaseCanvas createCanvas() {
        return new Problem3Canvas(expCtr);
    }

    protected BaseSidebar createSidebar() {
        return new Problem3Sidebar(expCtr);
    }
}
