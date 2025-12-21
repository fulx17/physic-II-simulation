package view.graphic.tool;

import java.awt.*;


public class CapacitorJacksVertical extends ResistanceJacks{ 
    public CapacitorJacksVertical(Point position) {
        super(position);
        color = Color.ORANGE;
        name = "Tụ điện";
        width = 30;
        height = 120; 
        jack1.setPosition(new Point(position.x, position.y - height / 4));
        jack2.setPosition(new Point(position.x, position.y + height / 4));
    }

    @Override 
    public void draw(Graphics2D g) {

        position = new Point(jack1.getPosition().x, jack1.getPosition().y + height / 4);
        jack1.draw(g);
        jack2.draw(g);
        
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);
    }


    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        jack1.setPosition(new Point(position.x, position.y - height / 4));
        jack2.setPosition(new Point(position.x, position.y + height / 4));
    }
}
