package view.experiment.problem.problem1;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;
import view.graphic.component.*;

import view.graphic.tool.*;

import java.awt.*;
public class Problem1Canvas extends BaseCanvas{
    public Problem1Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        objects.add(Socket.getAnode(new Point(100, 100)));
        objects.add(Socket.getCathode(new Point(100, 200)));
        objects.add(new ResistanceHoles(new Point(500, 500)));
        
        return objects;
    }
}
