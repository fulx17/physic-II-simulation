package view.experiment.problem.problem5;

import java.util.ArrayList;

import controller.ExperimentController;
import view.experiment.base.BaseCanvas;
import view.graphic.GraphicObject;
import view.graphic.board.Problem5Board;
import view.graphic.tool.*;

import java.awt.*;
public class Problem5Canvas extends BaseCanvas{
    public Problem5Canvas(ExperimentController expCtr) {
        super(expCtr);
    }

    public ArrayList<GraphicObject> createObjects() {
        ArrayList<GraphicObject> objects = new ArrayList<>();
        objects.add(new Problem5Board(new Point(450, 400)));
        objects.add(new ComputerConnector(new Point(1150, 250)));
        objects.add(new CapacitorJacksVertical(new Point(1300, 450)));
        objects.add(new ResistanceJacks(new Point(1000, 600)));
        objects.add(new SmallResistanceBox(new Point(1050, 450)));
        objects.add(new DCACsource(new Point(1500, 250)));
        objects.add(new Transformer(new Point(1200, 600)));
        objects.add(new Oscilloscope(new Point(1500, 450)));
        
        return objects;
    }
}
