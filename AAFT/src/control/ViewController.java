package control;

import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import model.FavoritRegister;
import model.LivestockRegister;
import model.SaplingRegister;
import model.SeedBundleRegister;
import model.SeedRegister;
import model.TimerRegister;
import view.*;

/**
 *
 * @author Patrick
 */
public class ViewController {

    public static final int CREATETIMERVIEW = 1;
    public static final int NEWPLANTABLEVIEW = 2;
    public static final int DELETETIMERSVIEW = 3;

    private final HashMap<Integer, WindowConstants> viewMap;

    private MainView mainView;
    private CreateTimerView createTimerView;
    private NewPlantableView newPlantableView;
    private DeleteTimersView deleteTimersView;
    
    private TimerRegister timerRegister;
    private SeedRegister seedRegister;
    private SeedBundleRegister seedBundleRegister;
    private SaplingRegister saplingRegister;
    private LivestockRegister livestockRegister;
    private FavoritRegister favoritRegister;
    private FileHandler fileHandler;

    public ViewController(TimerRegister timerRegister, SeedRegister seedRegister, SeedBundleRegister seedBundleRegister, SaplingRegister saplingRegister, LivestockRegister livestockRegister, FavoritRegister favoritRegister, FileHandler fileHandler) {
        this.timerRegister = timerRegister;
        this.seedRegister = seedRegister;
        this.seedBundleRegister = seedBundleRegister;
        this.saplingRegister = saplingRegister;
        this.livestockRegister = livestockRegister;
        this.favoritRegister = favoritRegister;
        this.fileHandler = fileHandler;
        viewMap = new HashMap<>();
        initLookAndFeel();
        constructFrame();
        initViews();
    }

    private void initViews() {
        createTimerView = new CreateTimerView(mainView, true, this, seedRegister, seedBundleRegister, saplingRegister, livestockRegister, timerRegister, favoritRegister);
        newPlantableView = new NewPlantableView(mainView, true, this, seedRegister, seedBundleRegister, saplingRegister, livestockRegister);
        deleteTimersView = new DeleteTimersView(mainView, true, this, timerRegister);
        
        viewMap.put(CREATETIMERVIEW, createTimerView);
        viewMap.put(NEWPLANTABLEVIEW, newPlantableView);
        viewMap.put(DELETETIMERSVIEW, deleteTimersView);
    }

    private void constructFrame() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainView = new MainView(ViewController.this, timerRegister, favoritRegister, fileHandler);
            }
        });
    }
    
    public void setFrameVisible(boolean visible) {
        mainView.setVisible(visible);
    }

    public void setViewVisible(int id, boolean visible) {
        JDialog d = (JDialog) viewMap.get(id);
        d.setVisible(visible);
    }
    
    public JDialog getView(int id) {
        JDialog d = (JDialog) viewMap.get(id);
        return d;
    }
    
    public JFrame getMainView() {
        return mainView;
    }

    private void initLookAndFeel() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>
    }

}
