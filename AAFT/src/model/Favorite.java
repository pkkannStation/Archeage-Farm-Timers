
package model;

import abstracts.Plantable;
import java.io.Serializable;

/**
 *
 * @author Patrick
 */
public class Favorite implements Serializable {
    
    private Plantable plantable;

    public Favorite(Plantable plantable) {
        this.plantable = plantable;
    }

    public Plantable getPlantable() {
        return plantable;
    }

    public void setPlantable(Plantable plantable) {
        this.plantable = plantable;
    }
    
    @Override
    public String toString() {
        return plantable.getName();
    }

}
