
package model;

import abstracts.JellyTableModel;
import abstracts.Plantable;
import abstracts.Register;

/**
 *
 * @author Patrick
 */
public class FavoritRegister extends Register<Favorit> {
    
    public void create(Plantable plantable) {
        Favorit f = new Favorit(plantable);
        insert(f);
    }

    @Override
    public JellyTableModel<Favorit> constructTableModel() {
        JellyTableModel<Favorit> jtm = new JellyTableModel<Favorit>(this.getObjects()) {

            @Override
            public Object[] constructRow(Favorit object) {
                Object[] o = {object.getPlantable().getName()};
                return o;
            }

            @Override
            public String[] constructColumns() {
                String[] s = {"Name"};
                return s;
            }
        };
        return jtm;
    }

}
