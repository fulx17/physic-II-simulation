package view.graphic.component;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
public class Switch implements GraphicObject{

    private Point position;
    private String name = "Công tắc";
    private int width = 30;
    private int height = 15;
    private Color color = Color.RED;
    public Switch(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

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
