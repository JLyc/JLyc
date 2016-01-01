package sk.trivial.DefendOfTheAnatolij.game.board.Gameboard;

import sk.trivial.DefendOfTheAnatolij.game.board.MainFrame.MainPanel;
import sk.trivial.DefendOfTheAnatolij.game.listeners.GameMouseListener.GameMouseListener;
import sk.trivial.DefendOfTheAnatolij.game.listeners.GameMouseMotionListener.GameMouseMotionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 * @author JLyc
 */
public class GameBoard extends Thread implements Runnable {

    private JFrame mainFrame = new JFrame();
    private MainPanel mainPanel = MainPanel.getInstance();

    /**
     * @Param gameBoardName meaningful name for searching in {@Link sk.trivial.DefendOfTheAnatolij.StartupMain} threadReferences
     */
    public GameBoard(String gameBoardName) {
        this.setName(gameBoardName);
    }

    @Override
    public void run() {
        createFrame();
    }

    private void createFrame() {
        mainFrame.setLayout(null);
        mainFrame.setBackground(Color.GRAY);
//        mainFrame.setSize(600, 650);
        mainFrame.setSize(500, 500);
        mainFrame.getRootPane().setContentPane(getLayoutPanel());
        mainFrame.setVisible(true);
        mainFrame.addMouseListener(new GameMouseListener());
    }

    private Container getLayoutPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.GRAY);
        mainPanel.setPreferredSize(new Dimension((int) (mainFrame.getWidth() * 0.72), (int) (mainFrame.getHeight() * 0.615)));
        mainPanel.setBackground(Color.GRAY);
        contentPanel.add(mainPanel);
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setVisible(false);
                new Thread(new GameDrawenObjects()).start();
            }
        });
        button.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(button);
        mainPanel.addMouseMotionListener(new GameMouseMotionListener());
        return contentPanel;
    }

}
