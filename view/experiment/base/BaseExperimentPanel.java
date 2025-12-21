package view.experiment.base;

import javax.swing.*;
import java.awt.*;

import controller.AppController;
import controller.CanvasController;
import controller.ExperimentController;
import model.experiment.base.BaseExperimentModel;

public abstract class BaseExperimentPanel extends JPanel {

    protected ExperimentController expCtr;
    protected ExperimentFooter footer;

    private BaseSidebar sidebar;
    private BaseCanvas canvas;
    private boolean sidebarVisible = false;

    public BaseExperimentPanel(AppController controller,
                               BaseExperimentModel model,
                               int id) {

        expCtr = new ExperimentController(controller, this, model);
        setLayout(new BorderLayout());

        // header
        ExperimentHeader header = new ExperimentHeader(controller, expCtr, id);

        // canvas
        canvas = createCanvas();

        // footer
        footer = new ExperimentFooter(canvas.canvasCtr, this);

        // sidebar
        sidebar = createSidebar();
        sidebar.setVisible(false);

        // layout
        add(header, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(sidebar, BorderLayout.EAST);
        add(footer, BorderLayout.SOUTH);

        expCtr.addVersionChecker();
    }

    protected abstract BaseCanvas createCanvas();
    protected abstract BaseSidebar createSidebar();

    /** Được controller gọi */
    public void toggleSidebar() {
        sidebarVisible = !sidebarVisible;
        sidebar.setVisible(sidebarVisible);
        revalidate();
        repaint();
    }

    public CanvasController getCanvasController() {
        return canvas.canvasCtr;
    }

    public boolean isSidebarVisible() {
        return sidebarVisible;
    }

    public ExperimentFooter getFooter() {
        return footer;
    }
}
