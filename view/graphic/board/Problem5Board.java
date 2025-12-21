package view.graphic.board;

import java.awt.*;
import java.util.ArrayList;

import view.graphic.component.Socket;
import view.graphic.GraphicObject;


public class Problem5Board implements GraphicObject{
    private Point position; 
    private Color color = new Color(213, 213, 213);
    private ArrayList<Socket> sockets;
    private String name = "Bảng mạch";

    private Socket socket1, socket2, socket3, socket4, socket5, socket6, socket7, socket8, socket9, socket10, socket11, socket12, socket13, socket14, socket15; 
    
    //  metric
    private final int width = 800;
    private final int height = 500; 

    public Problem5Board(Point position) {
        this.position = position;

        socket1 = Socket.getAnode(new Point(position.x - 235, position.y - 155));

        socket2 = Socket.getAnode(new Point(position.x + 105, position.y - 155));
        socket3 = Socket.getCathode(new Point(position.x + 165, position.y - 155));

        socket4 = Socket.getAnode(new Point(position.x - 305, position.y - 30));
        socket5 = Socket.getCathode(new Point(position.x - 305, position.y + 30));

        socket6 = Socket.getCathode(new Point(position.x - 30, position.y));
        socket7 = Socket.getCathode(new Point(position.x + 30, position.y));
        
        socket8 = Socket.getAnode(new Point(position.x + 235, position.y - 30));
        socket9 = Socket.getCathode(new Point(position.x + 235, position.y + 30));
        socket10 = Socket.getAnode(new Point(position.x + 305, position.y - 30));
        socket11 = Socket.getCathode(new Point(position.x + 305, position.y + 30));

        socket12 = Socket.getCathode(new Point(position.x - 305, position.y + 160));
        socket13 = Socket.getCathode(new Point(position.x - 235, position.y + 160));
        socket14 = Socket.getCathode(new Point(position.x - 175, position.y + 160));
        socket15 = Socket.getCathode(new Point(position.x - 105, position.y + 160));
        
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
        sockets.add(socket11);
        sockets.add(socket12);
        sockets.add(socket13);
        sockets.add(socket14);
        sockets.add(socket15);
        
        
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(Color.BLACK);
        g.drawLine(position.x - 305, position.y - 155, socket1.getPosition().x, socket1.getPosition().y);
        g.drawLine(position.x - 305, position.y - 155, socket4.getPosition().x, socket4.getPosition().y);
        g.drawLine(socket5.getPosition().x, socket5.getPosition().y, socket12.getPosition().x, socket12.getPosition().y);
        g.drawLine(socket13.getPosition().x, socket13.getPosition().y, socket12.getPosition().x, socket12.getPosition().y);

        
        g.drawLine(socket14.getPosition().x, socket14.getPosition().y, socket15.getPosition().x, socket15.getPosition().y);
        
        g.drawLine(position.x - 30, position.y + 160, socket15.getPosition().x, socket15.getPosition().y);
        g.drawLine(position.x - 30, position.y + 160, socket6.getPosition().x, socket6.getPosition().y);
        
        g.drawLine(position.x - 30, position.y - 155, socket1.getPosition().x, socket1.getPosition().y);
        g.drawLine(position.x - 30, position.y - 155, socket6.getPosition().x, socket6.getPosition().y);

        g.drawLine(position.x + 30, position.y - 155, socket2.getPosition().x, socket2.getPosition().y);
        g.drawLine(position.x + 30, position.y - 155, socket7.getPosition().x, socket7.getPosition().y);

        g.drawLine(position.x + 30, position.y + 160, socket7.getPosition().x, socket7.getPosition().y);
        
        g.drawLine(position.x + 30, position.y + 160, position.x + 305, position.y + 160);
        g.drawLine(socket11.getPosition().x, socket11.getPosition().y, position.x + 305, position.y + 160);

        
        g.drawLine(socket3.getPosition().x, socket3.getPosition().y, position.x + 305, position.y - 155);
        g.drawLine(socket10.getPosition().x, socket10.getPosition().y, position.x + 305, position.y - 155);

        
        g.drawLine(socket8.getPosition().x, socket8.getPosition().y, position.x + 235, position.y - 155);
        
        g.drawLine(socket9.getPosition().x, socket9.getPosition().y, position.x + 235, position.y + 160);

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
        g.drawLine(socket13.getPosition().x, socket13.getPosition().y, socket14.getPosition().x, socket14.getPosition().y);

        
        g.drawLine(socket6.getPosition().x, socket6.getPosition().y, socket7.getPosition().x, socket7.getPosition().y);
        
        g.drawLine(socket8.getPosition().x, socket8.getPosition().y, socket9.getPosition().x, socket9.getPosition().y);
        g.drawLine(socket10.getPosition().x, socket10.getPosition().y, socket11.getPosition().x, socket11.getPosition().y);
        g.setStroke(old);

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
        socket1.setPosition(new Point(position.x - 235, position.y - 155));

        socket2.setPosition(new Point(position.x + 105, position.y - 155));
        socket3.setPosition(new Point(position.x + 165, position.y - 155));

        socket4.setPosition(new Point(position.x - 305, position.y - 30));
        socket5.setPosition(new Point(position.x - 305, position.y + 30));

        socket6.setPosition(new Point(position.x - 30, position.y));
        socket7.setPosition(new Point(position.x + 30, position.y));
        
        socket8.setPosition(new Point(position.x + 235, position.y - 30));
        socket9.setPosition(new Point(position.x + 235, position.y + 30));
        socket10.setPosition(new Point(position.x + 305, position.y - 30));
        socket11.setPosition(new Point(position.x + 305, position.y + 30));

        socket12.setPosition(new Point(position.x - 305, position.y + 160));
        socket13.setPosition(new Point(position.x - 235, position.y + 160));
        socket14.setPosition(new Point(position.x - 175, position.y + 160));
        socket15.setPosition(new Point(position.x - 105, position.y + 160));
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
