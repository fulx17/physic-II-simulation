package view.graphic.tool;
import java.util.ArrayList;
import view.graphic.component.Socket;
import view.graphic.GraphicObject;
import java.awt.*;
public class ElectricMeter implements GraphicObject{

    private Point position;
    private String name = "Điện trường kế";
    private int width = 300;
    private int height = 160;
    private Socket socket1, socket2, socket3;
    private ArrayList<Socket> sockets;
    private Color color = new Color(207, 207, 207);
    public ElectricMeter(Point position) {
        this.position = position;
        socket1 = Socket.getAnode(new Point(position.x - 110, position.y - 40));
        socket2 = Socket.getCathode(new Point(position.x - 110, position.y + 40));
        socket3 = Socket.getCathode(new Point(position.x + 95, position.y - 115));

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
        g.fillRect(topLeftX, topLeftY, width, height);

        topLeftX = socket3.getPosition().x - (70 / 2);
        topLeftY = socket3.getPosition().y - (70 / 2);
        g.fillRect(topLeftX, topLeftY, 70, 70);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);


    }
    
    @Override
    public boolean contains(Point worldPoint) {
        int left = position.x - width / 2;
        int right = position.x + width / 2;
        int top = position.y - height / 2;
        int bottom = position.y + height / 2;
        boolean rec1 = (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom);

        left = socket3.getPosition().x - 70 / 2;
        right = socket3.getPosition().x + 70 / 2;
        top = socket3.getPosition().y - 70 / 2;
        bottom = socket3.getPosition().y + 70 / 2;
        boolean rec2 = (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom);
        
        return rec1 || rec2;
    }
   
    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        socket1.setPosition(new Point(position.x - 110, position.y - 40));
        socket2.setPosition(new Point(position.x - 110, position.y + 40));
        socket3.setPosition(new Point(position.x + 95, position.y - 115));
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
