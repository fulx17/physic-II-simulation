package controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import view.graphic.*;
import view.graphic.component.*;
import view.graphic.tool.Battery;
import view.graphic.tool.ResistanceJacks;
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

    private String hoverText;
    private Point mousePosition;

    private Point hintFrom, hintTo;
    private Color hintColor; 

    public CanvasController(ExperimentController expCtr, BaseCanvas canvas, ArrayList<GraphicObject> objects) {
        this.expCtr = expCtr;
        this.canvas = canvas;
        this.objects = objects;
        this.sockets = new ArrayList<>();
        this.wires = new ArrayList<>();

        for(GraphicObject obj : objects) {
            sockets.addAll(obj.getSockets());
        }
    }
    public void enableDeleteWire() {
        deleting = true;
    }

    public void addWire() {

        int screenHeight = canvas.getHeight(); 
        int screenX = 150; 
        int screenY = screenHeight - 150; 
        Point screenPoint = new Point(screenX, screenY);

        Point worldPoint = screenToWorld(screenPoint); 
        Wire w = new Wire(worldPoint);
        wires.add(w);
        
        canvas.repaint();
    }


    public void onMousePressed(MouseEvent e) {
        Point screen = e.getPoint();
        // System.out.print(screen);
        hintColor = null;
        hintFrom = null;
        hintTo = null;
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

                if(obj instanceof Battery bat) {
                    holdingObject = bat.pick(world);
                }

                else {
                    holdingObject = obj;
                }

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
        Point world = screenToWorld(screen);
        hoverText = null;

        if (holdingObject != null) {

            if(holdingObject instanceof ResistanceJacks rp) {
                if(rp.getJack1() instanceof JackPlug) {
                    deConnect(rp.getJack1());
                    deConnect(rp.getJack2());
                }
                canvas.repaint();
            }

            // neu la jack
            else if (holdingObject instanceof Jack jack) {
                // kiem tra tung socket
                if(jack instanceof JackPlug) {
                    Wire temp = jack.getWire();
                    deConnect(jack);
                    holdingObject = temp.pick(world);
                }
                canvas.repaint();
            }

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

    public void onMouseMoved(MouseEvent e) {
        Point screen = e.getPoint();
        Point world = screenToWorld(screen);
        mousePosition = world;
        for (int i = objects.size() - 1; i >= 0; i--) {
            GraphicObject obj = objects.get(i);
            if (obj.contains(world)) {
                hoverText = obj.getName();
                canvas.repaint();
                return;
            }
        }
        hoverText = null;
        canvas.repaint();
    }



    private Socket findSocket(Jack jack, Point world) {
        for(Socket s : sockets) {
            if (s.contains(jack.getPosition()) ||  
                s.contains(jack.getLeg().getPosition()))return s;
            if(world != null && s.contains(world)) return s;
        }
        return null;
    }

    public void onMouseReleased(MouseEvent e) {

        Point screen = e.getPoint();
        Point world = screenToWorld(screen);
        // neu la dien tro cam
        if(holdingObject instanceof ResistanceJacks rp) {
            Jack jack1 = rp.getJack1();
            Jack jack2 = rp.getJack2();
            Socket s1 = findSocket(jack1, null);
            Socket s2 = findSocket(jack2, null);

            if(s1 != null && s2 != null) {
                jack1.setPosition(s1.getPosition());
                connect(jack1, s1);
                jack2.setPosition(s2.getPosition());
                connect(jack2, s2);
            }

            else if(rp.getJack1() instanceof JackPlug) {
                deConnect(rp.getJack1());
                deConnect(rp.getJack2());
            }
            canvas.repaint();
        }

        // neu la jack
        else if (holdingObject instanceof Jack jack) {
            // kiem tra tung socket
            Socket s = findSocket(jack, world);
            if(s != null) {
                jack.setPosition(s.getPosition());
                connect(jack, s);
            }
            // ngat ket noi neu truoc do no ket noi
            else if(jack instanceof JackPlug) {
                deConnect(jack);
            }
            canvas.repaint();
        }

        // holdingObject = null;
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

    public void onDeleteKeyPressed() {
        if(holdingObject instanceof Jack j) {
            removeWire(j.getWire());
        }
        if(holdingObject != null && holdingObject.getClass() == Wire.class) {
            Wire w = (Wire) holdingObject;
            removeWire(w);
        }
        canvas.repaint();
    }

    // ================== RENDER ==================

    private void drawTooltip(Graphics2D g) {
        // Cấu hình style
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        FontMetrics fm = g.getFontMetrics();
        
        int textWidth = fm.stringWidth(hoverText);
        int textHeight = fm.getHeight();
        
        int x = mousePosition.x + 12;
        int y = mousePosition.y + 20;

        g.setColor(new Color(255, 255, 225));
        g.fillRect(x, y - textHeight, textWidth + 8, textHeight + 4);
        
        // Vẽ viền hộp
        g.setColor(Color.BLACK);
        g.drawRect(x, y - textHeight, textWidth + 8, textHeight + 4);

        // Vẽ chữ
        g.drawString(hoverText, x + 4, y);
    }
    
    private void drawHint(Graphics2D g) {
        Stroke oldStroke = g.getStroke();
        Color oldColor = g.getColor();

        g.setColor(hintColor);

        g.setStroke(new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g.drawLine(hintFrom.x, hintFrom.y, hintTo.x, hintTo.y);
        g.setStroke(oldStroke);
        g.setColor(oldColor);
    } 

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

        if(hintFrom != null) {
            drawHint(g);
        }

        if (hoverText != null && mousePosition != null) {
            drawTooltip(g);
        }

        g.dispose();
    }

    // ================== UTILS ==================

    private void removeWire(Wire w) {
        deConnect(w.getJack1());
        deConnect(w.getJack2());
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

            // System.out.println(idx1 + " " + idx2);

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
        if(j instanceof JackPlug) {
            if(j == jack1) {
                Jack jn = new Jack(w, jack1.getPosition());
                JackPlug tmp = (JackPlug)jack1;
                tmp.getSocket().delJack(tmp);
                w.setJack1(jn);
            }
            else if (j instanceof JackPlug){
                Jack jn = new Jack(w, jack2.getPosition());
                JackPlug tmp = (JackPlug)jack2;
                tmp.getSocket().delJack(tmp);
                w.setJack2(jn);
            }
        }
    }

    public void hintDisplay(int idx1, int idx2, boolean isIncorrect) {
        hintFrom = sockets.get(idx1).getPosition();
        hintTo = sockets.get(idx2).getPosition();
        if(isIncorrect) {
            hintColor = Color.RED;
        }
        else hintColor = Color.GREEN;
    }
}
