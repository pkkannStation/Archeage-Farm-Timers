
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.TimerRegister;
import view.MainView;

/**
 *
 * @author Patrick
 */
public class AutomaticTableUpdater implements Runnable {
    
    private boolean running = false;
    private Thread thread;
    private TimerRegister timerRegister;
    private ViewController viewController;

    public AutomaticTableUpdater(TimerRegister timerRegister, ViewController viewController) {
        this.timerRegister = timerRegister;
        this.viewController = viewController;
    }
    
    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop() {
        running = false;
        thread = null;
    }

    @Override
    public void run() {
        while(running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AutomaticTableUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
            timerRegister.refreshTableModel();
        }
    }

}
