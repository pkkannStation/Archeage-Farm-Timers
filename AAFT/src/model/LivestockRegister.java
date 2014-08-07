
package model;

import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class LivestockRegister extends Register<Livestock> {
    
    public void create(String name, long growthTime, String climate) {
        Livestock l = new Livestock(name, growthTime, climate);
        insert(l);
    }
}
