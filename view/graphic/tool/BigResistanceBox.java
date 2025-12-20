package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Knob;
import view.graphic.component.Socket;

import java.awt.*;
public class BigResistanceBox implements GraphicObject{

    private Point position;
    private String name = "Hộp điện trở";
    private int width = 290;
    private int height = 210;
    private Knob kn1, kn2, kn3, kn4, kn5, kn6;
    private Socket socket1, socket2, socket3, socket4;
    private ArrayList<Socket> sockets;
    public BigResistanceBox(Point position) {
        this.position = position;
        kn1 = new Knob(new Point(position.x - 80, position.y - 15));
        kn2 = new Knob(new Point(position.x, position.y - 15));
        kn3 = new Knob(new Point(position.x + 80, position.y - 15));
        kn4 = new Knob(new Point(position.x - 80, position.y + 65));
        kn5 = new Knob(new Point(position.x, position.y + 65));
        kn6 = new Knob(new Point(position.x + 80, position.y + 65));

        socket1 = Socket.getCathode(new Point(position.x - 90, position.y - 70));
        socket2 = Socket.getCathode(new Point(position.x - 30, position.y - 70));
        socket3 = Socket.getCathode(new Point(position.x + 30, position.y - 70));
        socket4 = Socket.getCathode(new Point(position.x + 90, position.y - 70));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
        sockets.add(socket4);
    } 

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(new Color(213, 213, 213));
        g.fillRect(topLeftX, topLeftY, width, height);
        kn1.draw(g);
        kn2.draw(g);
        kn3.draw(g);
        kn4.draw(g);
        kn5.draw(g);
        kn6.draw(g);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
        socket4.draw(g);

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
        kn1.setPosition(new Point(position.x - 80, position.y - 15));
        kn2.setPosition(new Point(position.x, position.y - 15));
        kn3.setPosition(new Point(position.x + 80, position.y - 15));
        kn4.setPosition(new Point(position.x - 80, position.y + 65));
        kn5.setPosition(new Point(position.x, position.y + 65));
        kn6.setPosition(new Point(position.x + 80, position.y + 65));

        socket1.setPosition(new Point(position.x - 90, position.y - 70));
        socket2.setPosition(new Point(position.x - 30, position.y - 70));
        socket3.setPosition(new Point(position.x + 30, position.y - 70));
        socket4.setPosition(new Point(position.x + 90, position.y - 70));
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
