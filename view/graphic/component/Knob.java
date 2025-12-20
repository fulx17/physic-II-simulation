package view.graphic.component;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
public class Knob implements GraphicObject{

    private Point position;
    private String name = "Đồng hồ";
    private int radius = 20;
    private Color color = Color.BLACK;
    public Knob(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - radius;
        int topLeftY = position.y - radius;
        g.setColor(color);
        g.fillOval(topLeftX, topLeftY, 2 * radius, 2 * radius);
    }
    
    @Override
    public boolean contains(Point worldPoint) {
        double distance = position.distance(worldPoint);
        return distance <= radius;
    }
   
    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
    }
    
    @Override
    public Point getPosition() {
        return position;
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
