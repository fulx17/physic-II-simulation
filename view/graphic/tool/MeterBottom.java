package view.graphic.tool;
import java.util.ArrayList;
import view.graphic.GraphicObject;
import view.graphic.component.Socket;
import java.awt.*;
import view.graphic.component.Clock;
public class MeterBottom implements GraphicObject{
    
    private Point position; 
    private int width = 120;
    private int height = 105;
    private String symbol;
    private String name;

    private Socket socket1;
    private Socket socket2;
    private Clock clock;

    private ArrayList<Socket> sockets;


    public MeterBottom(Point position, String symbol, String name, Boolean order) {
        this.position = position;
        this.symbol = symbol;
        this.name = name;
        sockets = new ArrayList<>();
        
        clock = new Clock(new Point(position.x, position.y - 15));
        if(order == true) {
            socket1 = Socket.getAnode(new Point(clock.getPosition().x - 45, clock.getPosition().y + 60));
            socket2 = Socket.getCathode(new Point(clock.getPosition().x + 45, clock.getPosition().y + 60));
        }
        else {
            socket1 = Socket.getCathode(new Point(clock.getPosition().x - 45, clock.getPosition().y + 60));
            socket2 = Socket.getAnode(new Point(clock.getPosition().x + 45, clock.getPosition().y + 60));    
        }

        sockets.add(socket1);
        sockets.add(socket2);
    }

    @Override
    public void draw(Graphics2D g) {
        clock.draw(g);
        socket1.draw(g);
        socket2.draw(g);


        g.setFont(new Font("Arial", Font.BOLD, 24)); 
        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int x = clock.getPosition().x - (fm.stringWidth(symbol) / 2);
        int y = (clock.getPosition().y - (fm.getHeight() / 2)) + fm.getAscent();
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
        clock.setPosition(new Point(position.x, position.y - 15));
        socket1.setPosition(new Point(clock.getPosition().x - 45, clock.getPosition().y + 60));
        socket2.setPosition(new Point(clock.getPosition().x + 45, clock.getPosition().y + 60));
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
