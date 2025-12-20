package view.graphic.tool;
import java.util.ArrayList;
import view.graphic.component.Socket;
import view.graphic.GraphicObject;
import java.awt.*;
import view.graphic.component.Knob;
import view.graphic.component.Switch;
public class DCACsource implements GraphicObject{

    private Point position;
    private String name = "Nguồn";
    private ArrayList<Socket> sockets;
    private Color color;
    private int width = 150;
    private int height = 200;
    
    private Socket socket1, socket2, socket3, socket4;
    private Switch sw;
    private Knob kn;
    public DCACsource(Point position) {
        this.position = position;
        color = new Color(213, 213, 213);
        socket1 = Socket.getAnode(new Point(position.x + 50, position.y - 75));
        socket2 = Socket.getCathode(new Point(position.x + 50, position.y - 25));
        socket3 = Socket.getCathode(new Point(position.x + 50, position.y + 25));
        socket4 = Socket.getCathode(new Point(position.x + 50, position.y + 75));
        sw = new Switch(new Point(position.x - 40, position.y + 50));
        kn = new Knob(new Point(position.x - 45, position.y - 50));

        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
        sockets.add(socket4);
    }

    @Override
    public void draw(Graphics2D g) {
        
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(Color.BLUE);
        g.drawRect(topLeftX, topLeftY, width, height);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
        socket4.draw(g);
        kn.draw(g);
        sw.draw(g);
        Point DCPosition = new Point(position.x + 10, position.y - 50);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int x = DCPosition.x - (fm.stringWidth("DC") / 2);
        int y = (DCPosition.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("DC", x, y);

        Point ACPosition = new Point(position.x + 10, position.y + 50);
        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        fm = g.getFontMetrics();
        x = ACPosition.x - (fm.stringWidth("AC") / 2);
        y = (ACPosition.y - (fm.getHeight() / 2)) + fm.getAscent();
        g.drawString("AC", x, y);
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
        socket1.setPosition(new Point(position.x + 50, position.y - 75));
        socket2.setPosition(new Point(position.x + 50, position.y - 25));
        socket3.setPosition(new Point(position.x + 50, position.y + 25));
        socket4.setPosition(new Point(position.x + 50, position.y + 75));
        sw.setPosition(new Point(position.x - 40, position.y + 50));
        kn.setPosition(new Point(position.x - 45, position.y - 50));
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
