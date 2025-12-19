package view.graphic.component;

import java.awt.*;

import view.graphic.GraphicObject;

public class JackLeg implements GraphicObject {
    private Point position;
    private int width;
    private int height;
    private Color color = Color.LIGHT_GRAY;
    
    public JackLeg(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    } 

    @Override
    public void draw(Graphics2D g) {
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
}
