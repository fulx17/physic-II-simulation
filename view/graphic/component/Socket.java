package view.graphic.component;

import java.awt.*;
import java.util.*;
import view.graphic.GraphicObject;

public class Socket implements GraphicObject{
    private Point position;
    private Color color;
    private Color innerColor = Color.GRAY;
    private ArrayList<JackPlug> jackList;
    private int radius = 15;
    private int innerRadius = 10;

    public Socket(Point position, Color color) {
        this.position = position;
        this.color = color;
        jackList = new ArrayList<>();
    } 
    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - radius;
        int topLeftY = position.y - radius;
        g.setColor(color);
        g.fillOval(topLeftX, topLeftY, 2 * radius, 2 * radius);

        int innerTopLeftX = position.x - innerRadius;
        int innerTopLeftY = position.y - innerRadius;
        g.setColor(innerColor);
        g.fillOval(innerTopLeftX, innerTopLeftY, 2 * innerRadius, 2 * innerRadius);
    }

    @Override
    public boolean contains(Point worldPoint) {
        double distance = position.distance(worldPoint);
        return distance <= radius;
    }

    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        for(JackPlug jp : jackList) {
            jp.setPosition(worldPoint);
        }
    }

    @Override
    public Point getPosition() {
        return position;
    }

    // add jack to list
    public void addJack(JackPlug j) {
        jackList.add(j);
    }
    
    public void delJack(JackPlug j) {
        jackList.remove(j);
    }

    // factory
    public static Socket getCathode(Point position) {
        return new Socket(position, Color.BLACK);
    }
    public static Socket getAnode(Point position) {
        return new Socket(position, Color.RED);
    }
}
