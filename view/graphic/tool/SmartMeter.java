package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
import view.graphic.component.Clock;
import view.graphic.component.Socket;
public class SmartMeter implements GraphicObject{

    private Point position;
    private String name = "Kế đa năng";
    private int width = 150;
    private int height = 200;
    private Color color = new Color(27, 55, 66);
    private Socket socket1, socket2, socket3;
    private Clock clock;
    private ArrayList<Socket> sockets;
    public SmartMeter(Point position) {
        this.position = position;
        clock = new Clock(new Point(position.x, position.y - 50));
        socket1 = Socket.getAnode(new Point(position.x - 50, position.y + 50));
        socket2 = Socket.getCathode(new Point(position.x, position.y + 50));
        socket3 = Socket.getAnode(new Point(position.x + 50, position.y + 50));
        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
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
        socket3.draw(g);

        Point APosition = new Point(position.x - 50, position.y + 80);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int x = APosition.x - (fm.stringWidth("A") / 2);
        int y = (APosition.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("A", x, y);

        Point COMPosition = new Point(position.x, position.y + 80);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        fm = g.getFontMetrics();
        x = COMPosition.x - (fm.stringWidth("COM") / 2);
        y = (COMPosition.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("COM", x, y);

        Point VPosition = new Point(position.x + 50, position.y + 80);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        fm = g.getFontMetrics();
        x = VPosition.x - (fm.stringWidth("A") / 2);
        y = (VPosition.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("V", x, y);
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
        clock.setPosition(new Point(position.x, position.y - 50));
        socket1.setPosition(new Point(position.x - 50, position.y + 50));
        socket2.setPosition(new Point(position.x, position.y + 50));
        socket3.setPosition(new Point(position.x + 50, position.y + 50));
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
