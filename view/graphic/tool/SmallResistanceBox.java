package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Knob;
import view.graphic.component.Socket;

import java.awt.*;
public class SmallResistanceBox implements GraphicObject{

    private Point position;
    private String name = "Hộp điện trở";
    private int width = 290;
    private int height = 120;
    private Knob kn1, kn2, kn3, kn4;
    private Socket socket1, socket2;
    private ArrayList<Socket> sockets;
    public SmallResistanceBox(Point position) {
        this.position = position;
        kn1 = new Knob(new Point(position.x - 115, position.y));
        kn2 = new Knob(new Point(position.x - 55, position.y));
        kn3 = new Knob(new Point(position.x + 5, position.y));
        kn4 = new Knob(new Point(position.x + 65, position.y));

        socket1 = Socket.getCathode(new Point(position.x + 115, position.y - 35));
        socket2 = Socket.getCathode(new Point(position.x + 115, position.y + 35));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
    } 

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(Color.ORANGE);
        g.fillRect(topLeftX, topLeftY, width, height);
        kn1.draw(g);
        kn2.draw(g);
        kn3.draw(g);
        kn4.draw(g);

        socket1.draw(g);
        socket2.draw(g);

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
        kn1.setPosition(new Point(position.x - 115, position.y));
        kn2.setPosition(new Point(position.x - 55, position.y));
        kn3.setPosition(new Point(position.x + 5, position.y));
        kn4.setPosition(new Point(position.x + 65, position.y));

        socket1.setPosition(new Point(position.x + 115, position.y - 35));
        socket2.setPosition(new Point(position.x + 115, position.y + 35));
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
