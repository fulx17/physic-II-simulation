package view.graphic.tool;

import java.awt.*;


public class CapacitorJacks extends ResistanceJacks{ 
    public CapacitorJacks(Point position) {
        super(position);
        color = Color.ORANGE;
        name = "Tụ điện";
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
}
