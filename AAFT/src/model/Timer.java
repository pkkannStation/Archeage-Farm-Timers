
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

    public Timer(Plantable plantable) {
        this.plantable = plantable;
        this.plantTime = new Date();
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
