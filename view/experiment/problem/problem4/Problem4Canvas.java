package view.experiment.problem.problem4;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;

import view.graphic.tool.*;

import java.awt.*;
public class Problem4Canvas extends BaseCanvas{
    public Problem4Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        objects.add(new DCACsource(new Point(300, 300)));
        objects.add(new ResistanceHoles(new Point(550, 550)));
        objects.add(new SmartMeter(new Point(300, 550)));
        objects.add(new WireTube(new Point(900, 300)));
        return objects;
    }
}
