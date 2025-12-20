package view.graphic.component;
import java.util.ArrayList;

import view.graphic.GraphicObject;
import java.awt.*;
public class Clock implements GraphicObject{

    private Point position;
    private String name = "Đồng hồ";
    private int width = 120;
    private int height = 80; 
    private int gap = 10;
    public Clock(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(Color.WHITE);
        int innerTopLeftX = position.x - (width / 2) + gap;
        int innerTopLeftY = position.y - (height / 2) + gap;
        g.fillRect(innerTopLeftX, innerTopLeftY, width - 2 * gap, height - 2 * gap);
        

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
