package sk.trivial.DefendOfTheAnatolij;

import sk.trivial.DefendOfTheAnatolij.game.board.Gameboard.GameBoard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 * @author JLyc
 */
public class StartupMain {
    private static boolean isRunning;

    private static Map<String, Runnable> threadReferences = new HashMap<>();

    static {
        //TODO placeholder for prestarting activities;
        isRunning = true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome of \n\t\"Defend ot the Anatolij\"");

        loadGameGUI();

        heartBeat();
        System.out.println("Good bye");
    }

    private static void loadGameGUI() {
        threadReferences.put("GameBoard", new GameBoard("GameBoard"));
        javax.swing.SwingUtilities.invokeLater(threadReferences.get("GameBoard"));
    }

    public static Runnable getThreadReferences(String instanceName) {
        return threadReferences.get(instanceName);
    }


    //     HeartBeat keep alive main thread until it's needed. Method {@link StartupMain#exit()}
     private static void heartBeat() {
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Heartbeat interrupted");
            }
        }
    }

    /**
     * If all other thread are dead, this method will close program
     */
    public static void exit() {
        isRunning = false;
    }
}
