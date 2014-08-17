package model;

import abstracts.JellyTableModel;
import abstracts.Plantable;
import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class TimerRegister extends Register<Timer> {

    public void create(Plantable plantable) {
        Timer t = new Timer(plantable);
        insert(t);
    }

    @Override
    public JellyTableModel<Timer> constructTableModel() {
        JellyTableModel<Timer> jtm = new JellyTableModel<Timer>(this.getObjects()) {

            @Override
            public Object[] constructRow(Timer d) {
                Object[] o = {d.getPlantable().getName(), "", ""};
                return o;
            }

            @Override
            public String[] constructColumns() {
                String[] s = {"Name", "Remaining time", "State"};
                return s;
            }
        };
        return jtm;
    }
    
}
