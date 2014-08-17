
package model;

import abstracts.JellyTableModel;
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

    @Override
    public JellyTableModel<SeedBundle> constructTableModel() {
        JellyTableModel<SeedBundle> jtm = new JellyTableModel<SeedBundle>(this.getObjects()) {

            @Override
            public Object[] constructRow(SeedBundle d) {
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
