package view.experiment.problem.problem2;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;

import view.graphic.tool.*;

import java.awt.*;
public class Problem2Canvas extends BaseCanvas{
    public Problem2Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        objects.add(new DCsource(new Point(850, 400)));
        objects.add(new ResistanceHoles(new Point(250, 550)));
        objects.add(new Stick(new Point(430, 600)));
        objects.add(new SmartMeter(new Point(250, 400)));
        objects.add(new ElectricMeter(new Point(550, 400)));
        objects.add(new UpperPanel(new Point(650, 200)));
        return objects;
    }
}
