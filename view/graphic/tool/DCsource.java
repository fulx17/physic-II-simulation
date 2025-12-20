package view.graphic.tool;
import java.awt.*;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Clock;
import view.graphic.component.Knob;
import view.graphic.component.Socket;
public class DCsource implements GraphicObject{

    private String name = "Nguồn DC";
    private Knob knob;
    private Point position;
    private int width = 150;
    private int height = 200;
    private Color color = new Color(213, 213, 213);
    private Socket socket1, socket2, socket3;
    private Clock clock;
    private ArrayList<Socket> sockets;
    public DCsource(Point position) {
        this.position = position;
        clock = new Clock(new Point(position.x, position.y - 50));
        socket1 = Socket.getSource(new Point(position.x - 50, position.y + 70));
        socket2 = Socket.getCathode(new Point(position.x, position.y + 70));
        socket3 = Socket.getAnode(new Point(position.x + 50, position.y + 70));
        knob = new Knob(new Point(position.x, position.y + 25));
        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);
        
        clock.draw(g);
        knob.draw(g);
        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
    }
    
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
        clock.setPosition(new Point(position.x, position.y - 50));
        knob.setPosition(new Point(position.x, position.y + 25));
        socket1.setPosition(new Point(position.x - 50, position.y + 70));
        socket2.setPosition(new Point(position.x, position.y + 70));
        socket3.setPosition(new Point(position.x + 50, position.y + 70));
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
