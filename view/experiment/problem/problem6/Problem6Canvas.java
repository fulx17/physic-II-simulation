package view.experiment.problem.problem6;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;
import view.graphic.board.Problem6Board;
import view.graphic.tool.Battery;
import view.graphic.tool.Magnetron;

import java.awt.*;
public class Problem6Canvas extends BaseCanvas{
    public Problem6Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        Problem6Board tmp = new Problem6Board(new Point(500, 400)); 
        objects.add(tmp);
        Battery mg = (Magnetron)tmp.getMagnetron();
        objects.add(mg);
        return objects;
    }
}
