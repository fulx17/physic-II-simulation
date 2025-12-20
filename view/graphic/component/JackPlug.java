package view.graphic.component;

import java.awt.*;
import java.util.ArrayList;

public class JackPlug extends Jack {
    private Socket socket;
    private int radius = 13;

    public JackPlug(Wire wire, Point position, Socket socket) {
        super(wire, position);
        this.socket = socket;
    }

    @Override
    public boolean isPlugged() {
        return true;
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - radius;
        int topLeftY = position.y - radius;

        g.setColor(color);
        g.fillOval(topLeftX, topLeftY, 2 * radius, 2 * radius);
    }
    @Override
    public boolean contains(Point worldPoint) {
        return position.distance(worldPoint) <= radius;
    }

    @Override
    public ArrayList<Socket> getSockets() {
        return new ArrayList<>();
    }

    public Socket getSocket() {
        return socket;
    }
    
}
