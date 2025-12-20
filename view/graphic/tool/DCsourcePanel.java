package view.graphic.tool;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import view.graphic.component.Knob;
import view.graphic.component.Socket;

import java.awt.*;
public class DCsourcePanel implements GraphicObject{

    private Point position;
    private int width = 150;
    private int height = 100;
    private String name = "Nguồn 1 chiều";
    private Socket socket1, socket2;
    private ArrayList<Socket> sockets;
    private Knob kn;
    private String symbol;

    public DCsourcePanel(Point position, String symbol) {
        this.position = position;
        this.symbol = symbol;
        socket1 = Socket.getCathode(new Point(position.x + 10, position.y - 5));
        socket2 = Socket.getAnode(new Point(position.x + 50, position.y - 5));
        kn = new Knob(new Point(position.x - 45, position.y));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
    }

    @Override
    public void draw(Graphics2D g) {
        socket1.draw(g);
        socket2.draw(g);
        kn.draw(g);

        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(Color.BLACK);
        g.drawRect(topLeftX, topLeftY, width, height);

        Point SPoint = new Point(position.x + 30, position.y + 35);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int x = SPoint.x - (fm.stringWidth(symbol) / 2);
        int y = (SPoint.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString(symbol, x, y);
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
        socket1.setPosition(new Point(position.x + 10, position.y - 5));
        socket2.setPosition(new Point(position.x + 50, position.y - 5));
        kn.setPosition(new Point(position.x - 45, position.y));
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
