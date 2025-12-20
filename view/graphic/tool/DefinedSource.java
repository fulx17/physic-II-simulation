package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Switch;
import view.graphic.component.Socket;
import java.awt.*;
public class DefinedSource implements GraphicObject{

    private Point position;
    private String name = "Nguồn chuẩn";
    private int width = 150;
    private int height = 100;
    private Socket socket1, socket2;
    private Switch sw;
    private ArrayList<Socket> sockets;

    public DefinedSource(Point position) {
        this.position = position;
        socket1 = Socket.getAnode(position);
        socket2 = Socket.getCathode(new Point(position.x + 50, position.y));
        sw = new Switch(new Point(position.x - 50, position.y - 33));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);

    }

    @Override
    public void draw(Graphics2D g) {
        socket1.draw(g);
        socket2.draw(g);
        sw.draw(g);
        g.setColor(Color.BLACK);

        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        Point EPoint = new Point(position.x - 50, position.y - 7);
        FontMetrics fm = g.getFontMetrics();
        int x = EPoint.x - (fm.stringWidth("E0") / 2);
        int y = (EPoint.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("E0", x, y);

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
        socket1.setPosition(position);
        socket2.setPosition(new Point(position.x + 50, position.y));
        sw.setPosition(new Point(position.x - 50, position.y - 33));
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
