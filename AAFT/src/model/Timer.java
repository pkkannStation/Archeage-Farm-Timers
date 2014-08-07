
package model;

import abstracts.Plantable;
import java.io.Serializable;

/**
 *
 * @author Patrick
 */
public class Timer implements Serializable {
    
    private Plantable plantable;

    public Timer(Plantable plantable) {
        this.plantable = plantable;
    }

    public Plantable getPlantable() {
        return plantable;
    }

    public void setPlantable(Plantable plantable) {
        this.plantable = plantable;
    }
    
    

}
