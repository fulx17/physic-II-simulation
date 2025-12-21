package view.graphic.tool;

import java.awt.*;
import java.util.ArrayList;

import view.graphic.component.Knob;
import view.graphic.component.Socket;

import view.graphic.GraphicObject;


public class ComputerConnector implements GraphicObject{
    private Socket socket1, socket2, socket3, socket4, socket5, socket6, socket7, socket8, socket9, socket10;
    private Point position;
    private ArrayList<Socket> sockets;
    private String name = "Kết nối máy tính";
    private Knob kn;
    
    //  metric
    private final int width = 450;
    private final int height = 190; 

    public ComputerConnector(Point position) {
        this.position = position;
        socket1 = Socket.getBlue(new Point(position.x - 190, position.y - 40));
        socket2 = Socket.getCathode(new Point(position.x - 140, position.y - 40));
        socket3 = Socket.getCathode(new Point(position.x - 140, position.y + 10));
        socket4 = Socket.getAnode(new Point(position.x - 190, position.y + 60));
        socket5 = Socket.getCathode(new Point(position.x - 140, position.y + 60));

        socket6 = Socket.getBlue(new Point(position.x - 50, position.y + 60));
        socket7 = Socket.getAnode(new Point(position.x, position.y + 60));

        socket8 = Socket.getBlue(new Point(position.x + 90, position.y + 60));
        socket9 = Socket.getAnode(new Point(position.x + 140, position.y + 60));
        socket10 = Socket.getAnode(new Point(position.x + 190, position.y + 60));

        kn = new Knob(new Point(position.x - 190, position.y + 10));
        
        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
        sockets.add(socket4);
        sockets.add(socket5);
        sockets.add(socket6);
        sockets.add(socket7);
        sockets.add(socket8);
        sockets.add(socket9);
        sockets.add(socket10);
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(new Color(213, 213, 213));
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(topLeftX, topLeftY, 120, 190);
        g.fillRect(topLeftX + 140, topLeftY, 120, 190);
        g.fillRect(topLeftX + 280, topLeftY, 170, 190);

        for(Socket s : sockets) s.draw(g);
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
        socket1.setPosition(new Point(position.x - 190, position.y - 40));
        socket2.setPosition(new Point(position.x - 140, position.y - 40));
        socket3.setPosition(new Point(position.x - 140, position.y + 10));
        socket4.setPosition(new Point(position.x - 190, position.y + 60));
        socket5.setPosition(new Point(position.x - 140, position.y + 60));

        socket6.setPosition(new Point(position.x - 50, position.y + 60));
        socket7.setPosition(new Point(position.x, position.y + 60));

        socket8.setPosition(new Point(position.x + 90, position.y + 60));
        socket9.setPosition(new Point(position.x + 140, position.y + 60));
        socket10.setPosition(new Point(position.x + 190, position.y + 60));

        kn.setPosition(new Point(position.x - 190, position.y + 10));
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
