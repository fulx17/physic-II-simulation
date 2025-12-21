package view.graphic.tool;

import java.awt.*;


public class Transformer extends ResistanceJacks{
    protected int width = 90;
    protected int height = 140; 
    public Transformer(Point position) {
        super(position);
        color = Color.ORANGE;
        name = "Lõi sắt từ";
        jack1.setPosition(new Point(position.x - 30, position.y));
        jack2.setPosition(new Point(position.x + 30, position.y));
    }

    @Override 
    public void draw(Graphics2D g) {

        position = new Point(jack1.getPosition().x + 30, jack1.getPosition().y);

        jack1.draw(g);
        jack2.draw(g);
        
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);
        
        g.setColor(Color.YELLOW);
        g.fillRect(position.x - 30, position.y - 30, 60, 60);
        
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
        jack1.setPosition(new Point(new Point(position.x - 30, position.y)));
        jack2.setPosition(new Point(new Point(position.x + 30, position.y)));
    }
}
