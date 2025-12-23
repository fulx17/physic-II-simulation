package controller;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

import view.experiment.base.BaseExperimentPanel;
import model.experiment.base.BaseExperimentModel;

public class ExperimentController {
    private ArrayList<ArrayList<Integer>> currentAdjacent;
    private int[][] baseAdjacent;
    AppController controller;
    BaseExperimentPanel expPanel;
    BaseExperimentModel model;
    public ExperimentController(AppController controller, BaseExperimentPanel expPanel, BaseExperimentModel model) {
        this.controller = controller;
        this.expPanel = expPanel;
        this.model = model;

        // initialize 
        currentAdjacent = new ArrayList<>();
        for(int i = 0; i < model.getSockerNumber(); i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < model.getSockerNumber(); j++) {
                tmp.add(0);
            }
            currentAdjacent.add(tmp);
        }
        baseAdjacent = model.getBaseAdjacentVer1();
    }
    // checking
    public void setCurrentAdjacent(int x, int y) {
        currentAdjacent.get(x).set(y, 1);
        currentAdjacent.get(y).set(x, 1);
    }

    public void unSetCurrentAdjacent(int x, int y) {
        currentAdjacent.get(x).set(y, 0);
        currentAdjacent.get(y).set(x, 0);
    }

    public boolean compare() {
        for(int i = 0; i < model.getSockerNumber(); i++) {
            for(int j = 0; j < model.getSockerNumber(); j++) {
                if(currentAdjacent.get(i).get(j) != baseAdjacent[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void checking() {
        if(compare() == true) {
            controller.sendNotify("Bạn mắc chuẩn rồi!!!");
        }
        else {
            controller.sendNotify("Bạn mắc sai rồi:((");
        }
    }

    // validate 

    // hint
    public Point findIssue() {
        for(int i = 0; i < model.getSockerNumber(); i++) {
            for(int j = 0; j < model.getSockerNumber(); j++) {
                if(currentAdjacent.get(i).get(j) != baseAdjacent[i][j] && baseAdjacent[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
    public Point findHint() {
        for(int i = 0; i < model.getSockerNumber(); i++) {
            for(int j = 0; j < model.getSockerNumber(); j++) {
                if(currentAdjacent.get(i).get(j) != baseAdjacent[i][j] && baseAdjacent[i][j] == 1) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
    
    public void displayHint(List<Point> hintWire, boolean isCorrect) {

    }
    public void hint() {
        if(compare() == true) {
            controller.sendNotify("Bạn mắc chuẩn rồi!!!");
            return;
        } 
        Point inCorrect = findIssue();
        Point correct = findHint();

        if(inCorrect != null) {
            expPanel.getCanvasController().hintDisplay(inCorrect.x, inCorrect.y, true);
            return;
        }
        if(correct != null) {
            expPanel.getCanvasController().hintDisplay(correct.x, correct.y, false);
            return;
        }
    }


    public void addVersionChecker() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, model.getVersionNumber(), 0, 0));
        if(model.getVersionNumber() >= 1) {
            JButton checkBtnVer1 = new JButton("Kiểm tra 1");
            checkBtnVer1.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer1();
                checking();
            });  
            buttonPanel.add(checkBtnVer1);
        }
        if(model.getVersionNumber() >= 2) {
            JButton checkBtnVer2 = new JButton("Kiểm tra 2");
            checkBtnVer2.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer2();
                checking();
            });  
            buttonPanel.add(checkBtnVer2);
        }
        if(model.getVersionNumber() >= 3) {
            JButton checkBtnVer3 = new JButton("Kiểm tra 3");
            checkBtnVer3.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer3();
                checking();
            });  
            buttonPanel.add(checkBtnVer3);
        }
        expPanel.getFooter().add(buttonPanel, BorderLayout.CENTER);
    }

}
