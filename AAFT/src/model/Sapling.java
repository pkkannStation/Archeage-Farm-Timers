
package model;

import abstracts.Plantable;

/**
 *
 * @author Patrick
 */
public class Sapling extends Plantable {

    public Sapling(String name, long growthTime, String climate) {
        super(name, growthTime, climate);
        setClimateBonus(7);
    }

}
