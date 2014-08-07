
package model;

import abstracts.Plantable;

/**
 *
 * @author Patrick
 */
public class Seed extends Plantable {

    public Seed(String name, long growthTime, String climate) {
        super(name, growthTime, climate);
        setClimateBonus(0.8f);
    }

}
