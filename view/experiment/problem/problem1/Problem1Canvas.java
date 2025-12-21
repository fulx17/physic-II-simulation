package view.experiment.problem.problem1;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;
import view.graphic.board.Problem1Board;

import view.graphic.tool.*;

import java.awt.*;
public class Problem1Canvas extends BaseCanvas{
    public Problem1Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        objects.add(new Problem1Board(new Point(500, 400)));
        objects.add(new ResistanceWire(new Point(600, 700)));
        objects.add(new ResistanceJacks(new Point(1050, 600)));
        objects.add(new Battery(new Point(1050, 460)));
        objects.add(new BigResistanceBox(new Point(1100, 250)));
        return objects;
    }
}
