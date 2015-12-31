import org.junit.Test;
import sk.trivial.DefendOfTheAnatolij.StartupMain;

import static org.junit.Assert.*;

/**
 * Created by JLyc.Development@gmail.com on 12/31/2015.
 * @author JLyc
 */
public class StartupMainTest {

    @Test
    public void TestStartupMain(){
        StartupMain.main(null);

        //TODO nothing to test?
        //TODO one_thread_deadlock endless loop main mut contain another thread
        assertTrue(true);
        StartupMain.exit();
    }
}
