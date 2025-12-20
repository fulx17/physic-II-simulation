package view.graphic.tool;
import java.awt.*;
import view.graphic.component.Wire;
public class Battery extends Wire{
    private int width = 120;
    private int height = 60;
    public Battery(Point position) {
        super(position);
        name = "Pin điện";
        jack1.setPosition(new Point(position.x - 90, position.y + 14));
        jack2.setPosition(new Point(position.x + 90, position.y + 14));
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
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawLine(
            position.x - width / 2,
            position.y,
            jack1.getPosition().x,
            jack1.getPosition().y - 14
        );

        g.setColor(Color.RED);
        g.drawLine(
            position.x + width / 2,
            position.y,
            jack2.getPosition().x,
            jack2.getPosition().y - 14
        );
        g.setColor(Color.CYAN);
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);
        g.fillRect(topLeftX, topLeftY, width, height);


        jack1.draw(g);
        jack2.draw(g);
    }
    @Override
    public void setPosition(Point worldPoint) {    
        position = worldPoint;
    }
}
