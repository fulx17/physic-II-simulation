package view.experiment.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import controller.ExperimentController;
import view.graphic.GraphicObject;
import controller.CanvasController;


public abstract class BaseCanvas extends JPanel{
    public CanvasController canvasCtr;
    public BaseCanvas(ExperimentController expCtr) {
        canvasCtr = new CanvasController(expCtr, this, createObjects());
        
        canvasCtr.addWire();

        setBackground(Color.WHITE);
        setFocusable(true); 

        // mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvasCtr.onMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                canvasCtr.onMouseReleased(e);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvasCtr.onMouseDragged(e);
            }
        });

        addMouseWheelListener(canvasCtr::onMouseWheel);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        canvasCtr.render((Graphics2D) g);
    }

    public abstract ArrayList<GraphicObject> createObjects();
}
