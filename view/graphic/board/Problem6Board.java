package view.graphic.board;

import java.awt.*;
import java.util.ArrayList;

import view.graphic.component.Socket;
import view.graphic.tool.DCsourcePanel;
import view.graphic.tool.Magnetron;
import view.graphic.tool.MeterRight;
import view.graphic.tool.MeterLeft;
import view.graphic.GraphicObject;


public class Problem6Board implements GraphicObject{
    private Point position; 
    private Color color = new Color(213, 213, 213);
    private ArrayList<Socket> sockets;
    private String name = "Bảng mạch";

    private MeterRight A1;
    private MeterLeft A2, V;
    private DCsourcePanel U1, U2, U3;
    private Socket socket1, socket2, socket3;
    private Magnetron magnetron;
    
    //  metric
    private final int width = 800;
    private final int height = 500; 
    public GraphicObject getMagnetron() {
        return magnetron;
    }

    public Problem6Board(Point position) {
        this.position = position;
        
        A1 = new MeterRight(new Point(position.x - 240, position.y), "A1", "Ampe kế", true);
        A2 = new MeterLeft(new Point(position.x + 240, position.y - 150), "A2", "Miliampe kế", false);
        V = new MeterLeft(new Point(position.x + 240, position.y), "V", "Vôn kế", true);

        U1 = new DCsourcePanel(new Point(position.x - 240, position.y + 160), "U1");
        U2 = new DCsourcePanel(new Point(position.x, position.y + 160), "U2");
        U3 = new DCsourcePanel(new Point(position.x + 240, position.y + 160), "U3");

        socket1 = Socket.getCathode(new Point(position.x - 30, position.y));
        socket2 = Socket.getAnode(new Point(position.x + 30, position.y));
        socket3 = Socket.getAnode(new Point(position.x + 30, position.y - 175));
        magnetron = new Magnetron(new Point(position.x, position.y - 90));
        
        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);

        sockets.addAll(A1.getSockets());
        sockets.addAll(A2.getSockets());
        sockets.addAll(V.getSockets());
        
        sockets.addAll(U1.getSockets());
        sockets.addAll(U2.getSockets());
        sockets.addAll(U3.getSockets());
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        A1.draw(g);
        A2.draw(g);
        V.draw(g);
        
        U1.draw(g);
        U2.draw(g);
        U3.draw(g);
        magnetron.draw(g);

        Stroke old = g.getStroke();
        g.setStroke(new BasicStroke(10));
        g.setColor(Color.BLACK);
        g.drawRect(topLeftX, topLeftY, width, height);
        g.setStroke(old);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
    }
    @Override
    public boolean contains(Point worldPoint) {
        int left = position.x - width / 2;
        int right = position.x + width / 2;
        int top = position.y - height / 2;
        int bottom = position.y + height / 2;
        return (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom);
    }

    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        A1.setPosition(new Point(position.x - 240, position.y));
        A2.setPosition(new Point(position.x + 240, position.y - 150));
        V.setPosition(new Point(position.x + 240, position.y));

        U1.setPosition(new Point(position.x - 240, position.y + 160));
        U2.setPosition(new Point(position.x, position.y + 160));
        U3.setPosition(new Point(position.x + 240, position.y + 160));

        socket1.setPosition(new Point(position.x - 30, position.y));
        socket2.setPosition(new Point(position.x + 30, position.y));
        socket3.setPosition(new Point(position.x + 30, position.y - 175));

        magnetron.setPosition(new Point(position.x, position.y - 90));
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public ArrayList<Socket> getSockets() {
        return sockets;
    }

    @Override
    public String getName() {
        return name;
    }
}
