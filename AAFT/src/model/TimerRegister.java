package model;

import abstracts.Plantable;
import abstracts.Register;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Patrick
 */
public class TimerRegister extends Register<Timer> {

    private DefaultTableModel dtm;

    public void create(Plantable plantable) {
        Timer t = new Timer(plantable);
        insert(t);
        addRowToModel(t.getPlantable().getName(), "", "");
    }

    public DefaultTableModel getTableModel() {
        makeTableModel();
        return dtm;
    }

    public void addRowToModel(String name, String remainingTime, String state) {
        makeTableModel();
        String[] row = {name, remainingTime, state};
        dtm.addRow(row);
        dtm.fireTableDataChanged();
    }
    
    public void refreshModel() {
        dtm.fireTableDataChanged();
    }

    private void makeTableModel() {
        if (dtm == null) {
            dtm = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            String[] columns = {"Name", "Remaining time", "State"};
            dtm.setColumnIdentifiers(columns);

            Iterator<Timer> timers = getObjects().iterator();
            while (timers.hasNext()) {
                Timer t = timers.next();
                String[] row = {t.getPlantable().getName(), "", ""};
                dtm.addRow(row);
            }
        }
    }
}
