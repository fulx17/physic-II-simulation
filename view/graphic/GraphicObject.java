package view.graphic;

import java.awt.*;

import java.util.*;
import view.graphic.component.Socket;

public interface GraphicObject {
    void draw(Graphics2D g);
    boolean contains(Point worldPoint);
    void setPosition(Point worldPoint);
    Point getPosition();
    ArrayList<Socket> getSockets();
    String getName();
} 
