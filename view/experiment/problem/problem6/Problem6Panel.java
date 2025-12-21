package view.experiment.problem.problem6;

import controller.AppController;
import view.experiment.base.BaseCanvas;
import view.experiment.base.BaseExperimentPanel;
import view.experiment.base.BaseSidebar;
import model.experiment.problem.Problem6Model;

public class Problem6Panel extends BaseExperimentPanel{
    public Problem6Panel(AppController controller) {
        super(controller, new Problem6Model(), 6);
    }

    protected BaseCanvas createCanvas() {
        return new Problem6Canvas(expCtr);
    }

    protected BaseSidebar createSidebar() {
        return new Problem6Sidebar(expCtr);
    }
}
