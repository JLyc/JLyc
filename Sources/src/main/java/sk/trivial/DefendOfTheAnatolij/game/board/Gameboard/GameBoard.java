package sk.trivial.DefendOfTheAnatolij.game.board.Gameboard;

import sk.trivial.DefendOfTheAnatolij.game.board.MainFrame.MainFrame;
import sk.trivial.DefendOfTheAnatolij.game.listeners.GameMouseListener.GameMouseListener;
import sk.trivial.DefendOfTheAnatolij.game.listeners.GameMouseMotionListener.GameMouseMotionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 */
public class GameBoard extends Thread implements Runnable {

    private final JFrame mainFrame = new MainFrame();
    private final JPanel mainPanel = new JPanel();

    /**
     *  @Param gameBoardName meaningful name for searching in {@Link sk.trivial.DefendOfTheAnatolij.StartupMain} threadReferences
     */
    public GameBoard(String gameBoardName) {
        this.setName(gameBoardName);
    }

    @Override
    public void run() {
        createFrame();
    }

    private void createFrame() {
        mainFrame.setSize(500,500);
        mainFrame.getRootPane().setContentPane(getLayoutPanel());
        mainFrame.setVisible(true);
        mainFrame.addMouseListener(new GameMouseListener());
        mainFrame.addMouseMotionListener(new GameMouseMotionListener());
    }

    private Container getLayoutPanel() {
        mainPanel.setBounds((int) (mainFrame.getWidth()*0.1), (int) (mainFrame.getHeight()*0.1), (int) (mainFrame.getWidth()*0.8), (int) (mainFrame.getHeight()*0.8));
        mainPanel.setBackground(Color.BLACK);
        return mainPanel;
    }
}
