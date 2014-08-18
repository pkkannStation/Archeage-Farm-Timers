
package model;

import abstracts.Plantable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Patrick
 */
public class Timer implements Serializable {
    
    private Plantable plantable;
    private Date plantTime;
    private boolean inClimate;

    public Timer(Plantable plantable, boolean inClimate) {
        this.plantable = plantable;
        this.inClimate = inClimate;
        this.plantTime = new Date();
    }

    public boolean isInClimate() {
        return inClimate;
    }

    public void setInClimate(boolean inClimate) {
        this.inClimate = inClimate;
    }

    public Plantable getPlantable() {
        return plantable;
    }

    public void setPlantable(Plantable plantable) {
        this.plantable = plantable;
    }

    public Date getPlantTime() {
        return plantTime;
    }

    public void setPlantTime(Date plantTime) {
        this.plantTime = plantTime;
    }
    
    @Override
    public String toString() {
        return plantable.toString();
    }
    
}
