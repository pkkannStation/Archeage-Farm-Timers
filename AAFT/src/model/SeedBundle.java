
package model;

import abstracts.Plantable;

/**
 *
 * @author Patrick
 */
public class SeedBundle extends Plantable {

    public SeedBundle(String name, long growthTime, String climate) {
        super(name, growthTime, climate);
        setClimateBonus(7);
    }

}
