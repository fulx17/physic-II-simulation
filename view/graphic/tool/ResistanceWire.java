package view.graphic.tool;

import java.awt.*;

import view.graphic.component.Socket;


public class ResistanceWire extends WireTube{
    private Socket socket3;
    public ResistanceWire(Point position) {
        super(position);
        socket3 = Socket.getCathode(position);
        sockets.add(socket3);
    }

    @Override
    public void draw(Graphics2D g) {
        int topLeftX = position.x - (width / 2);
        int topLeftY = position.y - (height / 2);

        g.setColor(color);
        g.fillRect(topLeftX, topLeftY, width, height);

        g.setColor(new Color(213, 213, 213));
        g.fillRect(position.x - 15, position.y - 15, 30, 30);

        socket1.draw(g);
        socket2.draw(g);
        socket3.draw(g);
    }

    @Override
    public void setPosition(Point worldPoint) {
        position = worldPoint;
        socket1.setPosition(new Point(position.x - width / 2 + 15, position.y));
        socket2.setPosition(new Point(position.x + width / 2 - 15, position.y));
        socket3.setPosition(position);
    }
}
