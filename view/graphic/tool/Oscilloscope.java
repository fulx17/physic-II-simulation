package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
import view.graphic.component.Socket;

import view.graphic.component.Clock;
public class Oscilloscope implements GraphicObject{

    private Point position;
    private int width = 280;
    private int height = 170;
    private String name = "Ký điện tử";
    private Color color = new Color(213, 213, 213);
    private ArrayList<Socket> sockets;
    private Clock clock;
    private Socket socket1, socket2;
    public Oscilloscope(Point position) {
        this.position = position;
        clock = new Clock(new Point(position.x - 60, position.y - 25));
        socket1 = Socket.getCathode(new Point(position.x + 20, position.y + 50));
        socket2 = Socket.getCathode(new Point(position.x + 90, position.y + 50));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        clock.draw(g);
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
        
        clock.setPosition(new Point(position.x - 60, position.y - 25));
        socket1.setPosition(new Point(position.x + 20, position.y + 50));
        socket2.setPosition(new Point(position.x + 90, position.y + 50));
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
