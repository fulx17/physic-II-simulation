package view.graphic;

import java.awt.*;

public interface GraphicObject {
    void draw(Graphics2D g);
    boolean contains(Point worldPoint);
    void setPosition(Point worldPoint);
    Point getPosition();
} 
