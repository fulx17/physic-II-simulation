package view.graphic.tool;
import java.util.ArrayList;
import view.graphic.GraphicObject;
import java.awt.*;
import view.graphic.component.Socket;
public class Stick implements GraphicObject{

    private Point position;
    private int width = 30;
    private int height = 150;
    private String name = "Thanh nối đất";
    private Color color = new Color(197, 192, 192);
    private Socket socket;
    private ArrayList<Socket> sockets;

    public Stick(Point position) {
        this.position = position;
        socket = Socket.getCathode(new Point(position.x, position.y - 60));

        sockets = new ArrayList<>();
        sockets.add(socket);
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        socket.draw(g);
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
        socket.setPosition(new Point(position.x, position.y - 60));
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
