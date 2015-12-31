package sk.trivial.DefendOfTheAnatolij;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 * @author JLyc
 */
public class StartupMain {
    private static boolean isRunning;

    static {
        //TODO placeholder for prestarting activities;
        isRunning = true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to \n\t\"Defend ot the Anatolij\"");

        heartBeat();
        System.out.println("Good bye");
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
     * */
    public static void exit() {
        isRunning = false;
    }
}
