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
    }

    public void unSetCurrentAdjacent(int x, int y) {
        currentAdjacent.get(x).set(y, 0);
    }

    public boolean compare() {
        for(int i = 0; i < model.getSockerNumber(); i++) {
            for(int j = 0; j < model.getSockerNumber(); i++) {
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
    public List<Point> findIssue() {
        return List.of(new Point(0, 0), new Point(0, 0));
    }
    public List<Point> findHint() {
        return List.of(new Point(0, 0), new Point(0, 0));
    }
    
    public void displayHint(List<Point> hintWire, boolean isCorrect) {

    }
    public void hint() {
        if(compare() == true) {
            controller.sendNotify("Bạn mắc chuẩn rồi!!!");
            return;
        } 
        List<Point> inCorrect = findIssue();
        List<Point> correct = findHint();
        displayHint(inCorrect, false);
        displayHint(correct, true);
    }

    public void unSetDelete() {
        expPanel.getFooter().getDelWireBtn().setBackground(null);
    }

    public void addVersionChecker() {
        if(model.getVersionNumber() == 1) {
            JButton checkBtnVer1 = new JButton("Kiểm tra");
            checkBtnVer1.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer1();
                checking();
            });  
            expPanel.getFooter().add(checkBtnVer1, BorderLayout.CENTER);
        }
        else {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1, 2, 0, 0));
            JButton checkBtnVer1 = new JButton("Kiểm tra 1");
            checkBtnVer1.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer1();
                checking();
            });  
            JButton checkBtnVer2 = new JButton("Kiểm tra 2");
            checkBtnVer1.addActionListener(e -> {
                baseAdjacent = model.getBaseAdjacentVer2();
                checking();
            }); 
            buttonPanel.add(checkBtnVer1);
            buttonPanel.add(checkBtnVer2);
            expPanel.getFooter().add(buttonPanel, BorderLayout.CENTER);
        }
    }
}
