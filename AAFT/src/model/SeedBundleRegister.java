
package model;

import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class SeedBundleRegister extends Register<SeedBundle> {

    public void create(String name, long growthTime, String climate) {
        SeedBundle sb = new SeedBundle(name, growthTime, climate);
        insert(sb);
    }
}
