
package model;

import abstracts.JellyTableModel;
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

    @Override
    public JellyTableModel<Sapling> constructTableModel() {
        JellyTableModel<Sapling> jtm = new JellyTableModel<Sapling>(this.getObjects()) {

            @Override
            public Object[] constructRow(Sapling d) {
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
