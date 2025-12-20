package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
import view.graphic.component.Socket;
public class UpperPanel implements GraphicObject{

    private Point position;
    private int height = 70;
    private int width = 140;
    private String name = "Bản tụ trên";
    private ArrayList<Socket> sockets;
    private Socket socket;
    private Color color = new Color(207, 207, 207);
    public UpperPanel(Point position) {
        this.position = position;
        socket = Socket.getAnode(new Point(position.x, position.y - 15));

        sockets = new ArrayList<>();
        sockets.add(socket);
    }

    @Override
    public void draw(Graphics2D g) {
        int x1 = position.x;
        int y1 = position.y - height / 2;

        int x2 = position.x - width / 2;
        int y2 = position.y + height / 2;
        
        int x3 = position.x + width / 2;
        int y3 = position.y + height / 2;

        int[] X = {x1, x2, x3};
        int[] Y = {y1, y2, y3};
        int nPoints = 3;

        g.setColor(color);
        g.fillPolygon(X, Y, nPoints);

        
        int topLeftX = position.x - (30 / 2);
        int topLeftY = position.y - 70 - (140 / 2);

        g.fillRect(topLeftX, topLeftY, 30, 140);

        socket.draw(g);
    }
    
    @Override
    public boolean contains(Point worldPoint) {
        int left = position.x - 30 / 2;
        int right = position.x + 30 / 2;
        int top = position.y - 70 - 140 / 2;
        int bottom = position.y - 70 + 140 / 2;
        boolean rec = (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom);
    
        int x1 = position.x;
        int y1 = position.y - height / 2;

        int x2 = position.x - width / 2;
        int y2 = position.y + height / 2;
        
        int x3 = position.x + width / 2;
        int y3 = position.y + height / 2;

        int[] X = {x1, x2, x3};
        int[] Y = {y1, y2, y3};
        int nPoints = 3;
        Polygon triangleArea = new Polygon(X, Y, nPoints);

        return triangleArea.contains(worldPoint) || rec;

    }
   
    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        socket.setPosition(new Point(position.x, position.y - 15));
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
