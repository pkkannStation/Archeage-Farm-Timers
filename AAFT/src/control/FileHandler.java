package control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Patrick
 */
public class FileHandler {

    private final LivestockRegister livestockRegister;
    private final SaplingRegister saplingRegister;
    private final SeedRegister seedRegister;
    private final SeedBundleRegister seedBundleRegister;
    private final TimerRegister timerRegister;
    
    private final String livestock = aaft.AAFT.saveFolder + "//livestocks.ser";
    private final String sapling = aaft.AAFT.saveFolder + "//saplings.ser";
    private final String seed = aaft.AAFT.saveFolder + "//seeds.ser";
    private final String seedBundle = aaft.AAFT.saveFolder + "//seedbundles.ser";
    private final String timer = aaft.AAFT.saveFolder + "//timers.ser";
    

    public FileHandler(LivestockRegister livestockRegister, SaplingRegister saplingRegister, SeedRegister seedRegister, SeedBundleRegister seedBundleRegister, TimerRegister timerRegister) {
        this.livestockRegister = livestockRegister;
        this.saplingRegister = saplingRegister;
        this.seedRegister = seedRegister;
        this.seedBundleRegister = seedBundleRegister;
        this.timerRegister = timerRegister;
        new File(aaft.AAFT.saveFolder).mkdir();
    }

    public void load() throws IOException, ClassNotFoundException {
        try {
            // Livestocks
            InputStream file = new FileInputStream(livestock);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            
            ArrayList<Livestock> livestocks = (ArrayList<Livestock>) input.readObject();
            livestockRegister.setObjects(livestocks);
            
            input.close();
            buffer.close();
            file.close();
            
            // Saplings
            file = new FileInputStream(sapling);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            
            ArrayList<Sapling> saplings = (ArrayList<Sapling>) input.readObject();
            saplingRegister.setObjects(saplings);
            
            input.close();
            buffer.close();
            file.close();
            
            // Seeds
            file = new FileInputStream(seed);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            
            ArrayList<Seed> seeds = (ArrayList<Seed>) input.readObject();
            seedRegister.setObjects(seeds);
            
            input.close();
            buffer.close();
            file.close();
            
            // SeedBundles
            file = new FileInputStream(seedBundle);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            
            ArrayList<SeedBundle> seedBundles = (ArrayList<SeedBundle>) input.readObject();
            seedBundleRegister.setObjects(seedBundles);
            
            input.close();
            buffer.close();
            file.close();
            
            // Timers
            file = new FileInputStream(timer);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            
            ArrayList<Timer> timers = (ArrayList<Timer>) input.readObject();
            timerRegister.setObjects(timers);
            
            input.close();
            buffer.close();
            file.close();
            
            System.out.println("Loaded");
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("Nothing to load");
        }
    }

    public void save() throws IOException {
        // Livestocks
        OutputStream file = new FileOutputStream(livestock);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        
        output.writeObject(livestockRegister.getObjects());
        
        output.close();
        buffer.close();
        file.close();
        
        // Saplings
        file = new FileOutputStream(sapling);
        buffer = new BufferedOutputStream(file);
        output = new ObjectOutputStream(buffer);
        
        output.writeObject(saplingRegister.getObjects());
        
        output.close();
        buffer.close();
        file.close();
        
        // Seeds
        file = new FileOutputStream(seed);
        buffer = new BufferedOutputStream(file);
        output = new ObjectOutputStream(buffer);
        
        output.writeObject(seedRegister.getObjects());
        
        output.close();
        buffer.close();
        file.close();
        
        // SeedsBundles
        file = new FileOutputStream(seedBundle);
        buffer = new BufferedOutputStream(file);
        output = new ObjectOutputStream(buffer);
        
        output.writeObject(seedBundleRegister.getObjects());
        
        output.close();
        buffer.close();
        file.close();
        
        // Timers
        file = new FileOutputStream(timer);
        buffer = new BufferedOutputStream(file);
        output = new ObjectOutputStream(buffer);
        
        output.writeObject(timerRegister.getObjects());
        
        output.close();
        buffer.close();
        file.close();
        
        System.out.println("Saved");
    }

}
