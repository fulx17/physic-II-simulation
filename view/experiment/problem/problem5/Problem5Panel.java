package view.experiment.problem.problem5;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem5Model;

public class Problem5Panel extends BaseExperimentPanel{
    public Problem5Panel(AppController controller) {
        super(controller, new Problem5Model(), 5);
    }

    protected BaseCanvas createCanvas() {
        return new Problem5Canvas(expCtr);
    }

    protected BaseSidebar createSidebar() {
        return new Problem5Sidebar(expCtr);
    }
}
