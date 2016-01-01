package sk.trivial.DefendOfTheAnatolij.game.board.Gameboard;

import sk.trivial.DefendOfTheAnatolij.game.board.MainFrame.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JLyc.Development@gmail.com on 1/1/2016.
 * @author JLyc
 */
public class GameDrawenObjects implements Runnable {
    private static GameDrawenObjects gameDrawenObjects = getInstance();
    private static final Graphics g = MainPanel.getInstance().getGraphics();
    private static int side = 20;
    private static int height = (int) Math.round(Math.tan(Math.toRadians(60)) * (side / 2));

    public static GameDrawenObjects getInstance() {
        if (gameDrawenObjects == null) gameDrawenObjects = new GameDrawenObjects();
        return gameDrawenObjects;
    }

    public static void drawHoneyComb(){
        GameDrawenObjects.getInstance().paintBackground();
    }

    @Override
    public void run() {
        drawHoneyComb();
    }

    public void paintBackground() {
//        Graphics g = MainPanel.getInstance().getGraphics();
        g.clearRect(0,0,MainPanel.getInstance().getWidth(),MainPanel.getInstance().getHeight());
        g.setColor(Color.white);
        int pointX = 0;
        int pointY = 0;
        try {
            InputStream pathToFile = this.getClass().getResourceAsStream("/dotaMap.jpg");
            Image image = ImageIO.read(pathToFile);
            g.drawImage(image, pointX, pointY, MainPanel.getInstance().getWidth(),MainPanel.getInstance().getHeight(), (img, infoflags, x, y, width, height1) -> false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 7; j++) {
                Point pointZ = new Point(pointX + (j * side * 3), pointY + (i * height));
                g.drawPolygon(generatePolygon(pointZ));
            }
            if(i%2==0){
                pointX += (side*1.5);

            }
            else {
                pointX -= (side*1.5);
            }

        }

    }

    public void paintHighlitedPolygon(Point point, Color color){
//        paintBackground();
        Color defaultColor = g.getColor();
        g.setColor(color);
//        g.drawPolygon(generatePolygon(new Point(point.x-1,point.y)));
//        g.drawPolygon(generatePolygon(new Point(point.x+1,point.y)));
//        g.drawPolygon(generatePolygon(new Point(point.x,point.y-1)));
//        g.drawPolygon(generatePolygon(new Point(point.x,point.y+1)));
        g.drawPolygon(generatePolygon(new Point(point.x,point.y)));
        g.setColor(defaultColor);
    }

    private Polygon generatePolygon(Point point) {
        int zeroX = point.x;
        int[] pointsX = {
                zeroX - side / 2,
                zeroX + side / 2,
                zeroX + side,
                zeroX + side / 2,
                zeroX - side / 2,
                zeroX - side
        };

        int zeroY = point.y;
        int[] pointsY = {
                zeroY - height,
                zeroY - height,
                zeroY,
                zeroY + height,
                zeroY + height,
                zeroY
        };

        return new Polygon(pointsX, pointsY, 6);
    }
}
