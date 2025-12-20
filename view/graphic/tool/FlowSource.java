package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Knob;
import view.graphic.component.Switch;
import view.graphic.component.Socket;
import java.awt.*;
public class FlowSource implements GraphicObject{

    private Point position;
    private String name = "Nguồn dòng";
    private int width = 150;
    private int height = 100;
    private Socket socket1, socket2;
    private Knob knob;
    private Switch sw;
    private ArrayList<Socket> sockets;

    public FlowSource(Point position) {
        this.position = position;
        socket1 = Socket.getAnode(new Point(position.x - 50, position.y + 15));
        socket2 = Socket.getCathode(new Point(position.x, position.y + 15));
        knob = new Knob(new Point(position.x - 25, position.y - 20));
        sw = new Switch(new Point(position.x + 50, position.y + 15));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);

    }

    @Override
    public void draw(Graphics2D g) {
        socket1.draw(g);
        socket2.draw(g);
        knob.draw(g);
        sw.draw(g);
        g.setColor(Color.BLACK);

        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.drawRect(topLeftX, topLeftY, width, height);
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
        socket1.setPosition(new Point(position.x - 50, position.y + 15));
        socket2.setPosition(new Point(position.x, position.y + 15));
        knob.setPosition(new Point(position.x - 25, position.y - 20));
        sw.setPosition(new Point(position.x + 50, position.y + 15));
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
