package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import view.graphic.*;
import view.graphic.component.*;
import view.experiment.base.BaseCanvas;

public class CanvasController {

    private final ArrayList<GraphicObject> objects;
    private final ArrayList<Socket> sockets;
    private final ArrayList<Wire> wires;

    private double scale = 1.0;
    private double offsetX = 0;
    private double offsetY = 0;

    private GraphicObject holdingObject;
    private boolean panning = false;
    private boolean deleting = false;
    private Point lastMouse;

    private ExperimentController expCtr;
    private final BaseCanvas canvas;

    public CanvasController(ExperimentController expCtr, BaseCanvas canvas, ArrayList<GraphicObject> objects) {
        this.expCtr = expCtr;
        this.canvas = canvas;
        this.objects = objects;
        this.sockets = new ArrayList<>();
        this.wires = new ArrayList<>();
    }
    public void enableDeleteWire() {
        deleting = true;
    }

    public void addWire() {
        Wire w = new Wire(new Point(300, 300));
        wires.add(w);
    }


    public void onMousePressed(MouseEvent e) {
        Point screen = e.getPoint();
        Point world = screenToWorld(screen);
        lastMouse = screen;
        
        for (int i = wires.size() - 1; i >= 0; i--) {
            Wire w = wires.get(i);
            // neu an vao day
            if (w.contains(world)) {
                
                // neu dang xoa va day khong camw
                if (deleting) {
                    removeWire(w);
                    deleting = false;
                    canvas.repaint();
                    return;
                }
                // kiem tra nam vao day va day co plug khong
                
                // luu lai jack
                holdingObject = w.pick(world);
                panning = false;
                deleting = false;
                return;
            }
        }

        // luu lai object
        for (int i = objects.size() - 1; i >= 0; i--) {
            GraphicObject obj = objects.get(i);
            if (obj.contains(world)) {
                holdingObject = obj;
                panning = false;
                deleting = false;
                return;
            }
        }

        holdingObject = null;
        panning = true;
        deleting = false;
    }

    public void onMouseDragged(MouseEvent e) {
        Point screen = e.getPoint();

        // 
        if (holdingObject != null) {
            Point prevWorld = screenToWorld(lastMouse);
            Point currWorld = screenToWorld(screen);

            int dx = currWorld.x - prevWorld.x;
            int dy = currWorld.y - prevWorld.y;

            Point pos = holdingObject.getPosition();
            // set lai vi tri goc
            holdingObject.setPosition(
                new Point(pos.x + dx, pos.y + dy)
            );

            lastMouse = screen;
            canvas.repaint();
            return;
        }

        if (panning) {
            offsetX += screen.x - lastMouse.x;
            offsetY += screen.y - lastMouse.y;

            lastMouse = screen;
            canvas.repaint();
        }
    }

    public void onMouseReleased(MouseEvent e) {

        System.out.print(holdingObject instanceof Jack);
        Point screen = e.getPoint();
        Point world = screenToWorld(screen);
        // neu la jack
        if (holdingObject instanceof Jack jack) {
            boolean plugged = false;

            // kiem tra tung socket
            for (Socket s : sockets) {

                //// co the sua thanh vi tri chuot
                if (s.contains(jack.getPosition()) || s.contains(world)) {
                    connect(jack, s);
                    plugged = true;
                    break;
                }
            }

            // ngat ket noi neu truoc do no ket noi
            if (!plugged && jack instanceof JackPlug) {
                deConnect(jack);
            }
            canvas.repaint();
        }

        holdingObject = null;
        panning = false;
        deleting = false;
    }

    public void onMouseWheel(MouseWheelEvent e) {
        double zoomFactor = (e.getWheelRotation() < 0) ? 1.1 : 0.9;
        Point mouse = e.getPoint();

        double wx = (mouse.x - offsetX) / scale;
        double wy = (mouse.y - offsetY) / scale;

        scale *= zoomFactor;

        offsetX = mouse.x - wx * scale;
        offsetY = mouse.y - wy * scale;

        canvas.repaint();
    }

    // ================== RENDER ==================

    public void render(Graphics2D g2) {
        Graphics2D g = (Graphics2D) g2.create();

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        // world transform
        g.translate(offsetX, offsetY);
        g.scale(scale, scale);

        // draw objects
        for (GraphicObject obj : objects) {
            obj.draw(g);
        }

        // draw wires on top
        for (Wire w : wires) {
            w.draw(g);
        }

        g.dispose();
    }

    // ================== UTILS ==================

    private void removeWire(Wire w) {
        wires.remove(w);
    }

    public Point screenToWorld(Point screen) {
        return new Point(
            (int) ((screen.x - offsetX) / scale),
            (int) ((screen.y - offsetY) / scale)
        );
    }

    public Point worldToScreen(Point world) {
        return new Point(
            (int) (world.x * scale + offsetX),
            (int) (world.y * scale + offsetY)
        );
    }
    public void connect(Jack j, Socket s) {
        // create new jackplug
        Wire w = j.getWire();
        Jack jack1 = w.getJack1();
        Jack jack2 = w.getJack2();
        
        // add logic to new plug
        if(j == jack1) {
            JackPlug jp = new JackPlug(w, jack1.getPosition(), s);
            s.addJack(jp);
            w.setJack1(jp);
        }
        else {
            JackPlug jp = new JackPlug(w, jack2.getPosition(), s);
            s.addJack(jp);
            w.setJack2(jp);
        }

        // connect;
        if(w.getJack1().isPlugged() && w.getJack2().isPlugged()) {
            JackPlug jackplug1 = (JackPlug)w.getJack1();
            JackPlug jackplug2 = (JackPlug)w.getJack2();
            int idx1 = sockets.indexOf(jackplug1.getSocket());
            int idx2 = sockets.indexOf(jackplug2.getSocket());
            expCtr.setCurrentAdjacent(idx1, idx2);
        }
    }

    public void deConnect(Jack j) {
        // create new jackplug
        Wire w = j.getWire();
        Jack jack1 = w.getJack1();
        Jack jack2 = w.getJack2();

        // deconnect;
        if(w.getJack1().isPlugged() && w.getJack2().isPlugged()) {
            JackPlug jackplug1 = (JackPlug)w.getJack1();
            JackPlug jackplug2 = (JackPlug)w.getJack2();
            int idx1 = sockets.indexOf(jackplug1.getSocket());
            int idx2 = sockets.indexOf(jackplug2.getSocket());
            expCtr.unSetCurrentAdjacent(idx1, idx2);
        }
        
        // add logic to new plug
        if(j == jack1) {
            Jack jn = new Jack(w, jack1.getPosition());
            JackPlug tmp = (JackPlug)jack1;
            tmp.getSocket().delJack(tmp);
            w.setJack1(jn);
        }
        else {
            Jack jn = new Jack(w, jack2.getPosition());
            JackPlug tmp = (JackPlug)jack2;
            tmp.getSocket().delJack(tmp);
            w.setJack2(jn);
        }

    }
}
