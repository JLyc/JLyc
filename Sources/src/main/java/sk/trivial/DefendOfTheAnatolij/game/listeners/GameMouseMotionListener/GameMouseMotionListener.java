package sk.trivial.DefendOfTheAnatolij.game.listeners.GameMouseMotionListener;

import sk.trivial.DefendOfTheAnatolij.game.board.Gameboard.GameDrawenObjects;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 */
public class GameMouseMotionListener implements MouseMotionListener {
    private static int side = 20;
    private static int height = (int) Math.round(Math.tan(Math.toRadians(60)) * (side / 2));
    private static Point previousPoint = new Point(0, 0);

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point point = e.getPoint();
        Point newPoint = getPointX(point.x, point.y);
//        System.out.println(newPoint);
        if(!newPoint.equals(previousPoint)){
            GameDrawenObjects.getInstance().paintHighlitedPolygon(previousPoint, Color.WHITE);
            GameDrawenObjects.getInstance().paintHighlitedPolygon(newPoint, Color.RED);
            previousPoint=newPoint;
        }
    }

    public Point getPointX(int x, int y) {
        //0 30 60 90 120
        int rangeX = (int) Math.round(side * 1.5);
        int roundedPointX = x / rangeX;
//        System.out.println(roundedPoint);
        int offsetX = x % rangeX;
        int realPointX = (offsetX-(rangeX/2)<0)? roundedPointX*rangeX:(roundedPointX*rangeX)+rangeX;
        //0 10 20 30 40 50
        if (!(((realPointX / rangeX) % 2) == 0)) {
            y += height;
        }
        int rangeY = (int) Math.round(height*2);
        int roundedPointY = y / rangeY;
        int offsetY = y % rangeY;
        int realPointY = (offsetY-(rangeY/2)<0)? roundedPointY*rangeY:(roundedPointY*rangeY)+rangeY;
        if (!(((realPointX / rangeX) % 2) == 0)) {
            realPointY -= 0.5*rangeY;
        }
        return new Point(realPointX,realPointY);
    }
}
