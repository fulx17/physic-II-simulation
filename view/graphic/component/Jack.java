package view.graphic.component;

import view.graphic.GraphicObject;
import java.awt.*;

public class Jack implements GraphicObject{
    protected Wire wire;
    protected Point position;
    protected Color color;

    private JackLeg leg;

    private final int width = 20;
    private final int height = 30; 

    public Jack(Wire wire, Point position) {
        this.wire = wire;
        this.position = position;
        leg = new JackLeg(new Point(position.x, position.y + 3 * height / 4 ), width / 2, height / 2);
        color = wire.getColor();
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        leg.draw(g);
        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);
    }

    @Override
    public boolean contains(Point worldPoint) {
        int left = position.x - width / 2;
        int right = position.x + width / 2;
        int top = position.y - height / 2;
        int bottom = position.y + height / 2;
        return (worldPoint.x >= left && worldPoint.x <= right) && (worldPoint.y >= top  && worldPoint.y <= bottom) || leg.contains(worldPoint);
    }
    
    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        leg.setPosition(new Point(position.x, position.y + 3 * height / 4));
    }
    
    @Override
    public Point getPosition() {
        return position;
    }

    public boolean isPlugged() {
        return false;
    }
    
    public Wire getWire() {
        return wire;
    }
}
