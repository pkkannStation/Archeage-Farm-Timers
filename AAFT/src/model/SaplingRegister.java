
package model;

import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class SaplingRegister extends Register<Sapling> {

    public void create(String name, long growthTime, String climate) {
        Sapling s = new Sapling(name, growthTime, climate);
        insert(s);
    }
}
