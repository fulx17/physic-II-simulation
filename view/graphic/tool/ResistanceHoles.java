package view.graphic.tool;

import java.awt.*;
import view.graphic.component.Socket;

import view.graphic.GraphicObject;

public class ResistanceHoles implements GraphicObject{
    private Socket socket1, socket2;
    private Point position; 
    private Color color = Color.DARK_GRAY;
    
    //  metric
    private final int socketDistance = 60;
    private final int width = 120;
    private final int height = 60; 

    public ResistanceHoles(Point position) {
        this.position = position;
        socket1 = Socket.getCathode(new Point(position.x - socketDistance / 2, position.y));
        socket2 = Socket.getCathode(new Point(position.x + socketDistance / 2, position.y));
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        socket1.draw(g);
        socket2.draw(g);
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
        socket1.setPosition(new Point(position.x - socketDistance / 2, position.y));
        socket2.setPosition(new Point(position.x + socketDistance / 2, position.y));
    }

    @Override
    public Point getPosition() {
        return position;
    }
}
