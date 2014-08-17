
package model;

import abstracts.JellyTableModel;
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

    @Override
    public JellyTableModel<Seed> constructTableModel() {
        JellyTableModel<Seed> jtm = new JellyTableModel<Seed>(this.getObjects()) {

            @Override
            public Object[] constructRow(Seed d) {
                Object[] o = {d.getName(), d.getGrowthTime(), d.getClimate()};
                return o;
            }

            @Override
            public String[] constructColumns() {
                String[] s = {"Name", "Growth time", "Climate"};
                return s;
            }
        };
        return jtm;
    }
}
