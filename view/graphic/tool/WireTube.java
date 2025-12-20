package view.graphic.tool;

import java.awt.*;
import java.util.ArrayList;

import view.graphic.component.Socket;

import view.graphic.GraphicObject;


public class WireTube implements GraphicObject{
    protected Socket socket1, socket2;
    protected Point position; 
    protected Color color = Color.DARK_GRAY;
    protected ArrayList<Socket> sockets;
    protected String name = "Ống dây";
    
    //  metric
    protected final int width = 1000;
    protected final int height = 30; 

    public WireTube(Point position) {
        this.position = position;
        socket1 = Socket.getAnode(new Point(position.x - width / 2 + 15, position.y));
        socket2 = Socket.getCathode(new Point(position.x + width / 2 - 15, position.y));
        
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
        socket1.setPosition(new Point(position.x - width / 2 + 15, position.y));
        socket2.setPosition(new Point(position.x + width / 2 - 15, position.y));
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
