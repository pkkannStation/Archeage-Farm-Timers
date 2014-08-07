
package model;

import abstracts.Plantable;

/**
 *
 * @author Patrick
 */
public class Livestock extends Plantable {

    public Livestock(String name, long growthTime, String climate) {
        super(name, growthTime, climate);
        setClimateBonus(0.8f);
    }

}
