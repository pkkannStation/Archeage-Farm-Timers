
package model;

import abstracts.JellyTableModel;
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

    @Override
    public JellyTableModel<Livestock> constructTableModel() {
        JellyTableModel<Livestock> jtm = new JellyTableModel<Livestock>(this.getObjects()) {

            @Override
            public Object[] constructRow(Livestock d) {
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
