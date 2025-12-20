package view.graphic.component;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import view.graphic.GraphicObject;

public class Wire implements GraphicObject{

    protected Jack jack1;
    protected Jack jack2;
    protected Point position;
    protected static int index = 0;
    protected Color[] colorList = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK};
    protected Color color;
    protected String name = "Dây cắm";

    public Wire(Point position) {
        this.position = position;
        index = (index + 1) % colorList.length;
        color = colorList[index];
        jack1 = new Jack(this, new Point(position.x - 30, position.y));
        jack2 = new Jack(this, new Point(position.x + 30, position.y));
    }

    public Color getColor() {
        return color;
    }
    
    public void setJack1(Jack j) {
        jack1 = j;
    }

    public void setJack2(Jack j) {
        jack2 = j;
    }

    public Jack getJack1() {
        return jack1;
    }
    public Jack getJack2() {
        return jack2;
    }

    public GraphicObject pick(Point worldPoint) {
        if (jack1.contains(worldPoint)) return jack1;
        if (jack2.contains(worldPoint)) return jack2;
        return this;
    }

    public boolean isPlugged() {
        return jack1.isPlugged() || jack2.isPlugged();
    }

    public Jack otherJack(Jack j) {
        if(j == jack1) return jack2;
        if(j == jack2) return jack1;
        return null;
    }


    @Override
    public boolean contains(Point worldPoint) {

        double x1 = jack1.getPosition().x;
        double y1 = jack1.getPosition().y - 14;
        
        double x2 = jack2.getPosition().x;
        double y2 = jack2.getPosition().y - 14;

        double tolerance = 5.0;

        double distance = Line2D.ptSegDist(x1, y1, x2, y2, worldPoint.x, worldPoint.y);

        return jack1.contains(worldPoint) || jack2.contains(worldPoint) || distance <= tolerance;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(
            jack1.getPosition().x,
            jack1.getPosition().y - 14,
            jack2.getPosition().x,
            jack2.getPosition().y - 14
        );
        jack1.draw(g);
        jack2.draw(g);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point worldPoint) {
        if(isPlugged()) return;
        Point p1 = jack1.getPosition();
        jack1.setPosition(new Point(p1.x + (worldPoint.x - position.x), p1.y + (worldPoint.y - position.y)));
        
        Point p2 = jack2.getPosition();
        jack2.setPosition(new Point(p2.x + (worldPoint.x - position.x), p2.y + (worldPoint.y - position.y)));
        
        
        position = worldPoint;
    }

    @Override
    public ArrayList<Socket> getSockets() {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }
}
