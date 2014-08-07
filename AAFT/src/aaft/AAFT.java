package aaft;

import control.FileHandler;
import control.ViewController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.*;

/**
 *
 * @author Patrick
 */
public class AAFT {

    public static final String title = "Archeage Farm Timers";
    public static final String version = "1.0.0 Alpha";
    public static final String saveFolder = "data";
    public static BufferedImage icon;
    
    private final LivestockRegister livestockRegister;
    private final SaplingRegister saplingRegister;
    private final SeedRegister seedRegister;
    private final SeedBundleRegister seedBundleRegister;
    private final TimerRegister timerRegister;
    
    private final FileHandler fileHandler;
    private final ViewController viewController;
    

    public AAFT() throws IOException, ClassNotFoundException {
        makeIcon();
        livestockRegister = new LivestockRegister();
        saplingRegister = new SaplingRegister();
        seedRegister = new SeedRegister();
        seedBundleRegister = new SeedBundleRegister();
        timerRegister = new TimerRegister();
        
        fileHandler = new FileHandler(livestockRegister, saplingRegister, seedRegister, seedBundleRegister, timerRegister);
        fileHandler.load();
        viewController = new ViewController(timerRegister, seedRegister, seedBundleRegister, saplingRegister, livestockRegister, fileHandler);
    }
    
    private void makeIcon() throws IOException {
        icon = ImageIO.read(new File("res//AAIcon.png"));
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AAFT aaft = new AAFT();
        
        aaft.viewController.setFrameVisible(true);
    }

}
