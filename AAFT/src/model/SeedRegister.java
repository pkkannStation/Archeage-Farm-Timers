
package model;

import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class SeedRegister extends Register<Seed> {

    public void create(String name, long growthTime, String climate) {
        Seed s = new Seed(name, growthTime, climate);
        insert(s);
    }
}
