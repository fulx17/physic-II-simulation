package view.experiment.problem.problem2;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem2Model;

public class Problem2Panel extends BaseExperimentPanel{
    public Problem2Panel(AppController controller) {
        super(controller, new Problem2Model(), 2);
    }

    protected BaseCanvas createCanvas() {
        return new Problem2Canvas(expCtr);
    }
    protected BaseSidebar createSidebar() {
        return new Problem2Sidebar(expCtr);
    }
}
