package sk.trivial.DefendOfTheAnatolij.game.board.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 */
public class MainPanel extends JPanel {
    private static MainPanel mainPanel;

    public static MainPanel getInstance() {
        if (mainPanel == null) mainPanel = new MainPanel();
        return mainPanel;
    }

    public MainPanel() {
        super(new BorderLayout());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
