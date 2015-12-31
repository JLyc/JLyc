package sk.trivial.DefendOfTheAnatolij.game.board.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 */
public class MainFrame extends JFrame {
    private static int side = 20;
    private static int height = (int) Math.round(Math.tan(Math.toRadians(60)) * (side / 2));


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        int pointX = 100;
        int pointY = 100;
        try {
            InputStream pathToFile = this.getClass().getResourceAsStream("/dotaMap.jpg");
            System.out.println(pathToFile.available());
            Image image = ImageIO.read(pathToFile);
            g.drawImage(image, pointX, pointY, pointX + 12 * side-5, pointY + 12 * height, Color.white, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 6; j++) {
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

    private static Polygon generatePolygon(Point point) {
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
