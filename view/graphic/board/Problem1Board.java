package view.graphic.board;

import java.awt.*;
import java.util.ArrayList;

import view.graphic.component.Socket;
import view.graphic.tool.DefinedSource;
import view.graphic.tool.FlowSource;
import view.graphic.tool.MeterBottom;
import view.graphic.GraphicObject;


public class Problem1Board implements GraphicObject{
    private Point position; 
    private Color color = new Color(213, 213, 213);
    private ArrayList<Socket> sockets;
    private String name = "Bảng mạch";

    private MeterBottom G;
    private MeterBottom mA;
    private DefinedSource ds;
    private FlowSource fs;
    
    private Socket socket1, socket2, socket3, socket4, socket5, socket6; 
    
    //  metric
    private final int width = 800;
    private final int height = 500; 

    public Problem1Board(Point position) {
        this.position = position;
        
        G = new MeterBottom(new Point(position.x - 260, position.y - 157), "G", "Điện kế", false);
        mA = new MeterBottom(new Point(position.x + 60, position.y - 157), "mA", "Miliampe kế", false);
        ds = new DefinedSource(new Point(position.x - 165, position.y + 55));
        fs = new FlowSource(new Point(position.x + 270, position.y + 55));

        socket1 = Socket.getAnode(new Point(position.x - 305, position.y + 195));
        socket2 = Socket.getAnode(new Point(position.x - 170, position.y + 195));
        socket3 = Socket.getCathode(new Point(position.x - 110, position.y + 195));
        socket4 = Socket.getAnode(new Point(position.x + 110, position.y + 195));
        socket5 = Socket.getCathode(new Point(position.x + 170, position.y + 195));
        socket6 = Socket.getCathode(new Point(position.x + 305, position.y + 195));
        
        sockets = new ArrayList<>();
        sockets.add(socket1);
        sockets.add(socket2);
        sockets.add(socket3);
        sockets.add(socket4);
        sockets.add(socket5);
        sockets.add(socket6);

        sockets.addAll(G.getSockets());
        sockets.addAll(mA.getSockets());
        sockets.addAll(ds.getSockets());
        sockets.addAll(fs.getSockets());
        
        
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(Color.BLACK);

        G.draw(g);
        mA.draw(g);
        ds.draw(g);
        fs.draw(g);

        g.drawLine(socket1.getPosition().x, socket1.getPosition().y, socket2.getPosition().x, socket2.getPosition().y);
        g.drawLine(socket3.getPosition().x, socket3.getPosition().y, socket4.getPosition().x, socket4.getPosition().y);
        g.drawLine(socket5.getPosition().x, socket5.getPosition().y, socket6.getPosition().x, socket6.getPosition().y);

        Stroke old = g.getStroke();
        g.setStroke(new BasicStroke(10));
        g.setColor(Color.BLACK);
        g.drawRect(topLeftX, topLeftY, width, height);
        
        
        float[] dash = {5f, 5f}; 
        g.setStroke(new BasicStroke(
            3f,                         
            BasicStroke.CAP_BUTT,       
            BasicStroke.JOIN_MITER,    
            10f,                        
            dash,                      
            0f                          
        ));
        
        g.drawLine(socket2.getPosition().x, socket2.getPosition().y, socket3.getPosition().x, socket3.getPosition().y);
        g.drawLine(socket4.getPosition().x, socket4.getPosition().y, socket5.getPosition().x, socket5.getPosition().y);
        g.setStroke(old);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
        socket4.draw(g);
        socket5.draw(g);
        socket6.draw(g);
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
        G.setPosition(new Point(position.x - 260, position.y - 157));
        mA.setPosition(new Point(position.x + 60, position.y - 157));
        ds.setPosition(new Point(position.x - 165, position.y + 55));
        fs.setPosition(new Point(position.x + 270, position.y + 55));

        socket1.setPosition(new Point(position.x - 305, position.y + 195));
        socket2.setPosition(new Point(position.x - 170, position.y + 195));
        socket3.setPosition(new Point(position.x - 110, position.y + 195));
        socket4.setPosition(new Point(position.x + 110, position.y + 195));
        socket5.setPosition(new Point(position.x + 170, position.y + 195));
        socket6.setPosition(new Point(position.x + 305, position.y + 195));
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
