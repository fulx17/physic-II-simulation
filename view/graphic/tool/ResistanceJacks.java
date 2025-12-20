package view.graphic.tool;

import java.awt.*;

import view.graphic.component.Wire;

public class ResistanceJacks extends Wire{
    protected int width = 120;
    protected int height = 30; 
    public ResistanceJacks(Point position) {
        super(position);
        color = new Color(133, 133, 133);
        name = "Điện trở";
        jack1.setPosition(new Point(position.x - width / 4, position.y));
        jack2.setPosition(new Point(position.x + width / 4, position.y));
    }

    @Override 
    public void draw(Graphics2D g) {

        position = new Point(jack1.getPosition().x + width / 4, jack1.getPosition().y);

        jack1.draw(g);
        jack2.draw(g);
        
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
        return (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom) || jack1.contains(worldPoint) || jack2.contains(worldPoint);
    }

    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        jack1.setPosition(new Point(new Point(position.x - width / 4, position.y)));
        jack2.setPosition(new Point(new Point(position.x + width / 4, position.y)));
    }
}
